package work.repository;

import work.model.Orders;

import java.time.LocalDateTime;
import java.util.List;

public interface TopKthOrderRepository
{
    List<Orders> getTopKthOrders (int k, LocalDateTime begin, LocalDateTime
            end);
}
