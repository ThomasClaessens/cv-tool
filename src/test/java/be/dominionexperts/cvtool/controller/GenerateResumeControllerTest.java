package be.dominionexperts.cvtool.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@RunWith(SpringRunner.class)
public class GenerateResumeControllerTest {

    private MockMvc mockMvc;

    private final static String GENERATE_RESUME_ENDPOINT = "/api/generate/resume";

    @Autowired
    private GenerateResumeController generateResumeController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(generateResumeController).build();
    }

    @Test
    public void generatePdfSuccess() throws Exception {
        byte[] validResumeByteStream = this.getClass().getResourceAsStream("/validResume.json").readAllBytes();

        mockMvc.perform(post(GENERATE_RESUME_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(validResumeByteStream))
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
        final byte[] invalidByteStream = this.getClass().getResourceAsStream("/invalidResume.json").readAllBytes();

        mockMvc.perform(post(GENERATE_RESUME_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(invalidByteStream))
                .andExpect(status().isBadRequest());
    }
}