package be.dominionexperts.cvtool.controller;

import be.dominionexperts.cvtool.dto.Resume;
import be.dominionexperts.cvtool.exception.EmptyFileException;
import be.dominionexperts.cvtool.exception.ValidationException;
import be.dominionexperts.cvtool.exception.dto.ValidationError;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UploadController {

    @RequestMapping(value = "api/upload", method = RequestMethod.POST)
    public Resume parseResumeFromJsonFile(@RequestParam("json-file") MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            throw new EmptyFileException();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return validateResume(objectMapper.readValue(file.getBytes(), Resume.class));
    }

    private Resume validateResume(Resume resume) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        List<ValidationError> validationErrors = validator.validate(resume)
                                                          .stream()
                                                          .map(this::mapConstraintToValidationError)
                                                          .collect(Collectors.toList());

        if (!validationErrors.isEmpty()) {
            throw new ValidationException(validationErrors);
        }

        return resume;
    }

    private ValidationError mapConstraintToValidationError(ConstraintViolation<Resume> violation) {
        ValidationError validationError = new ValidationError();
        validationError.setField(violation.getPropertyPath().toString());
        validationError.setValue(violation.getInvalidValue() == null ? "null" : violation.getInvalidValue().toString());
        validationError.setIssue(violation.getMessage());
        return validationError;
    }
}
