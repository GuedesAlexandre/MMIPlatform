package MMIPlatform.MMIPlatform.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MMIPlatform.MMIPlatform.Repositories.PromoRepository;
import MMIPlatform.MMIPlatform.Models.Promo;

@Service
public class promoService {
    @Autowired
    private PromoRepository promoRepository;

    public Promo findById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return promoRepository.findById(id).orElse(null);
    }

    
}
