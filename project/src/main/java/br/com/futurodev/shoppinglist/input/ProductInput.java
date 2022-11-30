package br.com.futurodev.shoppinglist.input;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductInput {

    private Long idProduct;

    private Long idCategory;

    private String description;

    private double price;

    private boolean buyed;


}
