package com.artwood.model;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class User {

    private long id;
    private String username;
    private String password; // Hashed password
    private String email;

    // No-argument constructor
    public User() {
    }

    // Parameterized constructor
    public User(long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.setPassword(password); // This will hash the password
        this.email = email;
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }



    // Return the hashed password - consider security implications based on your use case
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Hashes the password before setting it
    public void setPassword(String password) {
        this.password = hashPassword(password);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Helper method to hash a password
    private String hashPassword(String password) {
        try {
            // Specify the hash parameters
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

            // Generate the hash
            byte[] hash = factory.generateSecret(spec).getEncoded();
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException("Error while hashing the password", e);
        }
    }

    // Consider overriding toString for debugging purposes (but be careful not to expose sensitive data)
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
