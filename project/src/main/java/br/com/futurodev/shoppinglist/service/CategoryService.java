package br.com.futurodev.shoppinglist.service;

import br.com.futurodev.shoppinglist.model.Category;
import br.com.futurodev.shoppinglist.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public Category saveCat(Category category){
        return categoryRepository.save(category);
    }
    @Transactional
    public void deleteById(Long idCategory){
        categoryRepository.deleteById(idCategory);
    }

    @Transactional
    public List<Category> getCategory(){return (List <Category> )categoryRepository.findAll();}


}
