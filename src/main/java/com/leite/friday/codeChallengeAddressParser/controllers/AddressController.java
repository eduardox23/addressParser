package com.leite.friday.codeChallengeAddressParser.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leite.friday.codeChallengeAddressParser.model.Address;
import com.leite.friday.codeChallengeAddressParser.model.ParseAddress;

@RestController
public class AddressController {
    //private final AtomicLong counter = new AtomicLong();
	private final ParseAddress parseAdress = new ParseAddress();

    @RequestMapping("/address")
    public Address address(@RequestParam(value="address") String address) {
        //return new Address(counter.incrementAndGet(),street);
    	return parseAdress.parse(address);
    }
}
