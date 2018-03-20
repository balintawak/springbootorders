package work.repository;

import org.springframework.data.repository.CrudRepository;
import work.model.Orders;


public interface OrderRepository extends CrudRepository<Orders, String>
{
}
