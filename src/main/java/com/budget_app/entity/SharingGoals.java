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
@Table(name = "tbl_sharing_goal")
public class SharingGoals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goalId")
    private Long goalId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "goal_amount")
    private Double goalAmount;

    @Column(name = "current_amount")
    private Double currentAmount;

    @Column(name = "target_amount")
    private Double targetAmount;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "comments")
    private String comments;

    @Column(name = "share_url")
    private String shareUrl;
}
