package br.com.futurodev.shoppinglist.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private Category category;

    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private double price;
    private boolean buyed;
}
