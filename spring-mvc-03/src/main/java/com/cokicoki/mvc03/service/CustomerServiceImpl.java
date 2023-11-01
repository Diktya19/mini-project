package com.cokicoki.mvc03.service;

import com.cokicoki.mvc03.model.CustomerModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    private List<CustomerModel> customers;

    public CustomerServiceImpl(){
        this.customers = new ArrayList<>();
        CustomerModel customer1 = new CustomerModel(
                1,
                12212234243L, "Diktya", "dik@gmail.com", "6281616176267", "ciamis");
        this.customers.add(customer1);
    }

    @Override
    public List<CustomerModel> gets() {
        return null;
    }

    @Override
    public Optional<CustomerModel> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(CustomerModel request) {
        this.customers.add(request);
    }
}
