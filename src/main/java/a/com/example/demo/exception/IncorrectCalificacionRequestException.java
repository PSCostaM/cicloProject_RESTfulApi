package a.com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code =  HttpStatus.BAD_REQUEST)
public class IncorrectCalificacionRequestException extends RuntimeException{
    public IncorrectCalificacionRequestException(String message){
        super(message);
    }
}
