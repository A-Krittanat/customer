package com.dagitalacademy.customer.support;

import com.digitalacademy.customer.model.Customer;
import com.digitalacademy.customer.model.response.GetLoanInfoResponse;

import java.util.ArrayList;
import java.util.List;

public class CustomerSupportTest {
    public static GetLoanInfoResponse getNewLoanInfo() {
        GetLoanInfoResponse loanInfoResponse = new GetLoanInfoResponse();
        loanInfoResponse.setId(1L);
        loanInfoResponse.setStatus("OK");
        loanInfoResponse.setAccountPayable("102-100-1000");
        loanInfoResponse.setAccountReceivable("102-100-2000");
        loanInfoResponse.setPrincipalAmount(2000.00);
        return loanInfoResponse;
    }

    public static Customer createNewCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Madrid");
        customer.setLastName("Bayern");
        customer.setEmail("test@test.com");
        customer.setPhoneNo("0898989898");
        customer.setAge(19);
        return customer;
    }

    public static Customer responseCreateNewCustomer() {
        Customer customer = new Customer();
        customer.setId(8L);
        customer.setFirstName("Madrid");
        customer.setLastName("Bayern");
        customer.setEmail("test@test.com");
        customer.setPhoneNo("0898989898");
        customer.setAge(19);
        return customer;
    }

    public static Customer getUpdateCustomer() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("Noon2");
        customer.setLastName("Bow");
        customer.setEmail("bow@test.com");
        customer.setPhoneNo("0898886666");
        customer.setAge(18);
        return customer;
    }

    public static Customer getNewCustomer() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("Noon");
        customer.setLastName("Bow");
        customer.setEmail("bow@test.com");
        customer.setPhoneNo("0898886666");
        customer.setAge(18);
        return customer;
    }

    public static List<Customer> getCustomerList() {
        List<Customer> customerList = new ArrayList<>();
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("Ryan");
        customer.setLastName("Giggs");
        customer.setEmail("iamgigue@test.com");
        customer.setPhoneNo("0898887777");
        customer.setAge(22);
        customerList.add(customer);

        customer = new Customer();
        customer.setId(2L);
        customer.setFirstName("David");
        customer.setLastName("Beckham");
        customer.setEmail("david@test.com");
        customer.setPhoneNo("0898887776");
        customer.setAge(25);
        customerList.add(customer);
        return customerList;
    }

    public static List<Customer> getCustomerNameRyanList() {
        List<Customer> customerList = new ArrayList<>();
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("Ryan");
        customer.setLastName("Giggs");
        customer.setEmail("iamgigue@test.com");
        customer.setPhoneNo("0898887777");
        customer.setAge(22);
        customerList.add(customer);

        customer = new Customer();
        customer.setId(2L);
        customer.setFirstName("Ryan");
        customer.setLastName("Beckham");
        customer.setEmail("david@test.com");
        customer.setPhoneNo("0898887776");
        customer.setAge(25);
        customerList.add(customer);
        return customerList;
    }

}
