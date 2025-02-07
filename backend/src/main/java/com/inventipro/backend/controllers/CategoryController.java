package com.inventipro.backend.controllers;

import com.inventipro.backend.dto.CategoryDTO;
import com.inventipro.backend.exceptions.NoSuchResourceException;
import com.inventipro.backend.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/inventipro/categories")
public class CategoryController {

    private final CategoryService categoryService;
    public CategoryController(final CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody  @Valid CategoryDTO categoryDTO) {
        return new ResponseEntity<>(categoryService.addCategory(categoryDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable int id) {
        CategoryDTO categoryDTO = categoryService.getCategoryById(id);
        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable int id, @RequestBody @Valid CategoryDTO categoryDTO) {
        return new ResponseEntity<>(categoryService.updateCategory(id,categoryDTO),HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CategoryDTO> patchCategory(@PathVariable int id, @RequestBody @Valid Map<String,Object> map) {
        return new ResponseEntity<>(categoryService.patchCategory(id,map),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
        return new ResponseEntity<>(categoryService.deleteCategory(id),HttpStatus.NO_CONTENT);
    }

}
