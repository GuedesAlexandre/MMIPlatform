package MMIPlatform.MMIPlatform.Repositories;
import MMIPlatform.MMIPlatform.Models.IUT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUTRepository extends JpaRepository<IUT, Integer> {
}
