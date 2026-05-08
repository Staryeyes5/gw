package com.cisetech.repository;

import com.cisetech.entity.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SolutionRepository extends JpaRepository<Solution, Long> {
    Optional<Solution> findBySlug(String slug);
    List<Solution> findByCategoryAndIsActiveTrueOrderBySortOrderAsc(String category);
    List<Solution> findByIndustryAndIsActiveTrueOrderBySortOrderAsc(String industry);
    List<Solution> findByIsActiveTrueOrderBySortOrderAsc();
}
