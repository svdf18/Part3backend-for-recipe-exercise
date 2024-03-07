package dat3.recipe.api;

import dat3.recipe.service.CategoryService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")

public class CategoryController {

  CategoryService categoryService;

  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping
  public List<String> getAllCategories() {
    return categoryService.getAllCategories();
  }

//  @PreAuthorize("hasAnyAuthority('ADMIN')") Alternative to requestmatcher in SecurityConfig
  @PostMapping ("/{category}")
  public void addCategory(@PathVariable String category){
    categoryService.addCategory(category);
  }
}
