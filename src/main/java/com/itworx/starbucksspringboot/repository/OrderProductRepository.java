package com.itworx.starbucksspringboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.itworx.starbucksspringboot.model.OrderProduct;

public interface OrderProductRepository extends CrudRepository<OrderProduct, Long> {

}
