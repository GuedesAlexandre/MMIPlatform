package MMIPlatform.MMIPlatform.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import MMIPlatform.MMIPlatform.Models.User;
import MMIPlatform.MMIPlatform.Services.UserServices;

import java.util.List;

@RestController
public class UserControllers {
    @Autowired
    private UserServices userService;
    @RequestMapping("/api/user")

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
