package com.cisetech.controller;

import com.cisetech.entity.Qualification;
import com.cisetech.service.QualificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/qualifications")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "资质证书", description = "资质证书管理接口")
public class QualificationController {

    private final QualificationService qualificationService;

    @GetMapping
    @Operation(summary = "获取所有资质证书")
    public ResponseEntity<List<Qualification>> getAllQualifications() {
        return ResponseEntity.ok(qualificationService.getAllQualifications());
    }

    @GetMapping("/category/{category}")
    @Operation(summary = "按分类获取资质证书")
    public ResponseEntity<List<Qualification>> getQualificationsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(qualificationService.getQualificationsByCategory(category));
    }

    @GetMapping("/{id}")
    @Operation(summary = "按ID获取资质证书")
    public ResponseEntity<Qualification> getQualificationById(@PathVariable Long id) {
        return qualificationService.getQualificationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "创建资质证书")
    public ResponseEntity<Qualification> createQualification(@RequestBody Qualification qualification) {
        return ResponseEntity.ok(qualificationService.createQualification(qualification));
    }

    @PutMapping("/{id}")
    @Operation(summary = "更新资质证书")
    public ResponseEntity<Qualification> updateQualification(@PathVariable Long id, @RequestBody Qualification qualification) {
        Qualification updated = qualificationService.updateQualification(id, qualification);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除资质证书")
    public ResponseEntity<Void> deleteQualification(@PathVariable Long id) {
        qualificationService.deleteQualification(id);
        return ResponseEntity.noContent().build();
    }
}
