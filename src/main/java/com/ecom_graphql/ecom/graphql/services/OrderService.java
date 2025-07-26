package com.ecom_graphql.ecom.graphql.services;

import com.ecom_graphql.ecom.graphql.entities.Order;
import com.ecom_graphql.ecom.graphql.helper.ExceptionHelper;
import com.ecom_graphql.ecom.graphql.repositories.OrderRepo;
import org.hibernate.tool.schema.spi.ExceptionHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepo orderRepo;


    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public Order createOrder(Order order){
       return orderRepo.save(order);
    }

    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }


    public Order getOrder(int orderId){
        Order order = orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        return order;
    }

    public boolean deleteOrder(int orderId) {
        Order order = orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        orderRepo.delete(order);
        return true;
    }

}
