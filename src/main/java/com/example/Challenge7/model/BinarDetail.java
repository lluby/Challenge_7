package com.example.Challenge7.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BinarDetail {
    private String productName;
    private String quantity;
    private String price;
}
