package be.dominionexperts.cvtool.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidFileException extends RuntimeException {
    public InvalidFileException() {
        super("Expected resume, received nothing");
    }
}
