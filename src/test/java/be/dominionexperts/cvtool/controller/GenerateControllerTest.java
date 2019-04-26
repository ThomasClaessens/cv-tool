package be.dominionexperts.cvtool.controller;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.File;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@RunWith(SpringRunner.class)
public class GenerateControllerTest {

    private MockMvc mockMvc;

    private final static String GENERATE_RESUME_ENDPOINT = "/api/generate/resume";

    @Autowired
    private GenerateController generateController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(generateController).build();
    }

    @Test
    public void generatePdfSuccess() throws Exception {
        String validResume = FileUtils.readFileToString(new File(this.getClass().getResource("/validResume.json").getFile()));

        mockMvc.perform(post(GENERATE_RESUME_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(validResume))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_PDF));
    }

    @Test
    public void generatePdfFailNoJson() throws Exception {
        mockMvc.perform(post(GENERATE_RESUME_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isBadRequest());
    }


    @Test
    public void generatePdfInvalidJson() throws Exception {
        String invalidResume = FileUtils.readFileToString(new File(this.getClass().getResource("/invalidResume.json").getFile()));

        mockMvc.perform(post(GENERATE_RESUME_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(invalidResume))
                .andExpect(status().isBadRequest());
    }
}