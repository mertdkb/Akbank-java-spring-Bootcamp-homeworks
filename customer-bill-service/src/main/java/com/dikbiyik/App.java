package com.dikbiyik;

import java.time.Month;

import com.dikbiyik.company.CompanyService;
import com.dikbiyik.customer.CustomerService;
import com.dikbiyik.order.OrderService;

public class App 
{
    public static void main( String[] args )
    {
        CustomerService customerService = new CustomerService();
        CompanyService companyService = new CompanyService();
        OrderService orderService = new OrderService(companyService, customerService);

        System.out.println("\n\n All customers");
        customerService.printAllCustomers();

        System.out.println("\n\n Customers that signed up in June ");
        customerService.customerPrinter(customerService.getFilteredCustomersByRegisterDate(Month.JUNE));

        System.out.println("\n\n All orders");
        orderService.printAllOrders();

        System.out.println("\n\n Orders that has price above " + 1500);
        orderService.orderPrinter(orderService.getAllOrdersAboveThePrice(1500.0)); 

        System.out.println("\n\n Average of orders that has price above " + 1500);
        System.out.println(orderService.getAvarageOfOrdersAboveThePrice(1500.0));
        
        System.out.println("\n\n Orders that has price below " + 500);
        orderService.orderPrinter(orderService.getAllOrdersBelowThePrice(500.0));  

        System.out.println("\n\n Customers that has order price below " + 500);
        customerService.customerPrinter(orderService.getAllCustomersThatHasOrderBelowThePrice(500.0)); 

        System.out.println("\n\n Orders on specific month");
        orderService.orderPrinter(orderService.getAllOrdersOnSpecificMonth(Month.JUNE)); 
    }
}
