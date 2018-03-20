package work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import work.model.OrdersNameAndQuantity;
import work.service.TopKthOrderService;

import java.util.List;

@RestController
public class TopKthOrderController
{
    @Autowired
    private TopKthOrderService topKthOrderService;

    @RequestMapping (method = RequestMethod.GET,
                     params = { "k", "begin", "end" },
                     value = "/orders")
    @ResponseBody
    public List<OrdersNameAndQuantity> getTopKthOrders (
                                        @RequestParam (value = "k") int k,
                                        @RequestParam (value = "begin")
                                            String begin,
                                        @RequestParam (value = "end")
                                            String end)
    {
        return topKthOrderService.getTopKthOrders(k, begin, end);
    }
}
