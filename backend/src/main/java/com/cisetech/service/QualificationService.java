package com.cisetech.service;

import com.cisetech.entity.Qualification;
import com.cisetech.repository.QualificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QualificationService {

    private final QualificationRepository qualificationRepository;

    public List<Qualification> getAllQualifications() {
        return qualificationRepository.findByIsActiveTrueOrderBySortOrderAsc();
    }

    public List<Qualification> getQualificationsByCategory(String category) {
        return qualificationRepository.findByCategoryAndIsActiveTrueOrderBySortOrderAsc(category);
    }

    public Optional<Qualification> getQualificationById(Long id) {
        return qualificationRepository.findById(id);
    }

    @Transactional
    public Qualification createQualification(Qualification qualification) {
        return qualificationRepository.save(qualification);
    }

    @Transactional
    public Qualification updateQualification(Long id, Qualification qualificationDetails) {
        return qualificationRepository.findById(id).map(qualification -> {
            qualification.setName(qualificationDetails.getName());
            qualification.setIssuingAuthority(qualificationDetails.getIssuingAuthority());
            qualification.setCertificateNumber(qualificationDetails.getCertificateNumber());
            qualification.setIssueDate(qualificationDetails.getIssueDate());
            qualification.setExpiryDate(qualificationDetails.getExpiryDate());
            qualification.setDescription(qualificationDetails.getDescription());
            qualification.setImageUrl(qualificationDetails.getImageUrl());
            qualification.setCategory(qualificationDetails.getCategory());
            qualification.setSortOrder(qualificationDetails.getSortOrder());
            qualification.setIsActive(qualificationDetails.getIsActive());
            return qualificationRepository.save(qualification);
        }).orElse(null);
    }

    @Transactional
    public void deleteQualification(Long id) {
        qualificationRepository.deleteById(id);
    }
}
