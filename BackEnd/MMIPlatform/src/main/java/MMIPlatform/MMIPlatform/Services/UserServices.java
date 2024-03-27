package MMIPlatform.MMIPlatform.Services;

import MMIPlatform.MMIPlatform.Models.User;
import MMIPlatform.MMIPlatform.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import MMIPlatform.MMIPlatform.Models.IUT;

@Service
public class UserServices {
    private static final Logger logger = LoggerFactory.getLogger(UserServices.class);

    @Autowired
   private UserRepository userRepository;

@Transactional
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        users.forEach(user -> {
            user.getUser_id();
            user.getNom();
            user.getPrenom();
            user.getEmail();
            user.getPassword();
            user.getPromo().getPromo_id();
            user.getPromo().getNom();
           user.getIut().getIUT_id();
           user.getIut().getNom();
           user.getTickets().forEach(ticket -> {
               ticket.getTicket_id();
               ticket.getNom();
               ticket.getLangage();
               ticket.getDescription();
               ticket.getMatiere();
               ticket.getImg();
           });

        });
        logger.info("Fetched {} users from the database", users.size());
        return users;
    }
    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
      logger.info("Saved user with id {}", user.getUser_id());

    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
        logger.info("Deleted user with id {}", id);
    }

    public User getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            logger.error("User with id {} not found", id);
        } else {
            logger.info("Fetched user with id {}", id);
        }
        return user;
    }
   public void updateUser(User user) {
        userRepository.save(user);
        logger.info("Updated user with id {}", user.getUser_id());
    }



}
