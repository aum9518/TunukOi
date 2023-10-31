package tunukOi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tunukOi.dto.chat.ChatResponse;
import tunukOi.entities.Chat;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    @Query("select new tunukOi.dto.chat.ChatResponse(ch.id,ch.content,ch.sender,ch.messageTime) from Chat ch")
    List<ChatResponse> getAllChatsByGameFieldId(Long id);
}