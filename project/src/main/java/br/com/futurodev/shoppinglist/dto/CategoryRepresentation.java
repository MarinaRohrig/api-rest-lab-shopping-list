package br.com.futurodev.shoppinglist.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRepresentation {
    private Long idCategory;
    private String name;
    private String description;
}
