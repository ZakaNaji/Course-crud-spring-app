package com.znaji.springtransactions.service;

import com.znaji.springtransactions.model.Item;
import com.znaji.springtransactions.repository.ItemRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepo itemRepo;

    public Item saveItem(Item item) {
        return itemRepo.save(item);
    }
}
