package com.ecom_graphql.ecom.graphql.controlles;

import com.ecom_graphql.ecom.graphql.entities.Order;
import com.ecom_graphql.ecom.graphql.entities.User;
import com.ecom_graphql.ecom.graphql.services.OrderService;
import com.ecom_graphql.ecom.graphql.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderController {

    private UserService userService;
    private OrderService orderService;

    public OrderController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @MutationMapping
    public Order createOrder(
            @Argument String orderDetail,
            @Argument String address,
            @Argument int price,
            @Argument int userId
    ) {
        User user = userService.getUser(userId);

        Order order = new Order();
        order.setOrderDetail(orderDetail);
        order.setAddress(address);
        order.setPrice(price);
        order.setUser(user);

        return this.orderService.createOrder(order);
    }


    @QueryMapping
    public List<Order> getOrders(){
        return orderService.getAllOrders();
    }

    @QueryMapping
    public Order getOrder(@Argument int orderId){
        return orderService.getOrder(orderId);
    }

    @MutationMapping
    public boolean deleteOrder(int orderId){
        return this.orderService.deleteOrder(orderId);
    }

}
