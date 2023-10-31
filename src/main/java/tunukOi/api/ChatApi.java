package tunukOi.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tunukOi.dto.SimpleResponse;
import tunukOi.dto.chat.ChatResponse;
import tunukOi.service.ChatService;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
@Tag(name = "Chat API", description = "Endpoints for managing user's chats")
@PreAuthorize(value = "hasAnyAuthority('ADMIN','USER')")
public class ChatApi {

    private final ChatService chatService;

    @MessageMapping("/chat")
    @Operation(summary = "Save chat", description = "This is a method of saving chats")
    public SimpleResponse sendMessage(@RequestParam String message, @RequestParam Long gameFieldId){
        return chatService.sendMessage(message,gameFieldId);
    }

    @MessageMapping("/history")
    @Operation(summary = "Get all chats", description = "This is a method of getting all chats")
    public List<ChatResponse> getAllChats(@RequestParam Long gameFieldId){
        return chatService.getAllChats(gameFieldId);
    }
}
