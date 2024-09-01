package com.ankita.spring_data_jpa_mapping.repository;

import com.ankita.spring_data_jpa_mapping.dto.OrderResponse;
import com.ankita.spring_data_jpa_mapping.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query("SELECT new com.ankita.spring_data_jpa_mapping.dto.OrderResponse(c.name , p.productName) FROM Customer c JOIN c.products p")
    public List<OrderResponse> getJoinInformation();

}
