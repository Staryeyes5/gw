package com.cisetech.repository;

import com.cisetech.entity.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification, Long> {
    List<Qualification> findByCategoryAndIsActiveTrueOrderBySortOrderAsc(String category);
    List<Qualification> findByIsActiveTrueOrderBySortOrderAsc();
}
