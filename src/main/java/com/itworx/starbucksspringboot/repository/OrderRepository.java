package com.itworx.starbucksspringboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.itworx.starbucksspringboot.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{

}
