package br.com.futurodev.shoppinglist.service;

import br.com.futurodev.shoppinglist.model.Product;
import br.com.futurodev.shoppinglist.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Product saveProd(Product product){
        // configurar aqui:
        // Não permitir cadastro duplicado
        //  Não permitir cadastro com campos inválidos
        return productRepository.save(product);
    }
}
