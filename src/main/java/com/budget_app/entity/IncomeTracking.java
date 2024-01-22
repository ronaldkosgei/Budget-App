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
@Table(name = "tbl_income")
public class IncomeTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long incomeId;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "earned_date")
    private LocalDate earned_date;

    @Column(name = "source")
    private String source;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "comments")
    private String comments;
}
