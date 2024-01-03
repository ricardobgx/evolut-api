package com.evolut.api.domain.user.services;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class CreateUserServiceIntegrationTest implements CreateUserServiceTest {
}
