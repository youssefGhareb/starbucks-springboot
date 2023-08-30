package com.itworx.starbucksspringboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itworx.starbucksspringboot.model.Order;
import com.itworx.starbucksspringboot.service.OrderProductService;
import com.itworx.starbucksspringboot.service.OrderService;
import com.itworx.starbucksspringboot.service.ProductService;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderProductService orderProductService;
	@Autowired
	private ProductService productService;

	@GetMapping
	public List<Order> list() {
		System.out.println(productService.listProducts().toString());
		return orderService.listOrders();
	}

	@GetMapping
	@RequestMapping("{id}")
	public Optional<Order> get(@PathVariable Long id) {
		return orderService.getOrder(id);
	}

	@PostMapping
	public Order create(@RequestBody final Order order) {
//		order.getOrderProducts().forEach(orderProduct -> orderProductService.createOrderProduct(orderProduct));
		return orderService.createOrder(order);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		Optional<Order> order = orderService.getOrder(id);
		order.ifPresent(o -> o.getOrderProducts()
				.forEach(orderProduct -> orderProductService.deleteOrderProduct(orderProduct.getId())));

		orderService.deleteOrder(id);
	}

	@GetMapping("/addProduct")
	public Order addProductsToOrder(
			@RequestParam(value = "orderId", required = true) Long orderID,
			@RequestParam(value = "productId", required = true) Long productID,
			@RequestParam(value = "quantity", required = false) int quantity) {
		orderService.addProductToOrder(orderID, productID, quantity);
		return null;
	}
}
