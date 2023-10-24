package tunukOi.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import tunukOi.dto.SimpleResponse;
import tunukOi.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Override
    public SimpleResponse userUpdate(SimpleResponse userUpdateRequest) {
        return null;
    }
}
