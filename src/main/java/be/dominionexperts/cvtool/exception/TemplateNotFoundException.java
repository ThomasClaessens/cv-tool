package be.dominionexperts.cvtool.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TemplateNotFoundException extends RuntimeException {
    public TemplateNotFoundException(String templateName) {
        super(String.format("Expected a template, none found %s", templateName));
    }
}
