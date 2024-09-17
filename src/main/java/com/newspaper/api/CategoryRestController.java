package com.newspaper.api;

import com.newspaper.entity.Category;
import com.newspaper.entity.New;
import com.newspaper.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api_category")
public class CategoryRestController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/list_category")
    public List<Category> getAllCategory() {
        return categoryService.getAll();
    }

    @GetMapping("/get_category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id){
        Category category = categoryService.getCategoryById(id);
        if( category != null){
            return new ResponseEntity<>(category, HttpStatus.OK);
        }else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/create_category")
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        Category createdNew = categoryService.saveCategory(category);
        return  new ResponseEntity<>(createdNew, HttpStatus.CREATED);
    }

    @PutMapping("/update_category/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable(name = "id") Long id, @RequestBody Category category){
        Category updatedCategory = categoryService.updateCategory(id, category);
        if (updatedCategory != null){
            return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete_category/{id}")
    public  ResponseEntity<Category> deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
