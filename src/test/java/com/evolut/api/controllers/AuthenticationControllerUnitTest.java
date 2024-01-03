package com.evolut.api.controllers;

import com.evolut.api.domain.user.dtos.CreateUserInput;
import com.evolut.api.domain.user.models.User;
import com.evolut.api.domain.user.services.CreateUserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class AuthenticationControllerUnitTest implements AuthenticationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JacksonTester<CreateUserInput> createUserInputJacksonTester;

    @MockBean
    private CreateUserService createUserService;

    @Test
    @Override
    public void givenCorrectInputWhenSignUpThenReturnHttpStatus201AndUserCreated() throws Exception {
        CreateUserInput createUserInput = new CreateUserInput("User 1", "user1@email.com", "User1@123");

        when(this.createUserService.execute(any())).thenReturn(Mockito.mock(User.class));

        this.mockMvc
                .perform(post("/authentication/sign-up")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.createUserInputJacksonTester.write(createUserInput).getJson())
                )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", notNullValue()));
    }
}
