package comexample.backend.exception;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler  extends ResponseEntityExceptionHandler{
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
		Map<String, Object> responseBody = new new LinkedHashMap<>();
		responseBody.put("timestamp",  new Date());
		responseBody.put("status",  status.value())
		
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x->x.getDefaultMessage())collect(Collectors.toList())
		responseBody.put("errors", errors);.
		return new ResponseEntity<>(responseBody, headers, status);
	}
}

@Service 
public class CustService{
				+ "
	}
}


public class ExceptionHandler {

}
