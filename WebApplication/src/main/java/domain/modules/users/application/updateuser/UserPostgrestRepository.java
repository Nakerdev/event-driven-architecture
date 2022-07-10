package domain.modules.users.application.updateuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserPostgrestRepository implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserPostgrestRepository(final JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    public User updateUser(final User user) {
        final var sql = "INSERT INTO pizza2 (name, img, priceInEuros) VALUES (?, ?, ?)";
        try {
            this.jdbcTemplate.update(sql, user.getName(), user.getFirstName(), user.getAge());
        } catch (final DataAccessException ex) {
            return null;
        }
        return user;
    }
}
