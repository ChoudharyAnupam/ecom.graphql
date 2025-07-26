package com.ecom_graphql.ecom.graphql.repositories;

import com.ecom_graphql.ecom.graphql.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}
