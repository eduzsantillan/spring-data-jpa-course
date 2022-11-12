package pe.isil.springdatajpademo.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping("/add")
    public void addCategory(@RequestBody Category category){
        categoryService.add(category);
    }

    @PostMapping("/update")
    public void addCategory(@RequestBody Category category, @RequestParam Long id){
        categoryService.update(category,id);
    }

    @GetMapping({"/getall",""})
    public List<Category> getAllCategories(){
        return categoryService.getAll();
    }

    @GetMapping("/getbyid")
    public Category getCategoryById(@RequestParam  Long id){
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/getbyname")
    public Category getCategoryByName(@RequestParam  String name){
        return categoryService.getCategoryByName(name);
    }




}
