package com.budget_app.entity;

import com.budget_app.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long reportId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "report_name")
    private String reportName;

    @Column(name = "timeStamp")
    @CreationTimestamp
    private LocalDate createdAt;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
}
