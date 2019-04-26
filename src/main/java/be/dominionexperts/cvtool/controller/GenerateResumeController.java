package be.dominionexperts.cvtool.controller;

import be.dominionexperts.cvtool.dto.Resume;
import be.dominionexperts.cvtool.service.PdfGenerationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenerateResumeController {

    private final PdfGenerationService pdfGenerationService;

    public GenerateResumeController(PdfGenerationService pdfGenerationService) {
        this.pdfGenerationService = pdfGenerationService;
    }

    @RequestMapping(value = "api/generate/resume", method = RequestMethod.POST, produces = "application/pdf")
    public ResponseEntity<byte[]> generate(@RequestBody Resume resume) {
        return ResponseEntity.ok(pdfGenerationService.generatePdf(resume));
    }

}
