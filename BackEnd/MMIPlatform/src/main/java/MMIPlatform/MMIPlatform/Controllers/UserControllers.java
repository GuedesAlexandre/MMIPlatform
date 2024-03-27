package MMIPlatform.MMIPlatform.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import MMIPlatform.MMIPlatform.Models.Promo;
import MMIPlatform.MMIPlatform.Models.User;
import MMIPlatform.MMIPlatform.Services.UserServices;
import MMIPlatform.MMIPlatform.Services.promoService;

import java.util.List;

@RestController
public class UserControllers {
    @Autowired
    private UserServices userService;

    @Autowired
    private promoService promoService;
   

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
        userService.saveUser(user);
        return new ResponseEntity<>("User saved successfully", HttpStatus.OK);
    }
}
