package com.cisetech.controller;

import com.cisetech.entity.CompanyInfo;
import com.cisetech.service.CompanyInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/company")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "企业信息", description = "企业基本信息管理接口")
public class CompanyInfoController {

    private final CompanyInfoService companyInfoService;

    @GetMapping
    @Operation(summary = "获取企业信息")
    public ResponseEntity<CompanyInfo> getCompanyInfo() {
        Optional<CompanyInfo> companyInfo = companyInfoService.getCompanyInfo();
        return companyInfo.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    @Operation(summary = "按ID获取企业信息")
    public ResponseEntity<CompanyInfo> getCompanyInfoById(@PathVariable Long id) {
        return companyInfoService.getCompanyInfoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "创建企业信息")
    public ResponseEntity<CompanyInfo> createCompanyInfo(@RequestBody CompanyInfo companyInfo) {
        return ResponseEntity.ok(companyInfoService.createCompanyInfo(companyInfo));
    }

    @PutMapping("/{id}")
    @Operation(summary = "更新企业信息")
    public ResponseEntity<CompanyInfo> updateCompanyInfo(@PathVariable Long id, @RequestBody CompanyInfo companyInfo) {
        CompanyInfo updated = companyInfoService.updateCompanyInfo(id, companyInfo);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除企业信息")
    public ResponseEntity<Void> deleteCompanyInfo(@PathVariable Long id) {
        companyInfoService.deleteCompanyInfo(id);
        return ResponseEntity.noContent().build();
    }
}
