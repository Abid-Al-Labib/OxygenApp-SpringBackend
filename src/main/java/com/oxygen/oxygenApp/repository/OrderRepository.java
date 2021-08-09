package com.oxygen.oxygenApp.repository;

import com.oxygen.oxygenApp.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findOrdersByDateOrderByDate(Date date);
    List<Order> findOrdersByType(String type);
    List<Order> findOrderByDistributorId(Integer distributorId);

}
