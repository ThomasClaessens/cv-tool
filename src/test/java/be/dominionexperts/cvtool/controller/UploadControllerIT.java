package be.dominionexperts.cvtool.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
    public void whenNoFileGiven_Returns400BadRequest() throws Exception {
        mockMvc.perform(post("/api/upload").contentType("multipart/form-data"))
                                  .andExpect(status().isBadRequest())
                                  .andReturn();
    }
}
