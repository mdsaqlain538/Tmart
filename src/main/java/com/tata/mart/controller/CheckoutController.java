package com.tata.mart.controller;

import com.tata.mart.dto.Purchase;
import com.tata.mart.dto.PurchaseResponse;
import com.tata.mart.service.CheckOutService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/checkout")
@CrossOrigin("*")
public class CheckoutController {

    private CheckOutService checkOutService;

    public CheckoutController(CheckOutService checkOutService){
    this.checkOutService = checkOutService;
    }

    @PostMapping("purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){
        PurchaseResponse purchaseResponse = checkOutService.placeOrder(purchase);
        return purchaseResponse;
    }

}
