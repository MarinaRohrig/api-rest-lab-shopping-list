package br.com.futurodev.shoppinglist.repository;

import br.com.futurodev.shoppinglist.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product,Long> {

}
