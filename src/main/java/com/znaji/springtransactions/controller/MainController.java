package com.znaji.springtransactions.controller;

import com.znaji.springtransactions.model.Address;
import com.znaji.springtransactions.model.Item;
import com.znaji.springtransactions.service.AddressService;
import com.znaji.springtransactions.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final ItemService itemService;
    private final AddressService addressService;

    @GetMapping("/")
    @Transactional(rollbackFor = Exception.class)
    public String home() throws Exception {
        itemService.saveItem(Item.builder().name("Item 1").build());
        addressService.saveAddress(Address.builder().city("City 1").street("Street 1").state("State 1").zipCode("Zip 1").country("Country 1").build());
        throw new Exception("Exception thrown");
    }
}
