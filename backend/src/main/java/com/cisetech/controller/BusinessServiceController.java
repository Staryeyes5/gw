package com.cisetech.controller;

import com.cisetech.entity.BusinessService;
import com.cisetech.service.BusinessServiceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/services")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "业务服务", description = "核心业务服务管理接口")
public class BusinessServiceController {

    private final BusinessServiceService businessServiceService;

    @GetMapping
    @Operation(summary = "获取所有业务服务")
    public ResponseEntity<List<BusinessService>> getAllServices() {
        return ResponseEntity.ok(businessServiceService.getAllServices());
    }

    @GetMapping("/category/{category}")
    @Operation(summary = "按分类获取业务服务")
    public ResponseEntity<List<BusinessService>> getServicesByCategory(@PathVariable String category) {
        return ResponseEntity.ok(businessServiceService.getServicesByCategory(category));
    }

    @GetMapping("/slug/{slug}")
    @Operation(summary = "按slug获取业务服务")
    public ResponseEntity<BusinessService> getServiceBySlug(@PathVariable String slug) {
        return businessServiceService.getServiceBySlug(slug)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    @Operation(summary = "按ID获取业务服务")
    public ResponseEntity<BusinessService> getServiceById(@PathVariable Long id) {
        return businessServiceService.getServiceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "创建业务服务")
    public ResponseEntity<BusinessService> createService(@RequestBody BusinessService service) {
        return ResponseEntity.ok(businessServiceService.createService(service));
    }

    @PutMapping("/{id}")
    @Operation(summary = "更新业务服务")
    public ResponseEntity<BusinessService> updateService(@PathVariable Long id, @RequestBody BusinessService service) {
        BusinessService updated = businessServiceService.updateService(id, service);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除业务服务")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        businessServiceService.deleteService(id);
        return ResponseEntity.noContent().build();
    }
}
