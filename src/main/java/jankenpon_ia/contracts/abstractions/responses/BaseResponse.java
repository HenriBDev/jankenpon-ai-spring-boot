package jankenpon_ia.contracts.abstractions.responses;

import org.springframework.http.ResponseEntity;

public interface BaseResponse {
    ResponseEntity<?> toResponseEntity();
}
