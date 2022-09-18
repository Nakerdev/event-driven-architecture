package com.webapplication.pages.home;

import java.util.Optional;

public interface UserRepository {
    Optional<UserDto> SearchByUserId(int id);
}