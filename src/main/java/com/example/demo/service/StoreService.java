package com.example.demo.service;

import com.example.demo.entity.KeyValueEntity;
import com.example.demo.repository.KeyValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StoreService {

    @Autowired
    KeyValueRepository keyValueRepository;

    public String getValue(String key) {
        Optional<KeyValueEntity> result = keyValueRepository.findByKey(key);
        if (result.isPresent()) {
            return result.get().getValue();
        } else {
            return "(none)";
        }
    }

    public String setValue(String key, String value) {
        Optional<KeyValueEntity> result = keyValueRepository.findByKey(key);
        if (result.isPresent()) {
            KeyValueEntity entity = result.get();
            entity.setValue(value);
            keyValueRepository.save(entity);
            return "updated existing record";
        } else {
            keyValueRepository.save(new KeyValueEntity(key, value));
            return "inserted new record";
        }
    }

    public boolean hasKey(String key) {
        return keyValueRepository.findByKey(key).isPresent();
    }

    public String getKey(String value) {
        Optional<KeyValueEntity> result = keyValueRepository.findByValue(value);
        if (result.isPresent()) {
            return result.get().getKey();
        } else {
            return "(none)";
        }
    }
}
