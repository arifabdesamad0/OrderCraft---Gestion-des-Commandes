package com.artwood.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Order {
    private long id;

    public int getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private int clientId;
    private LocalDate date;
    private String status; // Consider changing to an enum for predefined status values
    private ArrayList<Item>items;
    public Order() {
        // Default constructor
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public Order(int clientId, LocalDate date, String status) {
        this.clientId = clientId;
        this.date = date;
        this.status = status;
        this.items=new ArrayList<Item>();
    }

    // Existing getters and setters

    // Additional methods
    public String getFormattedDate() {
        // Example method to get formatted date string
        return date.format(java.time.format.DateTimeFormatter.ISO_LOCAL_DATE);
    }

    // Example business logic method (implement as needed)
    public void updateStatus(String newStatus) {
        // Validate and update status
        // Ensure newStatus is valid
        this.status = newStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", date=" + getFormattedDate() +
                ", status='" + status + '\'' +
                '}';
    }

    // Equals and hashCode can be overridden for better data comparison and hashing
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return id == order.id &&
                clientId == order.clientId &&
                Objects.equals(date, order.date) &&
                Objects.equals(status, order.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, date, status);
    }
}
