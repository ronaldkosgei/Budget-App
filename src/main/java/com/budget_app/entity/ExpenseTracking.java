package com.budget_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_Expense")
public class ExpenseTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long expenseId;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "receipt_url")
    private String url;

    @Column(name = "comments")
    private String comments;
}
