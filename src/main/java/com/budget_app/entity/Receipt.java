package com.budget_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_receipt")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long receiptId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "purchase_date")
    private LocalDate purchaseDate;

    @Column(name = "vendor")
    private String vendorName;

    @Column(name = "amount_paid")
    private Double amountPaid;

    @Column(name = "currency")
    private String currency;

    @Column(name = "receipt_url")
    private String receiptUrl;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "comments")
    private String comments;
}
