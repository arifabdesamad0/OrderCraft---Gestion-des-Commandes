package com.artwood.Dao;

import com.artwood.model.User;
import org.titans.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao {

    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnectionDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword()); // Assuming the password is already hashed
            pstmt.setString(3, user.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle or rethrow the exception as needed
        }
    }

    @Override
    public User getUser(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection conn = DBConnection.getConnectionDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle or rethrow the exception as needed
        }
        return null;
    }

    @Override
    public void deletUser(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DBConnection.getConnectionDB()){
             PreparedStatement pst = conn.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
@Override
public void updateUser(int id, User userUpdated) {
    String sql = "UPDATE users SET username = ?, password = ?, email = ? WHERE id = ?";
    try (Connection conn = DBConnection.getConnectionDB();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, userUpdated.getUsername());
        pstmt.setString(2, userUpdated.getPassword()); // Assuming the password is already hashed
        pstmt.setString(3, userUpdated.getEmail());
        pstmt.setInt(4, id); // Set the id for the WHERE clause

        int affectedRows = pstmt.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Updating user failed, no rows affected.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle or rethrow the exception as needed
    }
}
    public static User login(String login , String motPass)
    {
        try (Connection conn = DBConnection.getConnectionDB()){
            String selectQuery = "SELECT * FROM users WHERE email = ? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);

            preparedStatement.setString(1, login);
            preparedStatement.setString(2, motPass);
            ResultSet resultSet = preparedStatement.executeQuery();

            User user = null;
            if (resultSet.next())
            {
                user = new User(resultSet.getInt("id"),resultSet.getString("login"),resultSet.getString("password"),resultSet.getString("role"));
                System.out.println(" vous avez login");
            }else{
                System.out.println("Wrong login or password !");
            }

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection conn = DBConnection.getConnectionDB();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password")); // Be cautious with password data
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle or rethrow the exception as needed
        }
        return users;
    }


    }





