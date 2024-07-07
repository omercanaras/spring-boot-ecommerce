package com.omercan.ecommerce.dto;

import com.omercan.ecommerce.entity.Address;
import com.omercan.ecommerce.entity.Customer;
import com.omercan.ecommerce.entity.Order;
import com.omercan.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
