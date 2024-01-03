package com.evolut.api.domain.user.services;

import com.evolut.api.domain.user.dtos.CreateUserInput;
import com.evolut.api.domain.user.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class CreateUserServiceIntegrationTest implements CreateUserServiceTest {
    @Autowired
    private CreateUserService createUserService;

    @Test
    @Override
    public void givenCorrectInputWhenExecuteThenReturnUserCreated() {
        CreateUserInput createUserInput = new CreateUserInput(
                "User 1",
                "user1@email.com",
                "User1@123"
        );

        User user = this.createUserService.execute(createUserInput);

        assertThat(user).isNotNull();
    }
}
