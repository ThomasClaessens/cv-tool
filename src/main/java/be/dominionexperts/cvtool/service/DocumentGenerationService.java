package be.dominionexperts.cvtool.service;

import be.dominionexperts.cvtool.dto.Resume;
import be.dominionexperts.cvtool.exception.PdfGenerationFailedException;
import be.dominionexperts.cvtool.exception.TemplateException;
import be.dominionexperts.cvtool.util.XDocUtils;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class DocumentGenerationService {
    private static final String TECHNICAL_CV_REFERENCE_DOCX = "/cv_template.docx";

    public byte[] generateDocument(Resume resume, boolean isPdf) {
        try {
            InputStream template = this.getClass().getResourceAsStream(TECHNICAL_CV_REFERENCE_DOCX);
            return XDocUtils.generateDocument(template.readAllBytes(), resume, isPdf)
                            .orElseThrow(PdfGenerationFailedException::new);
        } catch (Exception e) {
            throw new TemplateException(TECHNICAL_CV_REFERENCE_DOCX);
        }
    }
}
