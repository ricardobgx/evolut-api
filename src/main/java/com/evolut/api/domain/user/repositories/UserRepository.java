package com.evolut.api.domain.user.repositories;

import com.evolut.api.domain.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
