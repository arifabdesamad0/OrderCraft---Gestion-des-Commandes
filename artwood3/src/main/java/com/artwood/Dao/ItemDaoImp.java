package com.artwood.Dao;

import com.artwood.model.Item;
import org.titans.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImp implements ItemDao {

    @Override
    public void addItem(Item item) {
        String sql = "INSERT INTO items (name, price, description, quantity) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnectionDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, item.getName());
            pstmt.setDouble(2, item.getPrice());
            pstmt.setString(3, item.getDescription());
            pstmt.setInt(4, item.getQuantity());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle or rethrow the exception as needed
        }
    }

    @Override
    public Item getItem(int id) {
        String sql = "SELECT * FROM items WHERE id = ?";
        try (Connection conn = DBConnection.getConnectionDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Item(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("description"),
                        rs.getInt("quantity")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle or rethrow the exception as needed
        }
        return null;
    }

    @Override
    public void updateItem(Item item) {
        String sql = "UPDATE items SET name = ?, price = ?, description = ?, quantity = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnectionDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, item.getName());
            pstmt.setDouble(2, item.getPrice());
            pstmt.setString(3, item.getDescription());
            pstmt.setInt(4, item.getQuantity());
            pstmt.setInt(5, item.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle or rethrow the exception as needed
        }
    }

    @Override
    public void deleteItem(int id) {
        String sql = "DELETE FROM items WHERE id = ?";
        try (Connection conn = DBConnection.getConnectionDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle or rethrow the exception as needed
        }
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM items";
        try (Connection conn = DBConnection.getConnectionDB();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                items.add(new Item(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("description"),
                        rs.getInt("quantity")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle or rethrow the exception as needed
        }
        return items;


    }



    public static  ArrayList<Item> getAll()
    {
        try (Connection conn = DBConnection.getConnectionDB()){
            String selectQuery = "SELECT * FROM items";

            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Item> items = new ArrayList<Item>();
            while (resultSet.next())
            {
                Item article = new Item(resultSet.getString("id"),resultSet.getInt("quantity"),resultSet.getString("nom"), resultSet.getInt("id"));
                items.add(article);
            }
            return items ;
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }public static Item searchItemByName(String itemName) {
        String sql = "SELECT * FROM items WHERE name = ?";
        try (Connection conn = DBConnection.getConnectionDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, itemName);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Item item = new Item();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setPrice(rs.getDouble("price"));
                item.setDescription(rs.getString("description"));
                item.setQuantity(rs.getInt("quantity"));
                return item;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle or rethrow the exception as needed
        }
        return null;
    }
}

