package com.tata.mart.service;

import com.tata.mart.dao.CustomerRepository;
import com.tata.mart.dto.Purchase;
import com.tata.mart.dto.PurchaseResponse;
import com.tata.mart.entity.Customer;
import com.tata.mart.entity.Order;
import com.tata.mart.entity.OrderItem;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
@CrossOrigin("http://localhost:4200")
public class CheckOutServiceImpl implements CheckOutService{

    private CustomerRepository customerRepository;

    public CheckOutServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Order order = purchase.getOrder();

        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);


        Set<OrderItem> orderItems = purchase.getOrderItems();

        orderItems.forEach(item->order.add(item));

        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        Customer customer = purchase.getCustomer();
        customer.add(order);

        customerRepository.save(customer);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
