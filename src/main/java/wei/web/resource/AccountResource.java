package wei.web.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import wei.config.AppConfig;
import wei.web.domain.Account;

@RestController
public class AccountResource {

    @Autowired
    private AppConfig appConfig;

    @Value("${wait:0}")
    private int waitInSeconds;

    @GetMapping("/accounts/{id}")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Account getAccount(@PathVariable String id) {
        if (waitInSeconds > 0) {
            try {
                Thread.currentThread().sleep(waitInSeconds * 1000);
            } catch (InterruptedException ex) {}
        }
        Account account = new Account();
        account.setId(appConfig.getId());
        return account;
    }

    @GetMapping("/stocks/{id}")
    public int getStock(@PathVariable int id) {
        return 2;
    }
}
