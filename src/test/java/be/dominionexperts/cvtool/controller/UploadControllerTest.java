package be.dominionexperts.cvtool.controller;

import be.dominionexperts.cvtool.dto.Resume;
import be.dominionexperts.cvtool.exception.InvalidFileException;
import be.dominionexperts.cvtool.exception.ValidationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UploadControllerTest {
    @Autowired
    private UploadController uploadController;

    @Test
    public void whenNoFileGiven_ThrowsEmptyFileException() {
        assertThatThrownBy(() -> uploadController.parseResumeFromJsonFile(null))
                .isInstanceOf(InvalidFileException.class)
                .hasMessage("Expected resume, received nothing");
    }

    @Test
    public void whenEmptyFileGiven_ThrowsEmptyFileException() {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("some-json", "".getBytes());
        assertThatThrownBy(() -> uploadController.parseResumeFromJsonFile(mockMultipartFile))
                .isInstanceOf(InvalidFileException.class)
                .hasMessage("Expected resume, received nothing");
    }

    @Test
    public void whenFileWithInvalidTemplateGiven_ThrowsError() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("/resumes/resume-invalid-template.json");
        MockMultipartFile mockMultipartFile = new MockMultipartFile("some-json", inputStream);

        assertThatThrownBy(() -> uploadController.parseResumeFromJsonFile(mockMultipartFile))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Validations failed!");
    }

    @Test
    public void whenFileWithInvalidBasicsGiven_ThrowsError() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("/resumes/resume-invalid-basics.json");
        MockMultipartFile mockMultipartFile = new MockMultipartFile("some-json", inputStream);

        assertThatThrownBy(() -> uploadController.parseResumeFromJsonFile(mockMultipartFile))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Validations failed!");
    }

    @Test
    public void whenFileGiven_ReturnsResume() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("/resumes/resume.json");
        MockMultipartFile mockMultipartFile = new MockMultipartFile("some-json", inputStream);
        Resume resume = uploadController.parseResumeFromJsonFile(mockMultipartFile);

        assertThat(resume.getBasics()).isNotNull();
        assertThat(resume.getBasics().getName()).isEqualTo("Tiziana Troukens");
    }

}
