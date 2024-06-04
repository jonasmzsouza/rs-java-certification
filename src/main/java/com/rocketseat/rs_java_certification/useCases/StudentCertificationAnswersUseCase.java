package com.rocketseat.rs_java_certification.useCases;

import com.rocketseat.rs_java_certification.dto.StudentCertificationAnswerDTO;
import com.rocketseat.rs_java_certification.dto.VerifyIfHasCertificationDTO;
import com.rocketseat.rs_java_certification.entities.*;
import com.rocketseat.rs_java_certification.repositories.CertificationStudentRepository;
import com.rocketseat.rs_java_certification.repositories.QuestionRepository;
import com.rocketseat.rs_java_certification.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudentCertificationAnswersUseCase {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private CertificationStudentRepository certificationStudentRepository;

    @Autowired
    private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;

    public CertificationStudentEntity execute(StudentCertificationAnswerDTO dto) throws Exception {

        boolean hasCertification = this.verifyIfHasCertificationUseCase.execute(new VerifyIfHasCertificationDTO(dto.getEmail(), dto.getTechnology()));

        if(hasCertification){
            throw new Exception("Você já obteve esta certificação!");
        }

        List<QuestionEntity> questionsEntity = questionRepository.findByTechnology(dto.getTechnology());
        List<AnswersCertificationEntity> answersCertifications = new ArrayList<>();

        AtomicInteger correctAnswers = new AtomicInteger(0);

        dto.getQuestionsAnswers().forEach(questionAnswer -> {
            QuestionEntity questionEntity = questionsEntity.stream()
                .filter(question -> question.getId().equals(questionAnswer.getQuestionId()))
                .findFirst().orElse(null);

            AlternativeEntity correctAlternative = Objects.requireNonNull(questionEntity).getAlternatives().stream()
                .filter(AlternativeEntity::isCorrect).findFirst().orElse(null);

            if (Objects.requireNonNull(correctAlternative).getId().equals(questionAnswer.getAlternativeId())) {
                questionAnswer.setCorrect(true);
                correctAnswers.incrementAndGet();
            } else {
                questionAnswer.setCorrect(false);
            }

            AnswersCertificationEntity answersCertificationEntity = AnswersCertificationEntity.builder()
                .answerID(questionAnswer.getAlternativeId())
                .questionID(questionAnswer.getQuestionId())
                .isCorrect(questionAnswer.isCorrect())
                .build();

            answersCertifications.add(answersCertificationEntity);
        });

        Optional<StudentEntity> studentEntity = studentRepository.findByEmail(dto.getEmail());
        UUID studentID;
        if(studentEntity.isEmpty()) {
            StudentEntity student = StudentEntity.builder()
                .email(dto.getEmail())
                .build();
            student = studentRepository.save(student);
            studentID = student.getId();
        } else {
            studentID = studentEntity.get().getId();
        }

        CertificationStudentEntity certificationStudentEntity = CertificationStudentEntity.builder()
            .technology(dto.getTechnology())
            .studentID(studentID)
            .grade(correctAnswers.get())
            .build();

        CertificationStudentEntity certificationStudentCreated = certificationStudentRepository.save(certificationStudentEntity);

        answersCertifications.forEach(answersCertification -> {
            answersCertification.setCertificationID(certificationStudentEntity.getId());
            answersCertification.setCertificationStudentEntity(certificationStudentEntity);
        });

        certificationStudentEntity.setAnswersCertificationEntity(answersCertifications);
        certificationStudentRepository.save(certificationStudentEntity);

        return certificationStudentCreated;

    }
}
