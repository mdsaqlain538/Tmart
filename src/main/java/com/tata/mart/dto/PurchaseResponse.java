package com.tata.mart.dto;

import lombok.Data;

@Data
public class PurchaseResponse {

    public PurchaseResponse(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    private final String orderTrackingNumber;

}
