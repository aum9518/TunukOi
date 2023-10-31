package tunukOi.dto;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public class SimpleResponse {
    private HttpStatus httpStatus;
    private String message;
}
