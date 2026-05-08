package com.cisetech.controller;

import com.cisetech.entity.ServiceNetwork;
import com.cisetech.service.ServiceNetworkService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/service-networks")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "服务网络", description = "服务网络管理接口")
public class ServiceNetworkController {

    private final ServiceNetworkService serviceNetworkService;

    @GetMapping
    @Operation(summary = "获取所有服务网络")
    public ResponseEntity<List<ServiceNetwork>> getAllServiceNetworks() {
        return ResponseEntity.ok(serviceNetworkService.getAllServiceNetworks());
    }

    @GetMapping("/headquarters-first")
    @Operation(summary = "获取所有服务网络（总部优先）")
    public ResponseEntity<List<ServiceNetwork>> getAllServiceNetworksWithHeadquartersFirst() {
        return ResponseEntity.ok(serviceNetworkService.getAllServiceNetworksWithHeadquartersFirst());
    }

    @GetMapping("/{id}")
    @Operation(summary = "按ID获取服务网络")
    public ResponseEntity<ServiceNetwork> getServiceNetworkById(@PathVariable Long id) {
        return serviceNetworkService.getServiceNetworkById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "创建服务网络")
    public ResponseEntity<ServiceNetwork> createServiceNetwork(@RequestBody ServiceNetwork serviceNetwork) {
        return ResponseEntity.ok(serviceNetworkService.createServiceNetwork(serviceNetwork));
    }

    @PutMapping("/{id}")
    @Operation(summary = "更新服务网络")
    public ResponseEntity<ServiceNetwork> updateServiceNetwork(@PathVariable Long id, @RequestBody ServiceNetwork serviceNetwork) {
        ServiceNetwork updated = serviceNetworkService.updateServiceNetwork(id, serviceNetwork);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除服务网络")
    public ResponseEntity<Void> deleteServiceNetwork(@PathVariable Long id) {
        serviceNetworkService.deleteServiceNetwork(id);
        return ResponseEntity.noContent().build();
    }
}
