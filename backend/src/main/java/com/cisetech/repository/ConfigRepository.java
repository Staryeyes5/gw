package com.cisetech.repository;

import com.cisetech.entity.Config;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConfigRepository extends JpaRepository<Config, Long> {
    Optional<Config> findByConfigKey(String configKey);
    List<Config> findByCategoryAndIsActiveTrueOrderBySortOrderAsc(String category);
    List<Config> findByIsActiveTrueOrderBySortOrderAsc();
}
