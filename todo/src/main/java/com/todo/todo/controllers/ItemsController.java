package com.todo.todo.controllers;

import com.todo.todo.domain.repository.*;
import com.todo.todo.domain.model.Item;

import lombok.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javassist.NotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/items")
public class ItemsController {

    private final ItemRepository repository;

    @GetMapping
    public List<Item> getItems() {
        List<Item> todoList = repository.findAll();

        return todoList;
    }

    @GetMapping(path = "{itemId}")
    public Item getItem(@PathVariable UUID itemId) throws NotFoundException {
        Item todoList = repository.findById(itemId)
                .orElseThrow(() -> new NotFoundException("Item not found with id " + itemId));

        return todoList;
    }

    @PostMapping
    public Item create(@RequestBody Item itemRequest) {

        Item item = Item.builder().title(itemRequest.getTitle()).content(itemRequest.getContent()).build();

        return repository.save(item);
    }


    @PutMapping(path="{itemId}")
    public Item update(@PathVariable UUID itemId, @RequestBody Item itemRequest) throws EntityNotFoundException {

        Item item = repository.findById(itemId).orElseThrow(() -> new EntityNotFoundException("Item is not found"));

        item.setTitle(itemRequest.getTitle());
        item.setContent(itemRequest.getContent());

        return repository.save(item);
    }


    @DeleteMapping(path="{itemId}")
    public void delete(@PathVariable UUID itemId) throws EntityNotFoundException {
        repository.findById(itemId).orElseThrow(() -> new EntityNotFoundException("Item is not found"));

        repository.deleteById(itemId);
    }

}