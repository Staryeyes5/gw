package com.cisetech.controller;

import com.cisetech.entity.Config;
import com.cisetech.service.ConfigService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/configs")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "配置管理", description = "网站配置参数管理接口")
public class ConfigController {

    private final ConfigService configService;

    @GetMapping
    @Operation(summary = "获取所有配置")
    public ResponseEntity<List<Config>> getAllConfigs() {
        return ResponseEntity.ok(configService.getAllConfigs());
    }

    @GetMapping("/category/{category}")
    @Operation(summary = "按分类获取配置")
    public ResponseEntity<List<Config>> getConfigsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(configService.getConfigsByCategory(category));
    }

    @GetMapping("/key/{key}")
    @Operation(summary = "按key获取配置")
    public ResponseEntity<Config> getConfigByKey(@PathVariable String key) {
        return configService.getConfigByKey(key)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    @Operation(summary = "按ID获取配置")
    public ResponseEntity<Config> getConfigById(@PathVariable Long id) {
        return configService.getConfigById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "创建配置")
    public ResponseEntity<Config> createConfig(@RequestBody Config config) {
        return ResponseEntity.ok(configService.createConfig(config));
    }

    @PutMapping("/{id}")
    @Operation(summary = "更新配置")
    public ResponseEntity<Config> updateConfig(@PathVariable Long id, @RequestBody Config config) {
        Config updated = configService.updateConfig(id, config);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除配置")
    public ResponseEntity<Void> deleteConfig(@PathVariable Long id) {
        configService.deleteConfig(id);
        return ResponseEntity.noContent().build();
    }
}
