package com.evolut.api.domain.user.mappers;

import com.evolut.api.domain.user.dtos.CreateUserInput;
import com.evolut.api.domain.user.models.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User fromCreateUserInput(CreateUserInput createUserInput);
}
