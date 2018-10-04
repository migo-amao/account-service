package wei.web.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wei.config.AppConfig;
import wei.web.client.AccountService;
import wei.web.domain.Account;
import wei.web.domain.Order;

@RestController
public class OrderResource {

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private AccountService accountService;

    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable String id) {
        Order order = new Order();
        order.setId(appConfig.getId());
        return order;
    }

    @PostMapping("/orders")
    public void createOrder(@RequestBody Order order) {
        Account account = accountService.findAccount("1");
        System.out.println("Account for order = " + account);
    }
}
