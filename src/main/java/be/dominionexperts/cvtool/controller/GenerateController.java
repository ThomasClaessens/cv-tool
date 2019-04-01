package be.dominionexperts.cvtool.controller;

import be.dominionexperts.cvtool.dto.Resume;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;

@RestController
public class GenerateController {

    @RequestMapping(value = "api/generate/resume", method = RequestMethod.POST, produces = "application/json")
    public Path generate(@RequestBody Resume resume) {
        System.out.println(resume);
        //TODO:return pdf document probably with data content-type: application/pdf
         return null;
    }

}
