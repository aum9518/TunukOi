package tunukOi.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tunukOi.config.JwtService;
import tunukOi.dto.SimpleResponse;
import tunukOi.dto.user.UserRequest;
import tunukOi.entities.Card;
import tunukOi.entities.User;
import tunukOi.exceptions.NotFoundException;
import tunukOi.repositories.CardRepository;
import tunukOi.repositories.UserRepository;
import tunukOi.service.UserService;
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final CardRepository cardRepository;

    @Override
    public SimpleResponse getNickNameAndImage(UserRequest userRequest) {
        User user = jwtService.getAuthenticationUser();
        user.setNickName(userRequest.getNickName());
        user.setImage(userRequest.getImage());
        userRepository.save(user);
        return SimpleResponse.builder()
                .message("Success")
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public SimpleResponse addCardToUser(Long cardId) {
        User user = jwtService.getAuthenticationUser();
        Card card = cardRepository.findById(cardId).orElseThrow(() -> new NotFoundException(String.format("Card with id:%s is not found", cardId)));
        user.getCards().add(card);
        return SimpleResponse.builder()
                .message("Success")
                .httpStatus(HttpStatus.OK)
                .build();
    }
}
