package com.cisetech.service;

import com.cisetech.entity.Solution;
import com.cisetech.repository.SolutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SolutionService {

    private final SolutionRepository solutionRepository;

    public List<Solution> getAllSolutions() {
        return solutionRepository.findByIsActiveTrueOrderBySortOrderAsc();
    }

    public List<Solution> getSolutionsByCategory(String category) {
        return solutionRepository.findByCategoryAndIsActiveTrueOrderBySortOrderAsc(category);
    }

    public List<Solution> getSolutionsByIndustry(String industry) {
        return solutionRepository.findByIndustryAndIsActiveTrueOrderBySortOrderAsc(industry);
    }

    public Optional<Solution> getSolutionBySlug(String slug) {
        return solutionRepository.findBySlug(slug);
    }

    public Optional<Solution> getSolutionById(Long id) {
        return solutionRepository.findById(id);
    }

    @Transactional
    public Solution createSolution(Solution solution) {
        return solutionRepository.save(solution);
    }

    @Transactional
    public Solution updateSolution(Long id, Solution solutionDetails) {
        return solutionRepository.findById(id).map(solution -> {
            solution.setTitle(solutionDetails.getTitle());
            solution.setSlug(solutionDetails.getSlug());
            solution.setDescription(solutionDetails.getDescription());
            solution.setContent(solutionDetails.getContent());
            solution.setIcon(solutionDetails.getIcon());
            solution.setImageUrl(solutionDetails.getImageUrl());
            solution.setCategory(solutionDetails.getCategory());
            solution.setIndustry(solutionDetails.getIndustry());
            solution.setPainPoints(solutionDetails.getPainPoints());
            solution.setSolutionHighlights(solutionDetails.getSolutionHighlights());
            solution.setCaseStudies(solutionDetails.getCaseStudies());
            solution.setSortOrder(solutionDetails.getSortOrder());
            solution.setSeoTitle(solutionDetails.getSeoTitle());
            solution.setSeoDescription(solutionDetails.getSeoDescription());
            solution.setSeoKeywords(solutionDetails.getSeoKeywords());
            solution.setIsActive(solutionDetails.getIsActive());
            return solutionRepository.save(solution);
        }).orElse(null);
    }

    @Transactional
    public void deleteSolution(Long id) {
        solutionRepository.deleteById(id);
    }
}
