package com.cisetech.service;

import com.cisetech.entity.CompanyInfo;
import com.cisetech.repository.CompanyInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CompanyInfoService {

    private final CompanyInfoRepository companyInfoRepository;

    public Optional<CompanyInfo> getCompanyInfo() {
        return companyInfoRepository.findFirstByOrderByIdAsc();
    }

    public Optional<CompanyInfo> getCompanyInfoById(Long id) {
        return companyInfoRepository.findById(id);
    }

    @Transactional
    public CompanyInfo createCompanyInfo(CompanyInfo companyInfo) {
        return companyInfoRepository.save(companyInfo);
    }

    @Transactional
    public CompanyInfo updateCompanyInfo(Long id, CompanyInfo companyInfoDetails) {
        return companyInfoRepository.findById(id).map(info -> {
            info.setCompanyName(companyInfoDetails.getCompanyName());
            info.setShortName(companyInfoDetails.getShortName());
            info.setStockCode(companyInfoDetails.getStockCode());
            info.setLogoUrl(companyInfoDetails.getLogoUrl());
            info.setSlogan(companyInfoDetails.getSlogan());
            info.setCoreConcept(companyInfoDetails.getCoreConcept());
            info.setBrandConcept(companyInfoDetails.getBrandConcept());
            info.setServicePhilosophy(companyInfoDetails.getServicePhilosophy());
            info.setFoundedYear(companyInfoDetails.getFoundedYear());
            info.setDescription(companyInfoDetails.getDescription());
            info.setVision(companyInfoDetails.getVision());
            info.setMission(companyInfoDetails.getMission());
            info.setValues(companyInfoDetails.getValues());
            info.setTechStack(companyInfoDetails.getTechStack());
            info.setServiceIndustries(companyInfoDetails.getServiceIndustries());
            info.setCityCoverage(companyInfoDetails.getCityCoverage());
            info.setEmployeeCount(companyInfoDetails.getEmployeeCount());
            info.setCustomerCount(companyInfoDetails.getCustomerCount());
            info.setContactPhone(companyInfoDetails.getContactPhone());
            info.setContactEmail(companyInfoDetails.getContactEmail());
            info.setAddress(companyInfoDetails.getAddress());
            info.setCopyright(companyInfoDetails.getCopyright());
            info.setIcp(companyInfoDetails.getIcp());
            info.setIsActive(companyInfoDetails.getIsActive());
            return companyInfoRepository.save(info);
        }).orElse(null);
    }

    @Transactional
    public void deleteCompanyInfo(Long id) {
        companyInfoRepository.deleteById(id);
    }
}
