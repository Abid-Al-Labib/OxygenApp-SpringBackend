package com.oxygen.oxygenApp.restfulAPI;

import com.oxygen.oxygenApp.entities.Order;
import com.oxygen.oxygenApp.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    //get all orders by type
    @GetMapping("/orderByType")
    public List<Order> getOrderByType(@RequestParam(name = "type") String type)
    {
        return orderService.getOrderByType(type);
    }


    //get all orders by date
    @GetMapping("/OrderByDate")
    public List<Order> getOrderByDate(@RequestParam(name = "date") String date)
    {
        return orderService.getOrderByDate(date);
    }


    @GetMapping("/orderByDistributor")
    public List<Order> getOrderByDistributor(@RequestParam(name = "id") Integer distributorId)
    {
        return orderService.getOrderByDistributorId(distributorId);
    }

}
