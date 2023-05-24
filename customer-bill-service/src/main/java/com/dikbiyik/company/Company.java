package com.dikbiyik.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.dikbiyik.customer.Customer;
import com.dikbiyik.order.Order;

public class Company {
    private static final AtomicInteger IDGENERATOR = new AtomicInteger(0);

    private final int id;

    private String companyName;

    private String companyType;

    private String description;

    private Map<Customer, List<Order>> orderByCutomerMap = new HashMap<>();

    //Constructor
    
    public Company(String companyName, String companyType, String description) {
        this.id = IDGENERATOR.incrementAndGet();
        this.companyName = companyName;
        this.companyType = companyType;
        this.description = description;
    }

    //Getters - Setter

    public static AtomicInteger getIdgenerator() {
        return IDGENERATOR;
    }

    public int getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<Customer, List<Order>> getOrderByCutomerMap() {
        return orderByCutomerMap;
    }

    public void setOrderByCutomerMap(Map<Customer, List<Order>> orderByCutomerMap) {
        this.orderByCutomerMap = orderByCutomerMap;
    }

    
}
