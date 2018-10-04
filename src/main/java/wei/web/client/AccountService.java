package wei.web.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import wei.web.domain.Account;

@FeignClient("account-service")
public interface AccountService {

    @GetMapping("/accounts/{id}")
    Account findAccount(@PathVariable("id") String id);
}
