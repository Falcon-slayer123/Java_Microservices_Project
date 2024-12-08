package com.example.Order_Microservice_Java.Service;


import com.example.Order_Microservice_Java.DTO.OrderLineItemsdto;
import com.example.Order_Microservice_Java.DTO.OrderedRequest;
import com.example.Order_Microservice_Java.Model.Order;
import com.example.Order_Microservice_Java.Model.OrderLineItems;
import com.example.Order_Microservice_Java.Repository.OrderRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void placeOrder(OrderedRequest orderedRequest)
    {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
      List<OrderLineItems> orderLineItems= orderedRequest.getOrderLineItemsdtoList().stream().map(this::mapToDto).toList();
     order.setOrderLineItems(orderLineItems);
     orderRepository.save(order);
    }

    private OrderLineItems mapToDto(OrderLineItemsdto orderLineItemsdto) {

        OrderLineItems orderLineItems= new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsdto.getPrice());
        orderLineItems.setQuantity(orderLineItemsdto.getQuantity());
        orderLineItems.setSkuCode(orderLineItems.getSkuCode());
        return orderLineItems;
    }


}
