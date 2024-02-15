package com.rocketseat.rs_java_certification.useCases;

import com.rocketseat.rs_java_certification.dto.VerifyIfHasCertificationDTO;
import org.springframework.stereotype.Service;

@Service
public class VerifyIfHasCertificationUseCase {

    public boolean execute(VerifyIfHasCertificationDTO dto) {
        if (dto.getEmail().equals("email@email.com") && dto.getTechnology().equals("JAVA")) {
            return true;
        }
        return false;
    }
}
