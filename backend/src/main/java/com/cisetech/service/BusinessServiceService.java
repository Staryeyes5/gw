package com.cisetech.service;

import com.cisetech.entity.BusinessService;
import com.cisetech.repository.BusinessServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BusinessServiceService {

    private final BusinessServiceRepository businessServiceRepository;

    public List<BusinessService> getAllServices() {
        return businessServiceRepository.findByIsActiveTrueOrderBySortOrderAsc();
    }

    public List<BusinessService> getServicesByCategory(String category) {
        return businessServiceRepository.findByCategoryAndIsActiveTrueOrderBySortOrderAsc(category);
    }

    public Optional<BusinessService> getServiceBySlug(String slug) {
        return businessServiceRepository.findBySlug(slug);
    }

    public Optional<BusinessService> getServiceById(Long id) {
        return businessServiceRepository.findById(id);
    }

    @Transactional
    public BusinessService createService(BusinessService service) {
        return businessServiceRepository.save(service);
    }

    @Transactional
    public BusinessService updateService(Long id, BusinessService serviceDetails) {
        return businessServiceRepository.findById(id).map(service -> {
            service.setTitle(serviceDetails.getTitle());
            service.setSlug(serviceDetails.getSlug());
            service.setDescription(serviceDetails.getDescription());
            service.setContent(serviceDetails.getContent());
            service.setIcon(serviceDetails.getIcon());
            service.setImageUrl(serviceDetails.getImageUrl());
            service.setCategory(serviceDetails.getCategory());
            service.setKeyFeatures(serviceDetails.getKeyFeatures());
            service.setTargetIndustries(serviceDetails.getTargetIndustries());
            service.setSortOrder(serviceDetails.getSortOrder());
            service.setSeoTitle(serviceDetails.getSeoTitle());
            service.setSeoDescription(serviceDetails.getSeoDescription());
            service.setSeoKeywords(serviceDetails.getSeoKeywords());
            service.setIsActive(serviceDetails.getIsActive());
            return businessServiceRepository.save(service);
        }).orElse(null);
    }

    @Transactional
    public void deleteService(Long id) {
        businessServiceRepository.deleteById(id);
    }
}
