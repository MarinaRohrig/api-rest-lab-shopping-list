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


import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;


@Api(tags = "Product")
@RestController
@RequestMapping(value="/products/")
public class ProductController {

    @Autowired
    private ProductService productService;

   private DecimalFormat formater = new DecimalFormat("0.00");

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

    @ApiOperation("Lista o valor total comprado")
    @GetMapping(value = "expenses")
    @ResponseBody
    public ResponseEntity<String> expenses (){
        double value = 0.0;
        List<Product> products = productService.getProducts();
        for (int i = 0; i<productService.getProducts().size(); i++){
            value += products.get(i).getPrice();
        }
        return new ResponseEntity<String>("O valor total gasto foi de: R$" + formater.format(value), HttpStatus.OK);
    }

    private List<ProductRepresentation> toCollection(List<Product> products){
        return products.stream().map(Product -> toModel(Product)).collect(Collectors.toList());
    }
  

    private Product toDomainObject(ProductInput productInput){
        Product product = new Product();
        product.setId(productInput.getIdProduct());
        product.setName(productInput.getName());
        product.setPrice(productInput.getPrice());
        product.setBuyed(productInput.isBuyed());
        return product;
    }

    private ProductRepresentation toModel(Product product){
        ProductRepresentation productRepresentation = new ProductRepresentation();
        productRepresentation.setId(product.getId());
        productRepresentation.setName(product.getName());
        productRepresentation.setPrice(product.getPrice());
        productRepresentation.setBuyed(product.isBuyed());
        return productRepresentation;
    }


}
