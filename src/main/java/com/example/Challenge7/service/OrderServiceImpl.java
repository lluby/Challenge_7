package com.example.Challenge7.service;

import ch.qos.logback.classic.Logger;
import com.example.Challenge7.model.Merchant;
import com.example.Challenge7.model.Order;
import com.example.Challenge7.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    private Logger log;

    @Async
    @Transactional
    @Override
    public Order AddOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(String OrderId) {
        orderRepository.deleteById(OrderId);
    }

    @Transactional(readOnly = true)
    @Override
    public Order getOrderDetails(String OrderId) {
        log.info("Getting order detail info of {}", OrderId);
        return Optional.ofNullable(orderRepository.findById(OrderId))
                .map(order->Order.builder()
                        .OrderId(order.get().getOrderId())
                        .orderTime(order.get().getOrderTime())
                        .users(order.get().getUsers())
                        .DestinationAddress(order.get().getDestinationAddress())
                        .complete(order.isPresent())
                        .build())
                .orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }
}
