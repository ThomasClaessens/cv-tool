package be.dominionexperts.cvtool.service;

import be.dominionexperts.cvtool.dto.Resume;
import be.dominionexperts.cvtool.exception.ValidationException;
import be.dominionexperts.cvtool.exception.dto.ValidationError;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ValidatorService {
    public Resume validateResume(Resume resume) {
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
