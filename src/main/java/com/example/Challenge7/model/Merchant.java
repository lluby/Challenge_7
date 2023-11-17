package com.example.Challenge7.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "merchant")
public class Merchant implements Serializable{
        @Id // Menandakan ini adalah column pk
        @GeneratedValue(generator = "UUID") // Column ini jika kosong akan di generate otomatis value nya
        @GenericGenerator(
                name = "UUID",
                strategy = "org.hibernate.id.UUIDGenerator") // Generator value di column jika kosong
        private String MerchantCode;

        @Column(name = "MerchantName", length = 100)
        private String MerchantName;

        @Column(name = "MerchantLocation", length = 100)
        private String MerchantLocation;

        boolean open = true;

}
