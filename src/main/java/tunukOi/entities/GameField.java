package tunukOi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "game_fields")
@Getter
@Setter
@NoArgsConstructor
public class GameField {
    @Id
    @GeneratedValue(generator = "game_field_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "game_field_gen",sequenceName = "game_field_seq",allocationSize = 1)
    private Long id;
    @ManyToOne
    private User user;

}
