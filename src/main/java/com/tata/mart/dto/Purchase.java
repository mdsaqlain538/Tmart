package com.tata.mart.dto;

import com.tata.mart.entity.Address;
import com.tata.mart.entity.Customer;
import com.tata.mart.entity.Order;
import com.tata.mart.entity.OrderItem;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Setter
@Getter
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
