package MMIPlatform.MMIPlatform.Services;
import MMIPlatform.MMIPlatform.Models.IUT;
import MMIPlatform.MMIPlatform.Repositories.IUTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUTService {
    @Autowired
    private IUTRepository iutRepository;

    public IUT findById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return iutRepository.findById(id).orElse(null);
    }


}
