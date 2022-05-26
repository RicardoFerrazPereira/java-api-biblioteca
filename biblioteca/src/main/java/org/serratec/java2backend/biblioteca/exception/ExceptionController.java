package org.serratec.java2backend.biblioteca.exception;




import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	
//	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);
		
		@ExceptionHandler(value = {LivroException.class })
		protected ResponseEntity<Object> naoEncontrado(LivroException ex) {		
		       ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
		       apiError.setMessage(ex.getMessage());
		       apiError.setDebugMessage(ex.getLocalizedMessage());
//		       LOGGER.error(ex.getMessage(), ex);
		       return buildResponseEntity(apiError);
		}
		private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		       return new ResponseEntity<>(apiError, apiError.getStatus());
		   }
		
		

}
