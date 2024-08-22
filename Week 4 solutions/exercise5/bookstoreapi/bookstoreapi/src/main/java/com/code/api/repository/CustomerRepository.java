package com.code.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.code.api.entity.Customer;
@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Integer>{

}
