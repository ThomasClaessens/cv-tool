package be.dominionexperts.cvtool.service;

import be.dominionexperts.cvtool.dto.Resume;
import be.dominionexperts.cvtool.exception.InvalidJsonException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ResumeGenerationService {
    public Resume generateResume(MultipartFile jsonFile) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return objectMapper.readValue(jsonFile.getBytes(), Resume.class);
        } catch (Exception exception) {
            throw new InvalidJsonException();
        }
    }
}
