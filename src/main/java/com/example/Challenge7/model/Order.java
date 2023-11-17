package com.example.Challenge7.model;

import com.example.Challenge7.model.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id // Menandakan ini adalah column pk
    @GeneratedValue(generator = "UUID") // Column ini jika kosong akan di generate otomatis value nya
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator") // Generator value di column jika kosong
    private String OrderId;

    private Date orderTime;

    private String DestinationAddress;
    @ManyToOne
    @JoinColumn(name = "UserId")
    private Users users;

    boolean complete = true;

}
