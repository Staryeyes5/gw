package com.cisetech.controller;

import com.cisetech.entity.Award;
import com.cisetech.service.AwardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/awards")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "荣誉奖项", description = "荣誉奖项管理接口")
public class AwardController {

    private final AwardService awardService;

    @GetMapping
    @Operation(summary = "获取所有荣誉奖项")
    public ResponseEntity<List<Award>> getAllAwards() {
        return ResponseEntity.ok(awardService.getAllAwards());
    }

    @GetMapping("/category/{category}")
    @Operation(summary = "按分类获取荣誉奖项")
    public ResponseEntity<List<Award>> getAwardsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(awardService.getAwardsByCategory(category));
    }

    @GetMapping("/{id}")
    @Operation(summary = "按ID获取荣誉奖项")
    public ResponseEntity<Award> getAwardById(@PathVariable Long id) {
        return awardService.getAwardById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "创建荣誉奖项")
    public ResponseEntity<Award> createAward(@RequestBody Award award) {
        return ResponseEntity.ok(awardService.createAward(award));
    }

    @PutMapping("/{id}")
    @Operation(summary = "更新荣誉奖项")
    public ResponseEntity<Award> updateAward(@PathVariable Long id, @RequestBody Award award) {
        Award updated = awardService.updateAward(id, award);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除荣誉奖项")
    public ResponseEntity<Void> deleteAward(@PathVariable Long id) {
        awardService.deleteAward(id);
        return ResponseEntity.noContent().build();
    }
}
