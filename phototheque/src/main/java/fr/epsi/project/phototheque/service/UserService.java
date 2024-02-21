package fr.epsi.project.phototheque.service;

import fr.epsi.project.phototheque.entity.User;
import fr.epsi.project.phototheque.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Classe de service permettant de gérer les utilisateurs.
 *
 * <p>
 *    L'annotation <i>@Component</i> permet d'indiquer à spring que cette classe doit être pris en charge par ses soins. spring a la
 *    reponsabilité de gérer les instances de cette classe.
 * </p>
 *
 * <p>
 *     L'annotation <i>@Transactional</i> indique le mode de transaction pour accéder aux données.
 * </p>
 */
@Component
@Transactional(readOnly = true)
public class UserService {

    /**
     * Repository accédant aux données stockées en base de données.
     */
    UserRepository userRepository;

    /**
     * Constructeur.
     * @param userRepository Repository des utilisateur.
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retourne les utilisateurs.
     *
     * @param page pagination
     * @return
     */
    public Page<User> findAll(Pageable page){
        return this.userRepository.findAll(page);
    }


    /**
     * Permet de retourner un utilisateur.
     *
     * @param id Identifiant de l'utilisateur.
     * @return
     */
    public Optional<User> findUserById(Long id){
        return this.userRepository.findById(id);
    }

    /**
     * Permet de sauvegarder un utilisateur.
     * @param user
     * @return
     */
    @Transactional(readOnly = false)
    public User  save(User user){
        return this.userRepository.save(user);
    }
}
