package com.artwood.Dao;

import com.artwood.model.Client;
import org.titans.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImp implements ClientDao {

    @Override
    public void addClient(Client client) {
        String sql = "INSERT INTO clients (name, email) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnectionDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, client.getName());
            pstmt.setString(2, client.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle or rethrow the exception as needed
        }
    }

    @Override
    public Client getClient(long id) {
        String sql = "SELECT * FROM clients WHERE id = ?";
        try (Connection conn = DBConnection.getConnectionDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Client client = new Client();
                client.setId(rs.getLong("id"));
                client.setName(rs.getString("name"));
                client.setEmail(rs.getString("email"));
                return client;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle or rethrow the exception as needed
        }
        return null;
    }

    @Override
    public void updateClient(Client client) {
        String sql = "UPDATE clients SET name = ?, email = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnectionDB()){
             PreparedStatement pstmt = conn.prepareStatement(sql) ;

            pstmt.setString(1, client.getName());
            pstmt.setString(2, client.getEmail());
            pstmt.setLong(3, client.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle or rethrow the exception as needed
        }
    }

        @Override
    public void deleteClient(long id) {
        String sql = "DELETE FROM clients WHERE id = ?";
        try (Connection conn = DBConnection.getConnectionDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle or rethrow the exception as needed
        }
    }
    public static ArrayList<Client> getAllClients() {
        ArrayList<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM clients";
        try (Connection conn = DBConnection.getConnectionDB();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getLong("id"));
                client.setName(rs.getString("name"));
                client.setEmail(rs.getString("email"));
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle or rethrow the exception as needed
        }
        return clients;
    }
    public static Client searchByEmail(String email) {
        String sql = "SELECT * FROM clients WHERE email = ?";
        try (Connection conn = DBConnection.getConnectionDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Client client = new Client();
                client.setId(rs.getLong("id"));
                client.setName(rs.getString("name"));
                client.setEmail(rs.getString("email"));
                return client;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle or rethrow the exception as needed
        }
        return null;
    }
}
