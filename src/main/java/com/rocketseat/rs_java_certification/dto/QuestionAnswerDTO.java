package com.rocketseat.rs_java_certification.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionAnswerDTO {
    private UUID questionId;
    private UUID alternativeId;
    private boolean isCorrect;
}
