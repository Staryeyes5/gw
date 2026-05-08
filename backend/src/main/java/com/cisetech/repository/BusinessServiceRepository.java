package com.cisetech.repository;

import com.cisetech.entity.BusinessService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusinessServiceRepository extends JpaRepository<BusinessService, Long> {
    Optional<BusinessService> findBySlug(String slug);
    List<BusinessService> findByCategoryAndIsActiveTrueOrderBySortOrderAsc(String category);
    List<BusinessService> findByIsActiveTrueOrderBySortOrderAsc();
}
