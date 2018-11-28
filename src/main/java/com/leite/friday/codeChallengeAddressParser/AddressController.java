package com.leite.friday.codeChallengeAddressParser;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/address")
    public Address address(@RequestParam(value="street", defaultValue="World") String street) {
        return new Address(counter.incrementAndGet(),street);
    }
}
