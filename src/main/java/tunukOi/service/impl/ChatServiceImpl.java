package tunukOi.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import tunukOi.config.JwtService;
import tunukOi.dto.SimpleResponse;
import tunukOi.dto.chat.ChatResponse;
import tunukOi.entities.Chat;
import tunukOi.entities.GameField;
import tunukOi.entities.User;
import tunukOi.exceptions.NotFoundException;
import tunukOi.repositories.ChatRepository;
import tunukOi.repositories.GameFieldRepository;
import tunukOi.service.ChatService;

import java.util.List;
@Transactional
@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final GameFieldRepository gameFieldRepository;
    private final JwtService jwtService;


    @Override
    public SimpleResponse sendMessage(String message, Long gameFieldId) {
        GameField gameField = gameFieldRepository.findById(gameFieldId).orElseThrow(() -> new NotFoundException(String.format("Game field with id:%s is not found", gameFieldId)));
        User user = jwtService.getAuthenticationUser();
        Chat chat = new Chat();
        chat.setContent(message);
        chat.setSender(user.getNickName());
        chat.setMessageTime(DateTime.now());
        chatRepository.save(chat);
        chat.setUser(user);
        chat.setGameField(gameField);
        simpMessagingTemplate.convertAndSend("/topic/messages",message);
        return SimpleResponse.builder()
                .message("Success")
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public List<ChatResponse> getAllChats(Long gameFieldId) {
        GameField gameField = gameFieldRepository.findById(gameFieldId).orElseThrow(() ->
                new NotFoundException(String.format("Game field with id:%s is not found", gameFieldId)));
        simpMessagingTemplate.convertAndSend("/topics/history",chatRepository.getAllChatsByGameFieldId(gameField.getId()));
        return chatRepository.getAllChatsByGameFieldId(gameField.getId());
    }
}
