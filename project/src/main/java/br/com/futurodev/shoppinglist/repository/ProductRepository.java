package br.com.futurodev.shoppinglist.repository;

import br.com.futurodev.shoppinglist.model.Category;
import br.com.futurodev.shoppinglist.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public interface ProductRepository  extends JpaRepository<Product,Long> {


}
