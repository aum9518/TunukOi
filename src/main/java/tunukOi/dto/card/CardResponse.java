package tunukOi.dto.card;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CardResponse {

    private Long id;
    private String text;
    private String image;

    @Builder
    public CardResponse(Long id, String text, String image) {
        this.id = id;
        this.text = text;
        this.image = image;
    }
}
