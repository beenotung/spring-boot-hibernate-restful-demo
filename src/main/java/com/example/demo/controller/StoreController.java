package com.example.demo.controller;

import com.example.demo.dto.store.SetValueDTO;
import com.example.demo.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StoreController {

    @Autowired
    StoreService storeService;

    @GetMapping("/store/{key}/value")
    public String getValue(@PathVariable String key) {
        return storeService.getValue(key);
    }

    @PostMapping("/store")
    public String setValue(@RequestBody SetValueDTO body) {
        return storeService.setValue(body.key, body.value);
    }

    @GetMapping("/store/{key}/exist")
    public boolean hasKey(@PathVariable String key) {
        return storeService.hasKey(key);
    }

    @GetMapping("/store/search")
    public String getKey(@RequestParam("value") String value) {
        return storeService.getKey(value);
    }
}
