package br.com.futurodev.shoppinglist.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryInput {
    private Long idCategory;
    private String name;
    private String description;
}
