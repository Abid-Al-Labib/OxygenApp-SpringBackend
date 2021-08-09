package com.oxygen.oxygenApp.services;

import com.oxygen.oxygenApp.entities.Distributor;
import com.oxygen.oxygenApp.entities.Order;

import java.util.Date;
import java.util.List;

public interface OrderService {

    String makeOrder(String type,String size, String sender, String receiver, Integer quantity, String date, Integer distributorId);
    Order createOrderForDistributor(Distributor distributor, String consumer, Integer quantity, String date, String type, String size);
    List<Order> getOrderByType(String type);
    List<Order> getOrderByDate(String date);
    List<Order> getOrderByDistributorId(Integer id);
    String removeOrderById(Integer id);

}
