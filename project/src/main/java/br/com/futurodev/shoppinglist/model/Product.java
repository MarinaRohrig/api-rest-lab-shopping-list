package br.com.futurodev.shoppinglist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_category",referencedColumnName = "id",
              foreignKey = @ForeignKey(name = "fk_category"))
    private Category category;

    private String name;
    private double price;
    private boolean buyed;
}
