package com.dikbiyik.order;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dikbiyik.company.Company;
import com.dikbiyik.company.CompanyService;
import com.dikbiyik.customer.Customer;
import com.dikbiyik.customer.CustomerService;

public class OrderService {
    
    private List<Order> orderList = new ArrayList<>();

    private CompanyService companyService;

    private CustomerService customerService;

    public OrderService(CompanyService companyService, CustomerService customerService){
        this.companyService = companyService;
        this.customerService = customerService;

        Order orderFirst = new Order("1", "1","qwer", Month.APRIL, 1, 1600.0);
        Order orderSecond = new Order("2", "1","qwer", Month.MAY, 1, 5000.0);
        Order orderThird = new Order("3", "1","qwer", Month.AUGUST, 1, 200.0);
        Order orderFourth = new Order("4", "1","qwer", Month.JUNE, 1, 200.0);
        Order orderFifth = new Order("5", "1","qwer", Month.JULY, 1, 200.0);

        addOrder(orderFirst);
        addOrder(orderSecond);
        addOrder(orderThird);
        addOrder(orderFourth);
        addOrder(orderFifth);

    }

    public void addOrder(Order order){
        Customer customer = customerService.getCustomerById(Integer.parseInt(order.getCustomerId()));
        Company company = companyService.getCompanyById(Integer.parseInt(order.getCompanyId()));

        orderList.add(order);
        customer.getOrderList().add(order);
        company.getOrderByCustomerMap().put(customer, customer.getOrderList());
    }

    public void orderPrinter(List<Order> filteredOrders) {
        filteredOrders.stream().map(order -> order.getId() + ") PRICE : " + order.getPrice() + " CUSTOMER ID : " + order.getCustomerId() + " COMPANY ID : " + order.getCompanyId()).forEach(System.out::println);
    }

    public void printAllOrders(){
        orderPrinter(orderList);
    }

    public Double getSumOfOrderPricesByCustomerId(int id){
        Customer customer = customerService.getCustomerById(id);
        Double sumOfOrders = customer.getOrderList().stream().mapToDouble(order -> order.getPrice()).sum();
        return sumOfOrders;
    }

    public Double getSumOfOrderPricesByCompanyId(int id){
        Company company = companyService.getCompanyById(id);
        Double sumOfOrders = company.getOrderByCustomerMap().values().stream().mapToDouble(customer -> customer.stream().mapToDouble(order -> order.getPrice()).sum()).sum();
        return sumOfOrders;
    }

    public Double getSumOfOrderPricesByCustomerRegisterMonth(Month month){
        List<Customer> customers = customerService.getFilteredCustomersByRegisterDate(month);
        Double sumOfOrders = customers.stream().mapToDouble(c -> c.getOrderList().stream().mapToDouble(order -> order.getPrice()).sum()).sum();
        return sumOfOrders;
    }

    public List<Order> getAllOrdersAboveThePrice(Double price){
        List<Order> filteredOrders = orderList.stream().filter(order -> order.getPrice() >= price).toList();
        return filteredOrders;
    }

    public List<Order> getAllOrdersBelowThePrice(Double price){
        List<Order> filteredOrders = orderList.stream().filter(order -> order.getPrice() <= price).toList();
        return filteredOrders;
    }
    
    public Double getAvarageOfOrders(List<Order> orders){
        Double sumOfOrders = orders.stream().mapToDouble(order -> order.getPrice()).sum();
        Double avgOfOrders = sumOfOrders / orders.size();

        return avgOfOrders;
    }

    public Double getAvarageOfOrdersAboveThePrice(Double price){
       return getAvarageOfOrders(getAllOrdersAboveThePrice(price));

    }

    public Double getAvarageOfOrdersBelowThePrice(Double price){
        return getAvarageOfOrders(getAllOrdersBelowThePrice(price));
    }

    public List<Customer> getAllCustomersThatHasOrderBelowThePrice(Double price){
        List<Order> filteredOrders = getAllOrdersBelowThePrice(price);
        List<Customer> customers = filteredOrders.stream().map(order -> customerService.getCustomerById(Integer.parseInt(order.getCustomerId()))).toList();
        return customers;
    }

    public List<Order> getAllOrdersOnSpecificMonth(Month month){
        List<Order> filteredOrders = orderList.stream().filter(order -> order.getMonth().name().contains(month.name())).toList();
        return filteredOrders;
    }

    public List<Company> getAllCompaniesThatHasOrdersOnSpecificMonth(Month month){
        List<Integer> companyIdList = getAllOrdersOnSpecificMonth(month).stream().map(order -> Integer.parseInt(order.getCompanyId())).toList();
        return companyService.getCompaniesByIdList(companyIdList);
    }

    

}