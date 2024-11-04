package com.springbootacademy.pointofsale.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class OrderDetailsSaveRequestDTO {
    private int orderDetailsId;
    private String itemName;
    private double quantity;
    private double amount;
    private int itemId;
}
