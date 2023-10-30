package tunukOi.service;

import tunukOi.dto.card.CardResponse;

import java.util.List;

public interface CardService {
    CardResponse getCardById(Long cardId);
    List<CardResponse> getAllCards();

}
