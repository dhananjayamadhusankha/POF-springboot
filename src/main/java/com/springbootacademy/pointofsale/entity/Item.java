package com.springbootacademy.pointofsale.entity;

import com.springbootacademy.pointofsale.entity.enums.MeasuringUnitType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    @Column(name = "item_qty", nullable = false)
    private double itemQty;

    @Column(name = "supplier_price", nullable = false)
    private double supplierPrice;

    @Column(name = "selling_price", nullable = false)
    private double sellingPrice;

    @Column(name = "active_state", columnDefinition = "TINYINT default 1")
    private boolean active;
}
