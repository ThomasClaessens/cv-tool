package be.dominionexperts.cvtool.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.InputStream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UploadControllerIT {
    @Autowired
    private UploadController uploadController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(uploadController)
                                 .build();
    }

    @Test
    public void whenNoFileGiven_ShouldHaveStatusBadRequest() throws Exception {
        mockMvc.perform(multipart("/api/upload"))
               .andExpect(status().isBadRequest());
    }

    @Test
    public void whenFileGiven_ShouldHaveStatusOk() throws Exception {
        InputStream inputStream = this.getClass().getResourceAsStream("/resumes/resume.json");
        MockMultipartFile mockMultipartFile = new MockMultipartFile("json-file", inputStream);
        mockMvc.perform(multipart("/api/upload").file(mockMultipartFile))
               .andExpect(status().isOk());
    }
}
