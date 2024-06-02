package com.rocketseat.rs_java_certification.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "certifications")
public class CertificationStudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JoinColumn(name = "student_id")
    private UUID studentID;

    @Column(length = 100)
    private String technology;

    @Column(length = 10)
    private Integer grade;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private StudentEntity studentEntity;

    @OneToMany
    @JoinColumn(name = "answer_certification_id", insertable = false, updatable = false)
    List<AnswersCertificationEntity> AnswersCertificationEntity;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
