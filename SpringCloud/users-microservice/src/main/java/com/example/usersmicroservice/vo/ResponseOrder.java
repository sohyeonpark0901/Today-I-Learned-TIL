package com.example.usersmicroservice.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseOrder {
    private String produceId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;
    private Date createdAt;

    private String orderId;
}
