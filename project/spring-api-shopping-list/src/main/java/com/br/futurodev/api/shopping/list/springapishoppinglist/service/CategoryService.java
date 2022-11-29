@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional 
    public Category save(Category category){
        return categoryRepository.save(category);
    }
    
}
