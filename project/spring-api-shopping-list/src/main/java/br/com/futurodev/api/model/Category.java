
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
