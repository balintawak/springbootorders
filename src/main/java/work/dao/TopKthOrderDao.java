package work.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import work.model.OrdersNameAndQuantity;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class TopKthOrderDao
{

    JdbcTemplate jdbcTemplate;

    @Autowired
    public TopKthOrderDao (DataSource dataSource)
    {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getJdbcTemplate ()
    {
        return jdbcTemplate;
    }

    public List<OrdersNameAndQuantity> getTopKthOrders (Integer k,
                                                        LocalDateTime begin,
                                                        LocalDateTime end)
    {
        return jdbcTemplate.query(
                "SELECT name, sum(quantity) as " +
                "quantity\n" +
                "FROM orders.orders\n" +
                "WHERE updated_at \n" +
                "BETWEEN ? \n" +
                "AND ? \n" +
                "GROUP BY name\n" +
                "ORDER BY quantity\n" +
                "DESC \n" +
                "LIMIT ?;", new Object[] { begin, end, k },
                new BeanPropertyRowMapper<>(OrdersNameAndQuantity.class));
    }
}