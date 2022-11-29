package main.java.br.com.futurodev.api.model;

import java.io.Serializable;

import javax.annotation.processing.Generated;

@Getter
@Setter
@Entity
@Table (name = "product")
public class Product implements Serializable {
    @EqualsAndHashCode.Include
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn (name = "id_category",foreignKey = @ForeignKey(name="fk_category"))
    private Category category;
}
