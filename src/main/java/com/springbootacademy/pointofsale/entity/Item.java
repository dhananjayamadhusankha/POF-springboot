package com.springbootacademy.pointofsale.entity;

import com.springbootacademy.pointofsale.entity.enums.MeasuringUnitType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id", nullable = false)
    private int itemId;

    @Column(name = "item_name", length = 30, nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measure_type", length = 8, nullable = false)
    private MeasuringUnitType measuringUnitType;

    @Column(name = "balance_qty", nullable = false)
    private double balanceQty;

    @Column(name = "supplier_price", nullable = false)
    private double supplierPrice;

    @Column(name = "selling_price", nullable = false)
    private double sellingPrice;

    @Column(name = "active_status", columnDefinition = "TINYINT default 1")
    private boolean activeStatus;
}
