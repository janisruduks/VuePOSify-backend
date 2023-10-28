package com.example.posapp.controller;

import com.example.posapp.entity.Table;
import com.example.posapp.service.TableService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tables")
public class TableController {

    private final TableService service;

    public TableController(TableService service) {
        this.service = service;
    }

    @PostMapping("/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Table createTable(@RequestBody String name, @PathVariable Long userId) {
        return service.saveTable(name, userId);
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Table> getAllTables(@PathVariable Long userId) {
        return service.getAllUserTables(userId);
    }

    @PatchMapping("/status-update/{tableId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTableStatus(@PathVariable Long tableId) {
        service.updateTableStatus(tableId);
    }

    @DeleteMapping("/{tableId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTable(@PathVariable Long tableId) {
        service.deleteTableById(tableId);
    }

}