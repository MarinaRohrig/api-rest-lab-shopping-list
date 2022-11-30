package br.com.futurodev.shoppinglist.service;

import br.com.futurodev.shoppinglist.model.Category;
import br.com.futurodev.shoppinglist.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

    public Category getCategoryById(Long idCategory) {
        Category category = categoryRepository.findById(idCategory).get();
        return category;
    }
}