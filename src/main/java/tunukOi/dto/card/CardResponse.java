package tunukOi.dto.card;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class CardResponse {
    private Long id;
    private String text;
    private String image;
}
