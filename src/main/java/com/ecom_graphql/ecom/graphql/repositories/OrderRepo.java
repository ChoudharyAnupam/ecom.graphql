package com.ecom_graphql.ecom.graphql.repositories;

import com.ecom_graphql.ecom.graphql.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
}
