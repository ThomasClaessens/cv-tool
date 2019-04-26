package be.dominionexperts.cvtool.service;

import be.dominionexperts.cvtool.dto.Resume;
import be.dominionexperts.cvtool.exception.PdfGenerationFailedException;
import be.dominionexperts.cvtool.exception.TemplateNotFoundException;
import be.dominionexperts.cvtool.util.XDocUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class PdfGenerationService {

    private static final String TECHNICAL_CV_REFERENCE_DOCX = "/Technical_CV_reference.docx";

    public byte[] generatePdf(Resume resume) {
        try{
            InputStream template = this.getClass().getResourceAsStream(TECHNICAL_CV_REFERENCE_DOCX);
            return XDocUtils.generateDocument(template.readAllBytes(), resume, true)
                .orElseThrow(PdfGenerationFailedException::new);
        }
        catch (IOException e) {
            throw new TemplateNotFoundException(TECHNICAL_CV_REFERENCE_DOCX);
        }
    }
}
