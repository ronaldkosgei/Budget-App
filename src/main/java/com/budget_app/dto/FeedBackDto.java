package com.budget_app.dto;

import com.budget_app.enums.Status;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class FeedBackDto {

    private Long feedBackId;

    private Long userId;

    private LocalDate sendDate;

    private String feedBackType;

    private String feedBackText;

    private Status status;

    private String responseStatus;

    private String attachmentUrl;
}
