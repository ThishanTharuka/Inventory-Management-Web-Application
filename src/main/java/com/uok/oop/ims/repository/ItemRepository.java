package com.uok.oop.ims.repository;

import com.uok.oop.ims.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {

    @Query("SELECT SUM(i.quantity) FROM Item i")
    Integer sumTotalQuantity();

}
