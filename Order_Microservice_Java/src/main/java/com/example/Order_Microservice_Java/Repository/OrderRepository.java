package com.example.Order_Microservice_Java.Repository;

import com.example.Order_Microservice_Java.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
