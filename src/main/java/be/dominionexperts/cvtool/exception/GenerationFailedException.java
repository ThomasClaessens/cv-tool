package be.dominionexperts.cvtool.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class GenerationFailedException extends RuntimeException {
    private final static Logger LOGGER = LoggerFactory.getLogger(GenerationFailedException.class);

    public GenerationFailedException(String message, Throwable e) {
        super("Document generation failed");
        LOGGER.error("Original error causing document generation failed: " + message, e);
    }

    GenerationFailedException(String message) {
        super(message);
    }
}
