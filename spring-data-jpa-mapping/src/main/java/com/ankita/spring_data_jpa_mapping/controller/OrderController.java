package com.ankita.spring_data_jpa_mapping.controller;

import com.ankita.spring_data_jpa_mapping.dto.OrderRequest;
import com.ankita.spring_data_jpa_mapping.dto.OrderResponse;
import com.ankita.spring_data_jpa_mapping.entity.Customer;
import com.ankita.spring_data_jpa_mapping.repository.CustomerRepository;
import com.ankita.spring_data_jpa_mapping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest request){
        return customerRepository.save(request.getCustomer());
    }

    @GetMapping("/findAllOrders")
    public List<Customer> findAllOrders(){
        return customerRepository.findAll();
    }
    @GetMapping("/getInfo")
    public List<OrderResponse> getJoinInformation(){
        return customerRepository.getJoinInformation();
    }

}
