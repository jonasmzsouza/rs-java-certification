package com.rocketseat.rs_java_certification.controllers;

import com.rocketseat.rs_java_certification.dto.AlternativeResultDTO;
import com.rocketseat.rs_java_certification.dto.QuestionResultDTO;
import com.rocketseat.rs_java_certification.entities.AlternativeEntity;
import com.rocketseat.rs_java_certification.entities.QuestionEntity;
import com.rocketseat.rs_java_certification.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/technology/{technology}")
    public List<QuestionResultDTO> findByTechnology(@PathVariable String technology) {
        List<QuestionEntity> questions = this.questionRepository.findByTechnology(technology);
        return questions.stream().map(QuestionController::mapQuestionToDTO).collect(Collectors.toList());
    }

    static QuestionResultDTO mapQuestionToDTO(QuestionEntity question) {
        QuestionResultDTO questionResultDTO = QuestionResultDTO.builder()
            .id(question.getId())
            .technology(question.getTechnology())
            .description(question.getDescription()).build();

        List<AlternativeResultDTO> alternativesDtos = question.getAlternatives().stream().map(QuestionController::mapAlternativeToDTO).toList();
        questionResultDTO.setAlternatives(alternativesDtos);
        return questionResultDTO;
    }

    static AlternativeResultDTO mapAlternativeToDTO(AlternativeEntity alternative) {
        return AlternativeResultDTO.builder()
            .id(alternative.getId())
            .description(alternative.getDescription()).build();
    }
}
