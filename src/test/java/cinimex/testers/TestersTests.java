package cinimex.testers;


import cinimex.testers.rest.TestersRestControllerV1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestersTests {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TestersRestControllerV1 controller;

    @Test
    public void test() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void test2() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    @Test
    public void test3() throws Exception {
        this.mockMvc.perform(get("/api/v1/testers/6"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(6))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Roman1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.testers_position").value("Manual testin1"));

    }
}
