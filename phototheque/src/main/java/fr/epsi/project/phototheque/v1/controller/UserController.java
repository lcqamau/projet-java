package fr.epsi.project.phototheque.v1.controller;

import fr.epsi.project.phototheque.entity.User;
import fr.epsi.project.phototheque.service.UserService;
import fr.epsi.project.phototheque.v1.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * Controleur permettant de gérer les appels http de la forme "/v1/user"
 *
 * <p>
 *     L'annotation <i>@RestController</i> permet d'indiquer à spring-mvc que l'instance de
 *     cette classe permet d'intercepter des acces par API REST.
 * </p>
 * <p>
 *     L'annotation <i>@RequestMapping</i> indique que le path commencera par <i>/v1/users</i>
 * </p>
 */
@RestController
@RequestMapping("/v1/users")
public class UserController {

    /**
     * Permet de récuperer et de sauvegarder des éléments liés à un utilisateur.
     */
    UserService userService;

    /**
     * Constructeur.
     *
     * <p>
     *  Lors de l'instanciation par spring, il va invoquer ce constructeur en passant l'instance de la
     *  classe <i>UserService</i>.
     * </p>
     *
     * @param userService Service d'acces aux utilisateurs.
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Permet de récuperer la liste des utilisateurs.
     *
     * <p>
     *     Le paramétre <i>pageable</i> permet de gérer automatiquement la pagination. Pour renseigner la pagonation, il suffit de fournir dans l'url :
     *     <ul>
     *         <li>le parametre <i>size</i> pour indiquer le nombre d'élements par page</li>
     *         <li>le parametre <i>page</i> pour indiquer l'index de la page</li>
     *     </ul>
     * </p>
     * @param pageable indique les elements de pagination.
     * @return contient les utilisateurs en fonction de la pagination.
     */
    @GetMapping
    public Page<UserDto> findAll(Pageable pageable){
        return this.userService.findAll(pageable)
                .map(it -> new UserDto(it.getId(), it.getFirstname(), it.getLastname()));
    }

    /**
     * Permet de recuperer un utilisateur en fonction de son identifiant.
     *
     * @param id Identifiant de l'utilisateur recherché.
     * @return response contenant l'utilisateur ou reponse indiquant qu'au utilisateur n'a été trouvé.
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable(name = "id") Long id){
        var user = this.userService.findUserById(id);
        return ResponseEntity.of(user.map(it -> new UserDto(it.getId(), it.getFirstname(), it.getLastname())));
    }

    /**
     * Permet de sauvegarder un utilisateur.
     *
     * @param user utilisateur à sauvegarder.
     * @return
     */
    @PostMapping
    public ResponseEntity save(@RequestBody UserDto user){
        var userEntity = new User();
        userEntity.setFirstname(user.getFirstname());
        userEntity.setLastname(user.getLastname());
        this.userService.save(userEntity);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(userEntity.getId()))
                .build();
    }

}
