package com.webapplication.pages.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

//@Repository
public class UserPostgrestRepository implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserPostgrestRepository(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<UserDto> SearchByUserId(int id) {
        final var sql = "SELECT * FROM Users WHERE id = ?";
        try {
            return jdbcTemplate
                .queryForList(sql, id)
                .stream()
                .map((row) -> buildUserDto(row))
                .toList()
                .stream()
                .findFirst();
        } catch (final DataAccessException ex) {
            return Optional.empty();
        }
    }

    private UserDto buildUserDto(Map<String, Object> userDbRow) {
        return new UserDto(
            (String) userDbRow.get("firstName"),
            (String) userDbRow.get("middleName"),
            (String) userDbRow.get("lastName"),
            ((Integer) userDbRow.get("age"))
        );
    }
}
