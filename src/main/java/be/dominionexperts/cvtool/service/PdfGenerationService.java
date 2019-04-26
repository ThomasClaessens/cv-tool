package be.dominionexperts.cvtool.service;

import be.dominionexperts.cvtool.dto.Resume;
import be.dominionexperts.cvtool.util.XDocUtils;
import fr.opensagres.xdocreport.core.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;

@Service
public class PdfGenerationService {

    private static final String TECHNICAL_CV_REFERENCE_DOCX = "/Technical_CV_reference.docx";

    public byte[] generatePdf(Resume resume) throws IOException {
        URL templateFile = this.getClass().getResource(TECHNICAL_CV_REFERENCE_DOCX);
        byte[] template = IOUtils.toByteArray(templateFile.openStream());
        return XDocUtils.generateDocument(template, resume, true)
                .orElseThrow(IllegalArgumentException::new);
    }
}
