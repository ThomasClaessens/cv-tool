package be.dominionexperts.cvtool.controller;

import be.dominionexperts.cvtool.dto.Resume;
import be.dominionexperts.cvtool.exception.InvalidFileException;
import be.dominionexperts.cvtool.service.ResumeGenerationService;
import be.dominionexperts.cvtool.service.ValidatorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {
    private final ResumeGenerationService resumeGenerationService;
    private final ValidatorService validatorService;

    public UploadController(ResumeGenerationService resumeGenerationService, ValidatorService validatorService) {
        this.resumeGenerationService = resumeGenerationService;
        this.validatorService = validatorService;
    }

    @RequestMapping(value = "api/upload", method = RequestMethod.POST)
    public Resume parseResumeFromJsonFile(@RequestParam("json-file") MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new InvalidFileException();
        }

        return validatorService.validateResume(
                resumeGenerationService.generateResume(file)
        );
    }

}
