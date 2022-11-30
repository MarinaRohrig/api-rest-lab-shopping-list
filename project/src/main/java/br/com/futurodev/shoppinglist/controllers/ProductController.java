package br.com.futurodev.shoppinglist.controllers;

import br.com.futurodev.shoppinglist.dto.ProductRepresentation;
import br.com.futurodev.shoppinglist.input.ProductInput;
import br.com.futurodev.shoppinglist.model.Product;
import br.com.futurodev.shoppinglist.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api(tags = "Product")
@RestController
@RequestMapping(value="/products/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation("Register a product")
    @PostMapping
    public ResponseEntity<ProductRepresentation> register(@RequestBody ProductInput productInput){
        Product product = toDomainObject(productInput);
        productService.saveProd(product);
        return new ResponseEntity<>(toModel(product), HttpStatus.CREATED);
    }

    @ApiOperation("Update a product")
    @PutMapping
    public ResponseEntity<ProductRepresentation> update(@RequestBody ProductInput productInput){
        Product product = productService.saveProd(toDomainObject(productInput));
        return new ResponseEntity<>(toModel(product),HttpStatus.OK);
    }

  

    private Product toDomainObject(ProductInput productInput){
        Product product = new Product();
        product.setId(productInput.getIdProduct());
        product.setDescription(productInput.getDescription());
        product.setPrice(productInput.getPrice());
        return product;
    }

    private ProductRepresentation toModel(Product product){
        ProductRepresentation productRepresentation = new ProductRepresentation();
        productRepresentation.setId(product.getId());
        productRepresentation.setDescription(product.getDescription());
        productRepresentation.setPrice(product.getPrice());
        return productRepresentation;
    }


}
