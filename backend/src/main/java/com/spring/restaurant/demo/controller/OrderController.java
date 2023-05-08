package com.spring.restaurant.demo.controller;

import com.spring.restaurant.demo.model.Order;
import com.spring.restaurant.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    // http://localhost:9090/api/allOrders?page={value}&size={value}

    @GetMapping("getAllOrders")
    public List<Order> allOrders() {
        return orderService.getOrders();
    }


    // http://localhost:9090/api/category?key={value}

    @GetMapping("category")
    public List<Order> getAllOrdersByCategoryName(@RequestParam String key) {
        return this.orderService.getOrdersByCategoryName(key);
    }


    // http://localhost:9090/api/orderkey?word=key&page={value}&size={value}
    @GetMapping("orderkey")
    public List<Order> getOrderByKey(@RequestParam String word) {
        return this.orderService.getOrderByKey(word);
    }

    // http://localhost:9090/api/order?id={value}
    @GetMapping("order")
    public Order getOrderById(@RequestParam Long id) {
        return this.orderService.getOrder(id);
    }

    // http://localhost:9090/api/orderSize
    @GetMapping("orderSize")
    public Long OrderSize() {
        return orderService.getAllOrdersSize();
    }

    // http://localhost:9090/api/categoryidsize?id={value}
    @GetMapping("categoryidsize")
    public Long getOrderByIdCategorySize(@RequestParam Long id) {
        return orderService.getOrdersByCategoryIdLength(id);

    }

    // http://localhost:9090/api/keysize?key={value}
    @GetMapping("keysize")
    public Long sizeOfOrderByKey(@RequestParam String key) {
        return orderService.getOrderSizeByKey(key);

    }
}

