package com.rocketseat.rs_java_certification.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificationStudentEntity {

    private UUID id;
    private UUID studentID;
    private String technology;
    private Integer grade;
    List<AnswersCertificationEntity> AnswersCertificationEntity;

}
