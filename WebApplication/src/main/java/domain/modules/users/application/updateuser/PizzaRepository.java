package domain.modules.users.application.updateuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PizzaRepository implements IPizzaRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PizzaRepository(final JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    public Pizza CreatePizza(final Pizza pizza) {
        final var sql = "INSERT INTO pizza2 (name, img, priceInEuros) VALUES (?, ?, ?)";
        try {
            this.jdbcTemplate.update(sql, pizza.getName(), pizza.getImg(), pizza.getPrice());
        } catch (final DataAccessException ex) {
            return null;
        }
        return pizza;
    }
}
