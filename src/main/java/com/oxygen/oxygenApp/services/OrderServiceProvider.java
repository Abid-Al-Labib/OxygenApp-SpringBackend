package com.oxygen.oxygenApp.services;

import com.oxygen.oxygenApp.entities.Distributor;
import com.oxygen.oxygenApp.entities.Order;
import com.oxygen.oxygenApp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class OrderServiceProvider implements OrderService {

    @Autowired
    OrderRepository orderRepository;


    public String makeOrder(String type, String size, String sender, String receiver, Integer quantity, String dateString, Integer distributorId)
    {

        try {
//            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
            Order newOrder = new Order(type, size, sender, receiver, quantity, dateString, distributorId);
            orderRepository.save(newOrder);
            return "New order created";
        }
        catch (Exception e)
        {
            return e.getMessage();
        }

    }

    @Override
    public Order createOrderForDistributor(Distributor distributor, String consumer, Integer quantity, String date, String type, String size)
    {

        System.out.println(type);
        String sender_name;
        String receiver_name;
        if(type.compareTo("Send")==0)
        {
            System.out.println("Hi");
            sender_name = distributor.getName();
            receiver_name = consumer;

            Order sendOrder = new Order(
                    type,
                    size,
                    sender_name,
                    receiver_name,
                    quantity,
                    date,
                    distributor.getId());

            return sendOrder;
        }
        else if(type.compareTo("Receive")==0 )
        {

            sender_name = consumer;
            receiver_name= distributor.getName();

            Order receiveOrder = new Order(
                    type,
                    size,
                    sender_name,
                    receiver_name,
                    quantity,
                    date,
                    distributor.getId());

            return receiveOrder;

        }
        else if(type.compareTo("Refill")==0 )
        {

            sender_name = distributor.getName();
            receiver_name= consumer;

            Order refillOrder = new Order(
                    type,
                    size,
                    sender_name,
                    receiver_name,
                    quantity,
                    date,
                    distributor.getId());

            return refillOrder;

        }
        else if(type.compareTo("Restock")==0 )
        {

            sender_name = consumer;
            receiver_name= distributor.getName();

            Order restockOrder = new Order(
                    type,
                    size,
                    sender_name,
                    receiver_name,
                    quantity,
                    date,
                    distributor.getId());

            return restockOrder;

        }
        else
        {
            return null;
        }


    }


    public List<Order> getOrderByType(String type)
    {

        try{
            List<Order> orders = orderRepository.findOrdersByType(type);
            return orders;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }

    }


    public List<Order> getOrderByDate(String date){

        try{
            Date convertedDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
            List<Order> orders = orderRepository.findOrdersByDateOrderByDate(convertedDate);
            return orders;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<Order> getOrderByDistributorId(Integer id) {

        try{
            List<Order> orders = orderRepository.findOrderByDistributorId(id);
            return orders;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }

    }


    public String removeOrderById(Integer id)
    {
        try{
            orderRepository.deleteById(id);
            return "Order has been deleted";
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }


}
