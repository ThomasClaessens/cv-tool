package be.dominionexperts.cvtool.controller;

import be.dominionexperts.cvtool.dto.Resume;
import be.dominionexperts.cvtool.exception.EmptyFileException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
public class UploadController {

    @Valid
    @RequestMapping(value = "api/upload", method = RequestMethod.POST)
    public Resume parseResumeFromJsonFile(@RequestParam("json-file") MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            throw new EmptyFileException();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Resume resume = objectMapper.readValue(file.getBytes(), Resume.class);

       /* ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        validator.validate(resume, Resume.class);
*/

        return resume;
    }

}
