package com.cisetech.service;

import com.cisetech.entity.Config;
import com.cisetech.repository.ConfigRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ConfigService {

    private final ConfigRepository configRepository;

    public List<Config> getAllConfigs() {
        return configRepository.findByIsActiveTrueOrderBySortOrderAsc();
    }

    public List<Config> getConfigsByCategory(String category) {
        return configRepository.findByCategoryAndIsActiveTrueOrderBySortOrderAsc(category);
    }

    public Optional<Config> getConfigByKey(String key) {
        return configRepository.findByConfigKey(key);
    }

    public Optional<Config> getConfigById(Long id) {
        return configRepository.findById(id);
    }

    @Transactional
    public Config createConfig(Config config) {
        return configRepository.save(config);
    }

    @Transactional
    public Config updateConfig(Long id, Config configDetails) {
        return configRepository.findById(id).map(config -> {
            config.setConfigKey(configDetails.getConfigKey());
            config.setConfigValue(configDetails.getConfigValue());
            config.setDescription(configDetails.getDescription());
            config.setCategory(configDetails.getCategory());
            config.setSortOrder(configDetails.getSortOrder());
            config.setIsActive(configDetails.getIsActive());
            return configRepository.save(config);
        }).orElse(null);
    }

    @Transactional
    public void deleteConfig(Long id) {
        configRepository.deleteById(id);
    }
}
