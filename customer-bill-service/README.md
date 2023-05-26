
## Customer Biil Service

This project is a Maven project that create `Customer` and `Order` and provides functionality to print, filter based price of bills and list of customers.

---
### Project features
 - Customers, orders and companies are created in constructer
 - The project allows the creation of new order.
 - All types of orders, customers and companies can be printed in display.
 - The bills can be listed and filtered based on price.
 - The project is implemented using the Java programming language and designed as a simple console application.
****

## Methods
---
### Customer Service
```java
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
}
```

**customer printer**

```java
 public void customerPrinter(List<Customer> filteredCustomers) {
        customerList.stream().map(custormer -> custormer.getId() + " " + custormer.getFirstName() + " " + custormer.getLastName() + " " + custormer.getRegisterDate()).forEach(System.out::println);
    }
```
**print all customers**

```java
 public void printAllCustomers(){
        customerPrinter(customerList);
    }
```

 **Get Customer by ID**

 ```java
 public Customer getCustomerById(int id){
        return customerList.stream().filter(customer -> customer.getId() == id).findFirst().orElseThrow();
    }
 ```

  **Get Customer by letter**

 ```java
    public List<String> getFilteredCustomersByLetter(String letter){
        return customerList.stream()
            .map(custormer -> custormer.getId() + " " + custormer.getFirstName() + " " + custormer.getLastName())
            .filter(c -> c.contains(letter.toLowerCase()) || c.contains(letter.toUpperCase())).toList();
    }
 ```

   **Get Customer by register date**

 ```java

    public List<Customer> getFilteredCustomersByRegisterDate(Month registerDate){
        return customerList.stream()
            .filter(customer -> customer.getRegisterDate().name().equals(registerDate.name()))
            .toList();
    }
 ```
---
 ### Order Service
```java
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
}
```

   **Add order**

 ```java
    public void addOrder(Order order){
        Customer customer = customerService.getCustomerById(Integer.parseInt(order.getCustomerId()));
        Company company = companyService.getCompanyById(Integer.parseInt(order.getCompanyId()));

        orderList.add(order);
        customer.getOrderList().add(order);
        company.getOrderByCustomerMap().put(customer, customer.getOrderList());
    }
 ```

 
   **Order printer**

 ```java
    public void orderPrinter(List<Order> filteredOrders) {
        filteredOrders.stream().map(order -> order.getId() + ") PRICE : " + order.getPrice() + " CUSTOMER ID : " + order.getCustomerId() + " COMPANY ID : " + order.getCompanyId()).forEach(System.out::println);
    }
 ```

 
   **Print all orders**

 ```java
    public void printAllOrders(){
        orderPrinter(orderList);
    }
 ```

 
   **sum of orders by customer order list**

 ```java
    public Double getSumOfOrderPricesByCustomerId(int id){
        Customer customer = customerService.getCustomerById(id);
        Double sumOfOrders = customer.getOrderList().stream().mapToDouble(order -> order.getPrice()).sum();
        return sumOfOrders;
    }
 ```

 
   **sum of orders by company order list**

 ```java
    public Double getSumOfOrderPricesByCompanyId(int id){
        Company company = companyService.getCompanyById(id);
        Double sumOfOrders = company.getOrderByCustomerMap().values().stream().mapToDouble(customer -> customer.stream().mapToDouble(order -> order.getPrice()).sum()).sum();
        return sumOfOrders;
    }
 ```

 
   **sum of orders of customer due to registered month**

 ```java
    public Double getSumOfOrderPricesByCustomerRegisterMonth(Month month){
        List<Customer> customers = customerService.getFilteredCustomersByRegisterDate(month);
        Double sumOfOrders = customers.stream().mapToDouble(c -> c.getOrderList().stream().mapToDouble(order -> order.getPrice()).sum()).sum();
        return sumOfOrders;
    }
 ```

  
   **all orders above the price**

 ```java
    public List<Order> getAllOrdersAboveThePrice(Double price){
        List<Order> filteredOrders = orderList.stream().filter(order -> order.getPrice() >= price).toList();
        return filteredOrders;
    }
 ```
   **all orders below the price**

 ```java
    public List<Order> getAllOrdersBelowThePrice(Double price){
        List<Order> filteredOrders = orderList.stream().filter(order -> order.getPrice() <= price).toList();
        return filteredOrders;
    }
 ```

**average of orders**

 ```java
    
    public Double getAvarageOfOrders(List<Order> orders){
        Double sumOfOrders = orders.stream().mapToDouble(order -> order.getPrice()).sum();
        Double avgOfOrders = sumOfOrders / orders.size();

        return avgOfOrders;
    }
 ```
  
   **average of orders above the price**

 ```java
    public Double getAvarageOfOrdersAboveThePrice(Double price){
       return getAvarageOfOrders(getAllOrdersAboveThePrice(price));

    }
 ```
   **average of orders below the price**

 ```java
    public Double getAvarageOfOrdersBelowThePrice(Double price){
        return getAvarageOfOrders(getAllOrdersBelowThePrice(price));
    }
 ```
  
   **all customers that has order below price**

 ```java
    public List<Customer> getAllCustomersThatHasOrderBelowThePrice(Double price){
        List<Order> filteredOrders = getAllOrdersBelowThePrice(price);
        List<Customer> customers = filteredOrders.stream().map(order -> customerService.getCustomerById(Integer.parseInt(order.getCustomerId()))).toList();
        return customers;
    }
 ```
  
   **all orders on specific month**

 ```java

    public List<Order> getAllOrdersOnSpecificMonth(Month month){
        List<Order> filteredOrders = orderList.stream().filter(order -> order.getMonth().name().contains(month.name())).toList();
        return filteredOrders;
    }
 ```
  
   **all companies that has order on specific month**

 ```java
    public List<Company> getAllCompaniesThatHasOrdersOnSpecificMonth(Month month){
        List<Integer> companyIdList = getAllOrdersOnSpecificMonth(month).stream().map(order -> Integer.parseInt(order.getCompanyId())).toList();
        return companyService.getCompaniesByIdList(companyIdList);
    }
 ```
 ---

### Company Service
```java
public class CompanyService {
    
    private List<Company> companyList = new ArrayList<>();

    public CompanyService(){

        Company companyFirst = new Company("Company 1", "CompanyType", "Description");
        Company companySecond = new Company("Company 2", "CompanyType", "Description");
        Company companyThird = new Company("Company 3", "CompanyType", "Description");
        Company companyFourth = new Company("Company 4", "CompanyType", "Description");
        Company companyFifth = new Company("Company 5", "CompanyType", "Description");

        companyList.add(companyFirst);
        companyList.add(companySecond);
        companyList.add(companyThird);
        companyList.add(companyFourth);
        companyList.add(companyFifth);
    }
}
```

   **get company by id**

 ```java
    public Company getCompanyById(int id){
        return companyList.stream().filter(company -> company.getId() == id).findFirst().orElseThrow();
    }
 ```

   **Sum of orders of company**

 ```java
    public Double sumOfOrdersByCompany(Company company){
        return company.getOrderByCustomerMap().values().stream().mapToDouble(customer -> customer.stream().mapToDouble(order -> order.getPrice()).sum()).sum();
    }
 ```

**get company by id list**

 ```java
    public List<Company> getCompaniesByIdList(List<Integer> companyIdList){
        return companyList.stream().filter(company -> companyIdList.contains(company.getId())).toList();
    }
 ```

 ---

If you have any questions or feedback regarding the project, please feel free to reach out to me. You can contact me through the following:

`Email:` dikbykmert@gmail.com

`Twitter:` @mertdkb
