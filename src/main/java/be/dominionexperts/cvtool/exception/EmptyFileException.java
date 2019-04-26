package be.dominionexperts.cvtool.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmptyFileException extends RuntimeException {
    public EmptyFileException() {
        super("Expected resume, received nothing");
    }
}
