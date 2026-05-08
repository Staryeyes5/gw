package com.cisetech.repository;

import com.cisetech.entity.ServiceNetwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceNetworkRepository extends JpaRepository<ServiceNetwork, Long> {
    List<ServiceNetwork> findByIsActiveTrueOrderBySortOrderAsc();
    List<ServiceNetwork> findByIsActiveTrueOrderByIsHeadquartersDescSortOrderAsc();
}
