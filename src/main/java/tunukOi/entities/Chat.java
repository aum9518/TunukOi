package tunukOi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;

@Entity
@Table(name = "chats")
@Getter
@Setter
@NoArgsConstructor
public class Chat {
    @Id
    @GeneratedValue(generator = "chat_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "chat_gen",sequenceName = "chat_seq",allocationSize = 1)
    private Long id;
    private String sender;
    private String content;
    private DateTime messageTime;
    @ManyToOne
    private User user;
}
