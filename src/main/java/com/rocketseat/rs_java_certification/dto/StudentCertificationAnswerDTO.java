package com.rocketseat.rs_java_certification.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentCertificationAnswerDTO {
    private String email;
    private String technology;
    private List<QuestionAnswerDTO> questionsAnswers;
}
