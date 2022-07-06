package domain.modules.users.application.updateuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements IUserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(final JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    public User CreatePizza(final User user) {
        final var sql = "INSERT INTO pizza2 (name, img, priceInEuros) VALUES (?, ?, ?)";
        try {
            this.jdbcTemplate.update(sql, user.getName(), user.getImg(), user.getPrice());
        } catch (final DataAccessException ex) {
            return null;
        }
        return user;
    }
}
