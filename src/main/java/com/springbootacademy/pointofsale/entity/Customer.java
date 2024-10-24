package com.springbootacademy.pointofsale.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Type;

import java.util.ArrayList;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "customer_id", length = 45)
    private int customerId;

    @Column(name = "customer_name", length = 100, nullable = false)
    private String customerName;

    @Column(name = "customer_address", length = 255)
    private String customerAddress;

    @Type(JsonType.class)
    @Column(name = "contact_numbers", length = 255)
    private ArrayList contactNumber;
}
