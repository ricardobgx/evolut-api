package com.evolut.api.domain.user.services;

import com.evolut.api.domain.user.dtos.CreateUserInput;
import com.evolut.api.domain.user.mappers.UserMapper;
import com.evolut.api.domain.user.models.User;
import com.evolut.api.domain.user.repositories.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Autowired
    private UserRepository userRepository;

    public User execute(CreateUserInput createUserInput) {
        User user = this.userMapper.fromCreateUserInput(createUserInput);

        this.userRepository.save(user);

        return user;
    }
}
