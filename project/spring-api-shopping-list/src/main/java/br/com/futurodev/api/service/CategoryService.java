package br.com.futurodev.api.service;
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional 
    public Category save(Category category){
        return categoryRepository.save(category);
    }
    
}
