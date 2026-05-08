package com.cisetech.repository;

import com.cisetech.entity.Award;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AwardRepository extends JpaRepository<Award, Long> {
    List<Award> findByCategoryAndIsActiveTrueOrderBySortOrderAsc(String category);
    List<Award> findByIsActiveTrueOrderBySortOrderAsc();
}
