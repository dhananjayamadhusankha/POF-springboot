package com.springbootacademy.pointofsale.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderSaveRequestDTO {
    int orderId;
    private int customerId;
    private Date date;
    private double totalQuantity;
    private List<OrderDetailsSaveRequestDTO> orderDetails;
}
