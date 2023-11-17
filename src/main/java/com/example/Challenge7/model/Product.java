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
@Table(name = "product")
public class Product implements Serializable {
    @Id // Menandakan ini adalah column pk
    @GeneratedValue(generator = "UUID") // Column ini jika kosong akan di generate otomatis value nya
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator") // Generator value di column jika kosong
    private String ProductCode;
    @Column(name = "ProductName", length = 100)
    private String ProductName;
    @Column(name = "Price", length = 100)
    private Long price;

    @ManyToOne
    @JoinColumn(name = "MerchantCode")
    private Merchant merchant;

}
