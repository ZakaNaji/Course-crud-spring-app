package com.znaji.springtransactions.service;

import com.znaji.springtransactions.model.Address;
import com.znaji.springtransactions.repository.AddressRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepo addressRepo;

    public void saveAddress(Address address) {
        addressRepo.save(address);
    }
}
