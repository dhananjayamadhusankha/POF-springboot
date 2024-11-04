package com.springbootacademy.pointofsale.controller;

import com.springbootacademy.pointofsale.dto.request.OrderDetailsSaveRequestDTO;
import com.springbootacademy.pointofsale.dto.request.OrderSaveRequestDTO;
import com.springbootacademy.pointofsale.service.OrderService;
import com.springbootacademy.pointofsale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("save")
    public ResponseEntity<StandardResponse> saveOrder(@RequestBody OrderSaveRequestDTO orderSaveRequestDTO){
        String id = orderService.saveOrder(orderSaveRequestDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Order saved successfully",orderSaveRequestDTO.getOrderId()+" Order saved successfully"), HttpStatus.CREATED
        );
    }

}
