package br.com.futurodev.shoppinglist.repository;

import br.com.futurodev.shoppinglist.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
