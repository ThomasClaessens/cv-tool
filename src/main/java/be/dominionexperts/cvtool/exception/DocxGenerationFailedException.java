package be.dominionexperts.cvtool.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DocxGenerationFailedException extends GenerationFailedException {
    public DocxGenerationFailedException() {
        super("Docx generation failed");
    }
}
