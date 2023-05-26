package com.dikbiyik.customer;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.dikbiyik.order.Order;

public class Customer {
    private static final AtomicInteger IDGENERATOR = new AtomicInteger(0);
    
    private final int id;
    
    private String firstName;

    private String lastName;

    private int age;

    private Month registerDate;

    private List<Order> orderList = new ArrayList<>();

    //constructors

    public Customer(String firstName, String lastName, int age, Month registerDate, List<Order> orderList) {
        this.id = IDGENERATOR.incrementAndGet();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.registerDate = registerDate;
        this.orderList = orderList;
    }

    public Customer(String firstName, String lastName, int age, Month registerDate) {
        this.id = IDGENERATOR.incrementAndGet();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.registerDate = registerDate;
    }

    //Getters - Setters

    public static AtomicInteger getIdgenerator() {
        return IDGENERATOR;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Month getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Month registerDate) {
        this.registerDate = registerDate;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    

    
}
