package com.tata.mart.service;

import com.tata.mart.dto.Purchase;
import com.tata.mart.dto.PurchaseResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
@CrossOrigin("http://localhost:4200")
public interface CheckOutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
