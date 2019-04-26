package be.dominionexperts.cvtool.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidJsonException extends RuntimeException {
    public InvalidJsonException() {
        super("Unable to parse JSON file");
    }
}
