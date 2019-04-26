package be.dominionexperts.cvtool.exception;

import be.dominionexperts.cvtool.exception.dto.ValidationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ValidationException extends RuntimeException {
    private final static Logger LOGGER = LoggerFactory.getLogger(ValidationException.class);

    public ValidationException(List<ValidationError> validationErrors) {
        super("Validations failed!");
        logErrorMessage(validationErrors);
    }

    private void logErrorMessage(List<ValidationError> validationErrors) {
        validationErrors.forEach(validationError -> {
            LOGGER.error(String.format("'%s' has an invalid value '%s': '%s'",
                                    validationError.getField(),
                                    validationError.getValue(),
                                    validationError.getIssue()));
        });
    }
}
