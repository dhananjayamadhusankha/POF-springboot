package com.springbootacademy.pointofsale.repository;

import com.springbootacademy.pointofsale.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItemRepository extends JpaRepository<Item, Integer> {

    List<Item> findAllByItemNameEqualsAndActiveStatusEquals(String itemName, boolean status);

    List<Item> findAllByActiveStatusEquals(boolean activeStatus);

    long countAllByActiveStatusEquals(boolean activeStatus);

    Page<Item> findAllByActiveStatusEquals(boolean activeStatus, Pageable pageable);
}
