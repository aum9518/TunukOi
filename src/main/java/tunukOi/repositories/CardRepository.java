package tunukOi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tunukOi.entities.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
}