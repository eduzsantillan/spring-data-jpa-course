package pe.isil.springdatajpademo.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id){
        return categoryRepository.findById(id).get();
    }

    public Category getCategoryByName(String name){
        return categoryRepository.findByDescription(name);
    }

    public void add(Category category){

        categoryRepository.save(category);

    }

    @Transactional
    public void update(Category category, Long id){

        Optional<Category> categoryToUpdate = categoryRepository.findById(id);

        if(categoryToUpdate.isPresent()){
            categoryToUpdate.get().setDescription(category.getDescription()!=null?
                    category.getDescription():categoryToUpdate.get().getDescription());
        }else{
            throw new RuntimeException("Category does not exist");
        }
    }

    public void delete(Long id){
        Optional<Category> categoryToDelete = categoryRepository.findById(id);
        if(categoryToDelete.isPresent()){
            categoryRepository.delete(categoryToDelete.get());
        }else{
            throw new RuntimeException("Category does not exist");
        }
    }



}
