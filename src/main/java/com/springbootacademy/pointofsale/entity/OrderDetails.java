package com.springbootacademy.pointofsale.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_details")

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetails {
    @Id
    @Column(name = "order_details_id", nullable = false, length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderDetailsId;

    @Column(name = "item_name", length = 200)
    private String itemName;

    @Column(name = "quantity", nullable = false)
    private double quantity;

    @Column(name = "amount", nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(name="item_id", nullable=false)
    private Item item;

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Order order;
}
