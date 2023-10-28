package com.example.posapp.service;

import com.example.posapp.entity.Item;
import com.example.posapp.repository.ItemRepository;
import com.example.posapp.request.create.CreateItemRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepo;
    private final CategoryService categoryService;

    public ItemService(ItemRepository itemRepo, CategoryService categoryService) {
        this.itemRepo = itemRepo;
        this.categoryService = categoryService;
    }

    public Item getItemById(Long itemId) {
        return itemRepo.findById(itemId)
                .orElseThrow(() -> new RuntimeException("item not found"));
    }

    public Item addItem(CreateItemRequest request, Long userId) {
        return itemRepo.save(Item.builder()
                .price(request.price())
                .title(request.title())
                .imageUrl(request.imageUrl())
                .description(request.description())
                .userId(userId)
                .categoryId(categoryService.getCategoryById(request.categoryId()))
                .build()
        );
    }

    public List<Item> getAllUserItems(Long userId) {
        return itemRepo.getAllByUserId(userId);
    }

    public void deleteItem(Long itemId) {
        itemRepo.deleteById(itemId);
    }
}