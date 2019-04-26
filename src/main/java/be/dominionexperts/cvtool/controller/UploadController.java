package be.dominionexperts.cvtool.controller;

import be.dominionexperts.cvtool.dto.Resume;
import be.dominionexperts.cvtool.exception.EmptyFileException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

    @RequestMapping(value = "api/upload", method = RequestMethod.POST)
    public Resume parseResumeFromJsonFile(@RequestParam("json-file") MultipartFile file) {
        if (file == null) {
            throw new EmptyFileException();
        }

        //TODO: do stuff with the file
        return Resume.newBuilder().build();
    }

}
