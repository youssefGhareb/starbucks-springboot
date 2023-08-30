package com.itworx.starbucksspringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itworx.starbucksspringboot.model.Order;
import com.itworx.starbucksspringboot.model.OrderProduct;
import com.itworx.starbucksspringboot.model.Product;
import com.itworx.starbucksspringboot.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderProductService orderProductService;

	public Optional<Order> getOrder(Long id) {
		return orderRepo.findById(id);
	}

	public Order createOrder(Order o) {
		return orderRepo.save(o);
	}

	public void deleteOrder(Long id) {
		orderRepo.deleteById(id);
	}
	
	public void addProductToOrder(Long orderID, Long productID, int quantity) {
		Optional<Product> p = productService.getProduct(productID);
		p.ifPresent(product -> {
			Optional<Order> o = getOrder(orderID);
			o.ifPresent(order -> {
				OrderProduct orderProduct = new OrderProduct(order, product, quantity);
				orderProductService.createOrderProduct(orderProduct);
			});
		});
	}
	
	
	public List<Order> listOrders(){
		return (List<Order>) orderRepo.findAll();
	}
}
