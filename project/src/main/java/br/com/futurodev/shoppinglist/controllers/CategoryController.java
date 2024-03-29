package br.com.futurodev.shoppinglist.controllers;

import br.com.futurodev.shoppinglist.dto.CategoryRepresentation;
import br.com.futurodev.shoppinglist.dto.ProductRepresentation;
import br.com.futurodev.shoppinglist.input.CategoryInput;
import br.com.futurodev.shoppinglist.model.Category;
import br.com.futurodev.shoppinglist.model.Product;
import br.com.futurodev.shoppinglist.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@Api(tags = "Category")
@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    
    @ApiOperation("Salva categorias")
    @PostMapping
    public ResponseEntity<CategoryRepresentation> registry (@RequestBody CategoryInput categoryInput){
        Category category = categoryService.saveCat(toDomainObject(categoryInput));
        return new ResponseEntity<>(toModel(category), HttpStatus.OK);
    }

    @ApiOperation("Deleta uma categoria")
    @DeleteMapping
    @ResponseBody
    public ResponseEntity<String> delete(@ApiParam(value="ID da categoria", example = "12") @RequestParam Long idCategory){
        categoryService.deleteById(idCategory);
        return new ResponseEntity<>("Categoria:"+ idCategory+", deletado!", HttpStatus.OK);
    }

    @ApiOperation("Lista as categorias")
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<CategoryRepresentation>> getCategory(){
        List<Category> categories = categoryService.getCategory();
        List<CategoryRepresentation> categoryRepresentation = toCollection(categories);
        return new ResponseEntity<>(categoryRepresentation, HttpStatus.OK);
    }


    private List <CategoryRepresentation> toCollection(List<Category> categories){
        return categories.stream().map(Category -> toModel(Category)).collect(Collectors.toList());
    }
    private Category toDomainObject(CategoryInput categoryInput){
        Category category = new Category();
        category.setId(categoryInput.getIdCategory());
        category.setDescription(categoryInput.getDescription());
        category.setName(categoryInput.getName());
        return category;
    }
    private CategoryRepresentation toModel (Category category){
        CategoryRepresentation categoryRepresentation = new CategoryRepresentation();
        categoryRepresentation.setIdCategory(category.getId());
        categoryRepresentation.setDescription(category.getDescription());
        categoryRepresentation.setName(category.getName());
        return categoryRepresentation;
    }
}
