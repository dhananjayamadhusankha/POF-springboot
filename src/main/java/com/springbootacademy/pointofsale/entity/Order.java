package com.springbootacademy.pointofsale.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
    @Id
    @Column(name = "order_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    int orderId;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customers;

    @Column(name = "order_date", columnDefinition = "DATE")
    private Date date;

    @Column(name = "total_quantity", nullable = false)
    private double totalQuantity;

    @OneToMany(mappedBy="order")
    private Set<OrderDetails> orderDetails;

    public Order(Customer customers, Date date, double totalQuantity) {
        this.customers = customers;
        this.date = date;
        this.totalQuantity = totalQuantity;
    }
}
