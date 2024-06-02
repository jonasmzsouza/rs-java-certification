package com.rocketseat.rs_java_certification.useCases;

import com.rocketseat.rs_java_certification.dto.VerifyIfHasCertificationDTO;
import com.rocketseat.rs_java_certification.repositories.CertificationStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifyIfHasCertificationUseCase {

    @Autowired
    private CertificationStudentRepository certificationStudentRepository;

    public boolean execute(VerifyIfHasCertificationDTO dto) {
        var result = this.certificationStudentRepository.findByStudentEmailAndTechnology(dto.getEmail(), dto.getTechnology());
        return !result.isEmpty();
    }
}
