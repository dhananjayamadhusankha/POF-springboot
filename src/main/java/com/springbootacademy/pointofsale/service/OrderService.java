package com.springbootacademy.pointofsale.service;

import com.springbootacademy.pointofsale.dto.request.OrderDetailsSaveRequestDTO;
import com.springbootacademy.pointofsale.dto.request.OrderSaveRequestDTO;

public interface OrderService {
    String saveOrder(OrderSaveRequestDTO orderSaveRequestDTO);
}
