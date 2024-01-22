package com.budget_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_budget")
public class BudgetManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long budgetId;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "period")
    private String period;

    @Column(name = "user_id")
    private Long userId;

}
