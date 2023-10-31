package tunukOi.service;

import tunukOi.dto.SimpleResponse;
import tunukOi.dto.chat.ChatResponse;

import java.util.List;

public interface ChatService {
    SimpleResponse sendMessage(String message, Long gameFieldId);
    List<ChatResponse> getAllChats(Long gameFieldId);
}
