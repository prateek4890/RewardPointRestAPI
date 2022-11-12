package rewards.customers.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(CustomException.class)
 	public ResponseEntity<Object> handleCustomException(CustomException ex) {
		CustomError err = new CustomError(false, ex.getMessage(), HttpStatus.NOT_ACCEPTABLE, LocalDateTime.now());
		return ResponseEntityBuilder.build(err);
	}
	@Override
 	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		CustomError err = new CustomError(false, "Missing Parameters", HttpStatus.BAD_REQUEST,
				LocalDateTime.now());
		return ResponseEntityBuilder.build(err);

	}
	@ExceptionHandler(Exception.class)
 	public ResponseEntity<Object> superException(Exception ex) {
		CustomError err = new CustomError(false, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());
		return ResponseEntityBuilder.build(err);
	}

}
