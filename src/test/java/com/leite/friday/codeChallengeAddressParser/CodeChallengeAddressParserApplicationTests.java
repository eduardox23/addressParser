package com.leite.friday.codeChallengeAddressParser;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static com.leite.friday.codeChallengeAddressParser.testUtils.Addresses.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CodeChallengeAddressParserApplicationTests {

	@Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnJson() throws Exception {
        this.mockMvc.perform(get("/address?address="+SIMPLE_CASE_1)).andDo(print()).andExpect(status().isOk())
                //.andExpect(content().string(containsString("Hello World")));
        .andExpect(content().json("{\"street\":\"Winterallee\",\"housenumber\":\"3\"}"));
        ;
    }

}
