package com.budget_app.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;

@Setter
@Getter
public class ReceiptDto {


    private Long receiptId;

    private Long userId;

    private LocalDate purchaseDate;

    private String vendorName;

    private Double amountPaid;

    private String currency;

    private String receiptUrl;

    private Long categoryId;

    private String comments;
}
