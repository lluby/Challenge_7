package com.example.Challenge7.controller;

import com.example.Challenge7.model.Merchant;
import com.example.Challenge7.model.Order;
import com.example.Challenge7.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/api/order")
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping(produces = "application/json")
    @Operation(summary = "Api to get all order")
    public List<Order> getOrder() {
        return orderService.getAllOrder();
    }

    @PostMapping(value = "add-order")
    public ResponseEntity AddOrder(@RequestBody Order order){
        orderService.AddOrder(Order.builder()
                .OrderId(order.getOrderId())
                        .orderTime(order.getOrderTime())
                        .DestinationAddress(order.getDestinationAddress())
                        .users(order.getUsers())
                        .complete(order.isComplete())
                .build());
        return ResponseEntity.ok("Order added successfully");
    }
    @PostMapping(value = "update-order")
    public ResponseEntity updateOrder(@RequestBody Order order) {
        Order updateOrder = orderService.updateOrder(order);
        if (updateOrder != null) {
            return new ResponseEntity<>(updateOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Unable to update Order", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{OrderId}")
    public String deleteOrder(@PathVariable("OrderId") String OrderId) {
        orderService.deleteOrder(OrderId);
        return "Delete Order " + OrderId+ " success!";
    }
    @GetMapping("/detail/{OrderId}")
    public ResponseEntity getOrderDetail(@PathVariable String OrderId) {
        Order order = orderService.getOrderDetails(OrderId);
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/detail")
    @Operation(summary = "Getting detail of one order by order id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "order found"),
            @ApiResponse(responseCode = "404", description = "Inputted order id not found")
    })

    private List<?> testWildCard(){
        return Arrays.asList("String", 40);
    }

}
