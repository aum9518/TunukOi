package tunukOi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tunukOi.entities.GameField;

public interface GameFieldRepository extends JpaRepository<GameField, Long> {
}