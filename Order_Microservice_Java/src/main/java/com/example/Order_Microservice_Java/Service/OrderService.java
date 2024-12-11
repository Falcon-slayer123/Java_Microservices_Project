package com.example.Order_Microservice_Java.Service;


import com.example.Order_Microservice_Java.DTO.OrderLineItemsdto;
import com.example.Order_Microservice_Java.DTO.OrderedRequest;
import com.example.Order_Microservice_Java.Model.Order;
import com.example.Order_Microservice_Java.Model.OrderLineItems;
import com.example.Order_Microservice_Java.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;


@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient webClient;

    public OrderService(OrderRepository orderRepository, WebClient webClient) {
        this.orderRepository = orderRepository;
        this.webClient = webClient;
    }

    public void placeOrder(OrderedRequest orderedRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems = orderedRequest.getOrderLineItemsdtoList().stream().map(this::mapToDto).toList();
        order.setOrderLineItems(orderLineItems);
        //Calling Inventory Service If Product Available in Stock//
        Boolean result = webClient.get().uri("http://localhost:8082/api.inventory").retrieve().bodyToFlux(boolean.class).blockFirst();

        if (result) {
            orderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Product not in stock");
        }
    }

    private OrderLineItems mapToDto(OrderLineItemsdto orderLineItemsdto) {

        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsdto.getPrice());
        orderLineItems.setQuantity(orderLineItemsdto.getQuantity());
        orderLineItems.setSkuCode(orderLineItems.getSkuCode());
        return orderLineItems;
    }


}
