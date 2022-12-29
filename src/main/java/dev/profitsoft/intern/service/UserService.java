package dev.profitsoft.intern.service;

import dev.profitsoft.intern.dto.UserInfoDto;
import dev.profitsoft.intern.model.User;

import java.util.Optional;
import java.util.Set;

public interface UserService {

    Optional<User> findByUsername(String username);

    Set<UserInfoDto> findAll();

}
