package work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.dao.TopKthOrderDao;
import work.model.OrdersNameAndQuantity;
import work.util.LocalDateTimeFormatter;

import java.util.List;

@Service
public class TopKthOrderService
{
    @Autowired
    private TopKthOrderDao topKthOrderDao;

    public List<OrdersNameAndQuantity> getTopKthOrders (int k, String begin,
                                                        String end)
    {
        return topKthOrderDao.getTopKthOrders(k,
                        LocalDateTimeFormatter.convertString(begin),
                        LocalDateTimeFormatter.convertString(end));
    }
}
