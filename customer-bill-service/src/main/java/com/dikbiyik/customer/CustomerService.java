package com.dikbiyik.customer;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    
    private List<Customer> customerList = new ArrayList<>();

    public CustomerService(){
        Customer customerFirst = new Customer("qwer", "ytre", 20, Month.APRIL);
        Customer customerSecond = new Customer("asdf", "khj", 20, Month.DECEMBER);
        Customer customerThird = new Customer("zxzcv", "bvnmvbn", 20, Month.JULY);
        Customer customerFourth = new Customer("qaz", "fghjfh", 20, Month.APRIL);
        Customer customerFifth = new Customer("wsx", "tyjmytpp", 20, Month.JUNE);

        customerList.add(customerFirst);
        customerList.add(customerSecond);
        customerList.add(customerThird);
        customerList.add(customerFourth);
        customerList.add(customerFifth);
    }

    public void customerPrinter(List<Customer> filteredCustomers) {
        customerList.stream().map(custormer -> custormer.getId() + " " + custormer.getFirstName() + " " + custormer.getLastName() + " " + custormer.getRegisterDate()).forEach(System.out::println);
    }

    public void printAllCustomers(){
        customerPrinter(customerList);
    }

    public Customer getCustomerById(int id){
        return customerList.stream().filter(customer -> customer.getId() == id).findFirst().orElseThrow();
    }

    public List<String> getFilteredCustomersByLetter(String letter){
        return customerList.stream()
            .map(custormer -> custormer.getId() + " " + custormer.getFirstName() + " " + custormer.getLastName())
            .filter(c -> c.contains(letter.toLowerCase()) || c.contains(letter.toUpperCase())).toList();
    }

    public List<Customer> getFilteredCustomersByRegisterDate(Month registerDate){
        return customerList.stream()
            .filter(customer -> customer.getRegisterDate().name().equals(registerDate.name()))
            .toList();
    }

}
