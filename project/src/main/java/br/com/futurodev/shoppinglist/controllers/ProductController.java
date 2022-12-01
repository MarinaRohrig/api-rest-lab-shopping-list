package br.com.futurodev.shoppinglist.controllers;


import br.com.futurodev.shoppinglist.dto.ProductRepresentation;
import br.com.futurodev.shoppinglist.input.ProductInput;
import br.com.futurodev.shoppinglist.model.Product;
import br.com.futurodev.shoppinglist.service.CategoryService;
import br.com.futurodev.shoppinglist.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;


@Api(tags = "Product")
@RestController
@RequestMapping(value="/products/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation("Salva produtos")
    @PostMapping
    public ResponseEntity<ProductRepresentation> registry(@RequestBody ProductInput productInput){
        Product product = toDomainObject(productInput);
        productService.saveProd(product);
        return new ResponseEntity<>(toModel(product), HttpStatus.CREATED);
    }

    @ApiOperation("Atualiza os produtos")
    @PutMapping
    public ResponseEntity<ProductRepresentation> update(@RequestBody ProductInput productInput){
        Product product = productService.saveProd(toDomainObject(productInput));
        return new ResponseEntity<>(toModel(product),HttpStatus.OK);
    }

    @ApiOperation("Lista os produtos")
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<ProductRepresentation>> getProducts(){
        List<Product> products = productService.getProducts();
        List<ProductRepresentation> productRepresentation  = toCollection(products);
        return new ResponseEntity<>(productRepresentation,HttpStatus.OK);
    }

    @ApiOperation("Deleta um produto")
    @DeleteMapping
    @ResponseBody
    public ResponseEntity<String> delete(@ApiParam(value = "ID do produto", example = "12") @RequestParam Long idProduct){
        productService.deleteById(idProduct);
        return new ResponseEntity<String>("Produto: " + idProduct +", deletado!", HttpStatus.OK);
    }

    private List<ProductRepresentation> toCollection(List<Product> products){
        return products.stream().map(Product -> toModel(Product)).collect(Collectors.toList());
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
