package com.rocketseat.rs_java_certification.controllers;


import com.rocketseat.rs_java_certification.dto.VerifyIfHasCertificationDTO;
import com.rocketseat.rs_java_certification.useCases.VerifyIfHasCertificationUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;

    @PostMapping("/verifyIfHasCertification")
    public String verifyIfHasCertification(@RequestBody VerifyIfHasCertificationDTO verifyIfHasCertificationDTO) {
        var result = this.verifyIfHasCertificationUseCase.execute(verifyIfHasCertificationDTO);
        if (result) {
            return "Usuário já realizou a certificação!";
        }
        return "Usuário habilitado para realizar a certificação!";
    }
}
