package tunukOi.dto.chat;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ChatResponse {
    private Long id;
    private String sender;
    private String text;
    private DateTime time;

    public ChatResponse(Long id, String sender, String text, DateTime time) {
        this.id = id;
        this.sender = sender;
        this.text = text;
        this.time = time;
    }
}
