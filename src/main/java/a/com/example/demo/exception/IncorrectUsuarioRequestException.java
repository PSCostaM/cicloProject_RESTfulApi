package a.com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IncorrectUsuarioRequestException extends RuntimeException {
    public IncorrectUsuarioRequestException(String message) { super(message); }
}
