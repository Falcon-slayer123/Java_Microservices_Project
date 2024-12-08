package com.example.Order_Microservice_Java.Controller;


import com.example.Order_Microservice_Java.DTO.OrderedRequest;
import com.example.Order_Microservice_Java.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")

public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderedRequest orderedRequest)
    {
        orderService.placeOrder(orderedRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Order Created Successfully");
    }


}
