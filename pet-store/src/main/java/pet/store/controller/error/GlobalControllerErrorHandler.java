package pet.store.controller.error;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalControllerErrorHandler {

	
	// NoSuchElementException handler to return a 404 error when an element is not found, using the @ExceptionHandler to identify 
	// this method as handling NoSuchElement exceptions, and @ResponseStatus to set the HTTP error for the response.
	
	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	
	public Map<String, String> handleNoSuchElementException(NoSuchElementException ex) {
		log.info("NoSuchElementException occurred: {}", ex.getMessage());
		
		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("message", ex.toString());
		return errorResponse;
	}
	

}
