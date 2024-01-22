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

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_feedback")
public class FeedBack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long feedBackId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "timestamp")
    @CreationTimestamp
    private LocalDate sendDate;

    @Column(name = "feed_back_type")
    private String feedBackType;

    @Column(name = "feed_back_text")
    private String feedBackText;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "response_status")
    private String responseStatus;

    @Column(name = "attachment_url")
    private String attachmentUrl;
}
