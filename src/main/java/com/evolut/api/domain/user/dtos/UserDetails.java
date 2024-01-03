package com.evolut.api.domain.user.dtos;

import com.evolut.api.domain.user.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
public class UserDetails extends RepresentationModel<UserDetails> {
    private UUID id;
    private String name;
    private String email;

    public UserDetails(User user) {
        this(user.getId(), user.getName(), user.getEmail());
    }
}
