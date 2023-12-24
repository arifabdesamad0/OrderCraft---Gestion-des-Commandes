package com.artwood.Dao;

import com.artwood.model.Order;
import java.util.List;

public interface OrderDao {

    void addOrder(Order order);


    Order getOrder(long id);


    void updateOrder(Order order);


    void deleteOrder(long id);



}
