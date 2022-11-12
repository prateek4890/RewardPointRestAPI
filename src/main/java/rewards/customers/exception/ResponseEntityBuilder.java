package rewards.customers.exception;

import org.springframework.http.ResponseEntity;

public class ResponseEntityBuilder {
	 public static ResponseEntity<Object> build(CustomError apiError) {
         return new ResponseEntity<>(apiError, apiError.getHttpStatus());
   }
}
