package com.dikbiyik.company;

import java.util.ArrayList;
import java.util.List;


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


    public Company getCompanyById(int id){
        return companyList.stream().filter(company -> company.getId() == id).findFirst().orElseThrow();
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public Double sumOfOrdersByCompany(Company company){
        return company.getOrderByCustomerMap().values().stream().mapToDouble(customer -> customer.stream().mapToDouble(order -> order.getPrice()).sum()).sum();
    }

    public List<Company> getCompaniesByIdList(List<Integer> companyIdList){
        return companyList.stream().filter(company -> companyIdList.contains(company.getId())).toList();
    }

}
