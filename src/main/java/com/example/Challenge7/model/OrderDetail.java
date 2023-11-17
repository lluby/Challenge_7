package com.example.Challenge7.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orderDetails")
public class OrderDetail implements Serializable {
    @Id // Menandakan ini adalah column pk
    @GeneratedValue(generator = "UUID") // Column ini jika kosong akan di generate otomatis value nya
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator") // Generator value di column jika kosong
    private String OrderDetailId;
    @Column(name = "quantity", length = 100)
    private int quantity;

    @Column(name = "totalPrice", length = 100)
    private long totalPrice;

    @ManyToOne
    @JoinColumn(name = "OrderId")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "ProductCode")
    private Product product;
}
