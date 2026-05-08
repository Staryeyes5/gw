package com.cisetech.service;

import com.cisetech.entity.Award;
import com.cisetech.repository.AwardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AwardService {

    private final AwardRepository awardRepository;

    public List<Award> getAllAwards() {
        return awardRepository.findByIsActiveTrueOrderBySortOrderAsc();
    }

    public List<Award> getAwardsByCategory(String category) {
        return awardRepository.findByCategoryAndIsActiveTrueOrderBySortOrderAsc(category);
    }

    public Optional<Award> getAwardById(Long id) {
        return awardRepository.findById(id);
    }

    @Transactional
    public Award createAward(Award award) {
        return awardRepository.save(award);
    }

    @Transactional
    public Award updateAward(Long id, Award awardDetails) {
        return awardRepository.findById(id).map(award -> {
            award.setName(awardDetails.getName());
            award.setIssuingOrganization(awardDetails.getIssuingOrganization());
            award.setYear(awardDetails.getYear());
            award.setAwardDate(awardDetails.getAwardDate());
            award.setDescription(awardDetails.getDescription());
            award.setImageUrl(awardDetails.getImageUrl());
            award.setCategory(awardDetails.getCategory());
            award.setSortOrder(awardDetails.getSortOrder());
            award.setIsActive(awardDetails.getIsActive());
            return awardRepository.save(award);
        }).orElse(null);
    }

    @Transactional
    public void deleteAward(Long id) {
        awardRepository.deleteById(id);
    }
}
