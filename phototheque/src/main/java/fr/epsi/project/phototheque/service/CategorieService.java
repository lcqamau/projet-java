package fr.epsi.project.phototheque.service;
import fr.epsi.project.phototheque.entity.Categorie;
import fr.epsi.project.phototheque.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {

    private final CategorieRepository categorieRepository;

    @Autowired
    public CategorieService(CategorieRepository categoryRepository) {
        this.categorieRepository = categoryRepository;
    }

    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    public Optional<Categorie> getCategoryById(Long id) {
        return categorieRepository.findById(id);
    }

    public Categorie saveCategory(Categorie category) {
        return categorieRepository.save(category);
    }

    public void deleteCategoryById(Long id) {
        categorieRepository.deleteById(id);
    }
}