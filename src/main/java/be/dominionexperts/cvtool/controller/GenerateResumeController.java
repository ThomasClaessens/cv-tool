package be.dominionexperts.cvtool.controller;

import be.dominionexperts.cvtool.dto.Resume;
import be.dominionexperts.cvtool.service.DocumentGenerationService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenerateResumeController {
    final static String PDF_FORMAT = MediaType.APPLICATION_PDF_VALUE;
    final static String DOCX_FORMAT = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";

    private final DocumentGenerationService documentGenerationService;

    public GenerateResumeController(DocumentGenerationService documentGenerationService) {
        this.documentGenerationService = documentGenerationService;
    }

    @RequestMapping(value = "api/generate/resume", method = RequestMethod.POST, produces = {PDF_FORMAT, DOCX_FORMAT})
    public ResponseEntity<byte[]> generatePdf(@RequestBody Resume resume, @RequestParam(value = "pdf", required = false, defaultValue = "true") boolean isPdf) {
        return ResponseEntity.ok()
                             .contentType(isPdf ? MediaType.valueOf(PDF_FORMAT) : MediaType.valueOf(DOCX_FORMAT))
                             .body(documentGenerationService.generateDocument(resume, isPdf));
    }

}
