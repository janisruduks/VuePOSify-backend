package com.example.posapp.controller;

import com.example.posapp.entity.Item;
import com.example.posapp.request.create.CreateItemRequest;
import com.example.posapp.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @PostMapping("{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Item putItem(@RequestBody CreateItemRequest request, @PathVariable Long userId) {
        return service.addItem(request, userId);
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Item> getAllUserItems(@PathVariable Long userId) {
        return service.getAllUserItems(userId);
    }

    @DeleteMapping("/{itemId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteItem(@PathVariable Long itemId) {
        service.deleteItem(itemId);
    }
}
