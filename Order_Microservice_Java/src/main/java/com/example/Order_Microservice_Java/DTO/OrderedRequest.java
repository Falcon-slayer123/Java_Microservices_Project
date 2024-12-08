package com.example.Order_Microservice_Java.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderedRequest {

    private List<OrderLineItemsdto> orderLineItemsdtoList;

    public List<OrderLineItemsdto> getOrderLineItemsdtoList() {
        return orderLineItemsdtoList;
    }

    public void setOrderLineItemsdtoList(List<OrderLineItemsdto> orderLineItemsdtoList) {
        this.orderLineItemsdtoList = orderLineItemsdtoList;
    }
}
