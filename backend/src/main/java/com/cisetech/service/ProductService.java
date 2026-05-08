package com.cisetech.service;

import com.cisetech.entity.Product;
import com.cisetech.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findByIsActiveTrueOrderBySortOrderAsc();
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategoryAndIsActiveTrueOrderBySortOrderAsc(category);
    }

    public Optional<Product> getProductBySlug(String slug) {
        return productRepository.findBySlug(slug);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public Product updateProduct(Long id, Product productDetails) {
        return productRepository.findById(id).map(product -> {
            product.setName(productDetails.getName());
            product.setSlug(productDetails.getSlug());
            product.setDescription(productDetails.getDescription());
            product.setContent(productDetails.getContent());
            product.setIcon(productDetails.getIcon());
            product.setImageUrl(productDetails.getImageUrl());
            product.setCategory(productDetails.getCategory());
            product.setFeatures(productDetails.getFeatures());
            product.setTechnicalSpecs(productDetails.getTechnicalSpecs());
            product.setDemoUrl(productDetails.getDemoUrl());
            product.setSortOrder(productDetails.getSortOrder());
            product.setSeoTitle(productDetails.getSeoTitle());
            product.setSeoDescription(productDetails.getSeoDescription());
            product.setSeoKeywords(productDetails.getSeoKeywords());
            product.setIsActive(productDetails.getIsActive());
            return productRepository.save(product);
        }).orElse(null);
    }

    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
