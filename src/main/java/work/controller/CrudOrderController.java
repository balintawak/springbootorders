package work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import work.model.Orders;
import work.service.OrderService;

import java.util.List;
import java.util.Optional;

@RestController
public class CrudOrderController
{
    @Autowired
    private OrderService orderService;

    @GetMapping (path = "/orders")
    @ResponseBody
    public List<Orders> findAllOrders ()
    {
        return orderService.findAll();
    }

    @RequestMapping (method=RequestMethod.GET, path="/orders/{order_id}")
    @ResponseBody
    public Optional<Orders> findByOrderId (
            @PathVariable("order_id") String order_id)
    {
        return orderService.findById(order_id);
    }

    @RequestMapping (method=RequestMethod.POST, path="/orders")
    @ResponseBody
    public Orders saveOrder (@RequestBody Orders order)
    {
        return orderService.saveOrder(order);
    }

    @RequestMapping (method=RequestMethod.PUT, path="/orders/{order_id}")
    @ResponseBody
    public void updateOrder (@PathVariable("order_id") String order_id,
                             @RequestBody Orders order)
    {
        orderService.updateOrder(order_id, order);
    }

    @RequestMapping (method=RequestMethod.DELETE, path="/orders/{order_id}")
    @ResponseBody
    public void deleteOrderById (@PathVariable("order_id") String order_id)
    {
        orderService.deleteOrderById(order_id);
    }
}
