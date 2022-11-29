package main.java.br.com.futurodev.api.model;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table ( name = "category")
public class Category implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
