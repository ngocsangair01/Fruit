package com.fruits.congtyhoaqua.controllers;

import com.fruits.congtyhoaqua.bases.BaseController;
import com.fruits.congtyhoaqua.dtos.CategoryDTO;
import com.fruits.congtyhoaqua.models.Category;
import com.fruits.congtyhoaqua.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController extends BaseController<Category> {
    @Autowired
    private ICategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO){
        return this.resSuccess(categoryService.createCategory(categoryDTO));
    }

    @PatchMapping("/edit-category/{idCategory}")
    public ResponseEntity<?> editCategory(@PathVariable Integer idCategory, @RequestBody CategoryDTO categoryDTO){
        return  this.resSuccess(categoryService.editCategory(idCategory, categoryDTO));
    }

    @DeleteMapping("delete-category/{idCategory}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer idCategory){
        return this.resSuccess(categoryService.deleteCategory(idCategory));
    }

    @GetMapping("/get-all-category")
    public ResponseEntity<?> getAllCategory(){
        return  this.resSetSuccess(categoryService.getAllCategory());
    }
}
