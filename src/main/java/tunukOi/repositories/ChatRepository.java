package tunukOi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tunukOi.entities.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}