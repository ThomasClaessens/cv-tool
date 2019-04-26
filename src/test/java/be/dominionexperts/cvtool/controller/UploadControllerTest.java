package be.dominionexperts.cvtool.controller;

import be.dominionexperts.cvtool.exception.EmptyFileException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UploadControllerTest {
    @Autowired
    private UploadController uploadController;

    @Test
    public void whenNoFileGiven_ThrowsEmptyFileException() {
        assertThatThrownBy(() -> uploadController.parseResumeFromJsonFile(null))
                .isInstanceOf(EmptyFileException.class)
                .hasMessage("Expected resume, received nothing");
    }

    @Test
    public void whenEmptyFileGiven_ThrowsEmptyFileException() {

    }
}
