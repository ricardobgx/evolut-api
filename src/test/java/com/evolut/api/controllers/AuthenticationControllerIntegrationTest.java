package com.evolut.api.controllers;

import com.evolut.api.domain.user.dtos.CreateUserInput;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@Transactional
public class AuthenticationControllerIntegrationTest implements AuthenticationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JacksonTester<CreateUserInput> createUserInputJacksonTester;

    @Test
    @Override
    public void givenCorrectInputWhenSignUpThenReturnHttpStatus201AndUserCreated() throws Exception {
        CreateUserInput createUserInput = new CreateUserInput("User 1", "user1@email.com", "User1@123");

        this.mockMvc
                .perform(post("/authentication/sign-up")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.createUserInputJacksonTester.write(createUserInput).getJson())
                )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", notNullValue()));
    }
}
