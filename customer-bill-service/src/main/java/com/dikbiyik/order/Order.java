package com.dikbiyik.order;

import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    private static final AtomicInteger IDGENERATOR = new AtomicInteger(0);

    private final int id;

    private String customerId;

    private String companyId;

    private String description;

    private String month;

    private int orderAmount;

    public Order(String customerId, String companyId, String description, String month, int orderAmount) {
        this.id = IDGENERATOR.incrementAndGet();
        this.customerId = customerId;
        this.companyId = companyId;
        this.description = description;
        this.month = month;
        this.orderAmount = orderAmount;
    }

    public static AtomicInteger getIdgenerator() {
        return IDGENERATOR;
    }

    public int getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }
    
    
}
