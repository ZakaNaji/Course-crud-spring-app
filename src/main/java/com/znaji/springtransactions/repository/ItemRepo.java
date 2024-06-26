package com.znaji.springtransactions.repository;

import com.znaji.springtransactions.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long>{
}
