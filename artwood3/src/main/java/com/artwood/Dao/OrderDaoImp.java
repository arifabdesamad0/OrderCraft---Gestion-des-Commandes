package com.artwood.Dao;

import com.artwood.model.Item;
import com.artwood.model.Order;
import org.titans.util.DBConnection;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImp implements OrderDao {

    @Override
    public static void addOrder(Order order) {
        String sql = "INSERT INTO orders (client_id, date, status) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnectionDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, order.getClientId());
            pstmt.setDate(2, Date.valueOf(order.getDate())); // Assuming 'date' is a LocalDate
            pstmt.setString(3, order.getStatus());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle or rethrow the exception as needed
        }
    }

    @Override
    public Order getOrder(long id) {
        String sql = "SELECT * FROM orders WHERE id = ?";
        try (Connection conn = DBConnection.getConnectionDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Order order = new Order();
                order.setId(rs.getLong("id"));
                order.setClientId(rs.getInt("client_id"));

                order.setDate(rs.getDate("date").toLocalDate()); // Convert java.sql.Date to LocalDate
                order.setStatus(rs.getString("status"));
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle or rethrow the exception as needed
        }
        return null;
    }

    @Override
    public void updateOrder(Order order) {
        String sql = "UPDATE orders SET client_id = ?, date = ?, status = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnectionDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, order.getClientId());
            pstmt.setDate(2, Date.valueOf(order.getDate()));
            pstmt.setString(3, order.getStatus());
            pstmt.setLong(4, order.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle or rethrow the exception as needed
        }
    }

    @Override
    public void deleteOrder(long id) {
        String sql = "DELETE FROM orders WHERE id = ?";
        try (Connection conn = DBConnection.getConnectionDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle or rethrow the exception as needed
        }
    }
    public static String addDBO(ArrayList<Item> items , int Order , int[] quantity)
    {
        try (Connection conn = DBConnection.getConnectionDB()){

            for (int i = 0; i < items.size(); i++) {

                String insert = "INSERT INTO order_items (order_id,item_id,quantity	) VALUES ('"+Order+","+items.get(i).getId()+","+quantity[i]+"')";
                PreparedStatement preparedStatement = conn.prepareStatement(insert);
                preparedStatement.executeUpdate();

            }


            return "commande inserted into the database successfully";
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error inserting user into the database.");
        }
        return null ;
    }

    }

