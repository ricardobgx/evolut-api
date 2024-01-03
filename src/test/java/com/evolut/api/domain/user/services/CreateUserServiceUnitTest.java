package com.evolut.api.domain.user.services;

import com.evolut.api.domain.user.dtos.CreateUserInput;
import com.evolut.api.domain.user.models.User;
import com.evolut.api.domain.user.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
public class CreateUserServiceUnitTest implements CreateUserServiceTest {
    @Autowired
    private CreateUserService createUserService;

    @MockBean
    private UserRepository userRepository;

    @Test
    @Override
    public void givenCorrectInputWhenExecuteThenReturnUserCreated() {
        CreateUserInput createUserInput = new CreateUserInput(
                "User 1",
                "user1@email.com",
                "User1@123"
        );

        when(this.userRepository.save(any())).thenReturn(Mockito.mock(User.class));

        User user = this.createUserService.execute(createUserInput);

        assertThat(user).isNotNull();
    }
}
