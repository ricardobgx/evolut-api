package com.evolut.api.controllers;

import com.evolut.api.domain.user.assemblers.UserDetailsAssembler;
import com.evolut.api.domain.user.dtos.CreateUserInput;
import com.evolut.api.domain.user.dtos.UserDetails;
import com.evolut.api.domain.user.models.User;
import com.evolut.api.domain.user.services.CreateUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("authentication")
public class AuthenticationController {
    @Autowired
    private CreateUserService createUserService;

    @Autowired
    private UserDetailsAssembler userDetailsAssembler;

    @PostMapping("sign-up")
    @Transactional
    public ResponseEntity<EntityModel<UserDetails>> signUp(
            @RequestBody @Valid CreateUserInput createUserInput,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        User user = this.createUserService.execute(createUserInput);

        URI uri = uriComponentsBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();

        EntityModel<UserDetails> userDetails = this.userDetailsAssembler.toModel(user);

        return ResponseEntity.created(uri).body(userDetails);
    }
}
