package be.dominionexperts.cvtool.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PdfGenerationFailedException extends GenerationFailedException {
    public PdfGenerationFailedException() {
        super("Pdf generation failed");
    }
}
