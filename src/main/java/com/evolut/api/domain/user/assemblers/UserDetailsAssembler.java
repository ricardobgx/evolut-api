package com.evolut.api.domain.user.assemblers;

import com.evolut.api.domain.user.models.User;
import com.evolut.api.domain.user.dtos.UserDetails;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsAssembler implements RepresentationModelAssembler<User, EntityModel<UserDetails>> {
    @Override
    public EntityModel<UserDetails> toModel(User user) {
        UserDetails userDetails = new UserDetails(user);

        return EntityModel.of(userDetails);
    }
}
