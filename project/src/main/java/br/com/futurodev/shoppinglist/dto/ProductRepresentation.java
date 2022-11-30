package br.com.futurodev.shoppinglist.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRepresentation {
    private Long id;
    private String description;
    private double price;
    private boolean buyed;
}
