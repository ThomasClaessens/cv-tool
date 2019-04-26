package be.dominionexperts.cvtool.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TemplateException extends RuntimeException {
    public TemplateException(String templateName) {
        super(String.format("Unable to parse template file %s", templateName));
    }
}
