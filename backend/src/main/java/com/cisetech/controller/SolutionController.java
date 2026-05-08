package com.cisetech.controller;

import com.cisetech.entity.Solution;
import com.cisetech.service.SolutionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/solutions")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "解决方案", description = "解决方案管理接口")
public class SolutionController {

    private final SolutionService solutionService;

    @GetMapping
    @Operation(summary = "获取所有解决方案")
    public ResponseEntity<List<Solution>> getAllSolutions() {
        return ResponseEntity.ok(solutionService.getAllSolutions());
    }

    @GetMapping("/category/{category}")
    @Operation(summary = "按分类获取解决方案")
    public ResponseEntity<List<Solution>> getSolutionsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(solutionService.getSolutionsByCategory(category));
    }

    @GetMapping("/industry/{industry}")
    @Operation(summary = "按行业获取解决方案")
    public ResponseEntity<List<Solution>> getSolutionsByIndustry(@PathVariable String industry) {
        return ResponseEntity.ok(solutionService.getSolutionsByIndustry(industry));
    }

    @GetMapping("/slug/{slug}")
    @Operation(summary = "按slug获取解决方案")
    public ResponseEntity<Solution> getSolutionBySlug(@PathVariable String slug) {
        return solutionService.getSolutionBySlug(slug)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    @Operation(summary = "按ID获取解决方案")
    public ResponseEntity<Solution> getSolutionById(@PathVariable Long id) {
        return solutionService.getSolutionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "创建解决方案")
    public ResponseEntity<Solution> createSolution(@RequestBody Solution solution) {
        return ResponseEntity.ok(solutionService.createSolution(solution));
    }

    @PutMapping("/{id}")
    @Operation(summary = "更新解决方案")
    public ResponseEntity<Solution> updateSolution(@PathVariable Long id, @RequestBody Solution solution) {
        Solution updated = solutionService.updateSolution(id, solution);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除解决方案")
    public ResponseEntity<Void> deleteSolution(@PathVariable Long id) {
        solutionService.deleteSolution(id);
        return ResponseEntity.noContent().build();
    }
}
