package work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.model.Orders;
import work.repository.OrderRepository;
import work.util.LocalDateTimeFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService
{
    @Autowired
    OrderRepository orderRepository;

    public List<Orders> findAll ()
    {
        List<Orders> orders = new ArrayList<>();
        orderRepository.findAll()
                       .forEach(orders::add);

        return orders;
    }

    public Optional<Orders> findById (String order_id)
    {
        return orderRepository.findById(order_id);
    }

    public Orders saveOrder (Orders order)
    {
        return orderRepository.save(order);
    }

    public void deleteOrderById (String order_id)
    {
        orderRepository.deleteById(order_id);
    }

    public void updateOrder (String order_id, Orders order)
    {
        order.setUpdated_at(LocalDateTimeFormatter.getCurrentTime());
        orderRepository.save(order);
    }
}
