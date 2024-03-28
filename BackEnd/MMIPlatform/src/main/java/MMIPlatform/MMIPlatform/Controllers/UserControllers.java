package MMIPlatform.MMIPlatform.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import MMIPlatform.MMIPlatform.Models.Promo;
import MMIPlatform.MMIPlatform.Models.User;
import MMIPlatform.MMIPlatform.Services.UserServices;
import MMIPlatform.MMIPlatform.Services.promoService;
import MMIPlatform.MMIPlatform.Models.IUT;
import MMIPlatform.MMIPlatform.Services.IUTService;

import java.util.List;

@RestController
public class UserControllers {
    @Autowired
    private UserServices userService;

    @Autowired
    private promoService promoService;

    @Autowired
    private IUTService iutService;
   

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        if (user.getEmail() == null) {
            return new ResponseEntity<>("Received user: " + user.toString() + ". Email cannot be null", HttpStatus.BAD_REQUEST);
        }
        if (user.getNom() == null) {
            return new ResponseEntity<>("Received user: " + user.toString() + ". Nom cannot be null", HttpStatus.BAD_REQUEST);
        }
        if (user.getPromo() != null) {
            Integer promoId = user.getPromo().getPromo_id();
            if (promoId != null) {
                Promo promo = promoService.findById(promoId);
                if (promo == null) {
                    return new ResponseEntity<>("Promo with id " + promoId + " not found", HttpStatus.BAD_REQUEST);
                }
                user.setPromo(promo);
            }
        }
        if(user.getIut() != null){
            Integer iut_Id = user.getIut().getIUT_id();
            if(iut_Id != null){
                IUT iut = iutService.findById(iut_Id);
                if(iut == null){
                    return new ResponseEntity<>("IUT with id " + iut_Id + " not found", HttpStatus.BAD_REQUEST);
                }
                user.setIut(iut);
            }
        }
        userService.saveUser(user);
        return new ResponseEntity<>("User saved successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
public ResponseEntity<String> deleteUser(@PathVariable Long id) {
    User user = userService.getUserById(id);
    if (user == null) {
        return new ResponseEntity<>("User with id " + id + " not found", HttpStatus.BAD_REQUEST);
    }

    // Supprimer l'association avec la promo et l'IUT
    user.setPromo(null);
    user.setIut(null);

    // Sauvegarder l'utilisateur pour mettre à jour les associations
    userService.saveUser(user);

    // Supprimer l'utilisateur
    userService.deleteUser(id);
    return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
}
@PutMapping("/update/{id}")
public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
    User user = userService.getUserById(id);
    if (user == null) {
        return new ResponseEntity<>("User with id " + id + " not found", HttpStatus.BAD_REQUEST);
    }

    // Mettre à jour les attributs de l'utilisateur
    user.setNom(updatedUser.getNom());
    // Mettre à jour les autres attributs...
    user.setEmail(updatedUser.getEmail());
    user.setPassword(updatedUser.getPassword());
    user.setPrenom(updatedUser.getPrenom());
    user.setRole(updatedUser.getRole());
    // Mettre à jour l'association avec la promo
    if (updatedUser.getPromo() != null) {
        Promo promo = promoService.findById(updatedUser.getPromo().getPromo_id());
        if (promo == null) {
            return new ResponseEntity<>("Promo with id " + updatedUser.getPromo().getPromo_id() + " not found", HttpStatus.BAD_REQUEST);
        }
        user.setPromo(promo);
    } else {
        user.setPromo(null);
    }

    // Mettre à jour l'association avec l'IUT
    if (updatedUser.getIut() != null) {
        IUT iut = iutService.findById(updatedUser.getIut().getIUT_id());
        if (iut == null) {
            return new ResponseEntity<>("IUT with id " + updatedUser.getIut().getIUT_id() + " not found", HttpStatus.BAD_REQUEST);
        }
        user.setIut(iut);
    } else {
        user.setIut(null);
    }

    // Sauvegarder l'utilisateur pour mettre à jour les associations
    userService.saveUser(user);
    return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
}
    
    
}
