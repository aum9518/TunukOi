package tunukOi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cards")
@Getter
@Setter
@NoArgsConstructor
public class Card {
    @Id
    @GeneratedValue(generator = "card_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "card_gen",sequenceName = "card_seq",allocationSize = 1)
    private Long id;
    private String text;
    private String image;
    @ManyToOne
    private User user;
}
