package com.omercan.ecommerce.service;

import com.omercan.ecommerce.dao.CustomerRepository;
import com.omercan.ecommerce.dto.Purchase;
import com.omercan.ecommerce.dto.PurchaseResponse;
import com.omercan.ecommerce.entity.Customer;
import com.omercan.ecommerce.entity.Order;
import com.omercan.ecommerce.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }
    @Override
    public PurchaseResponse placeOrder(Purchase purchase) {
        // retrieve the order info from dto
        Order order = purchase.getOrder();
        //generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);
        // populate order with orderItems
        Set<OrderItem> orderItems=purchase.getOrderItems();
        orderItems.forEach(order::add);
        //populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());
        //populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);
        //save to the database
        customerRepository.save(customer);

        //return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        // genetate a random UUID number (UUID version-4)

            return UUID.randomUUID().toString();
    }
}
