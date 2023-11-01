package com.cokicoki.mvc03.service;

import com.cokicoki.mvc03.model.CustomerModel;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerModel> gets();
    Optional<CustomerModel> getById(Integer id);
    void save(CustomerModel request);
}
