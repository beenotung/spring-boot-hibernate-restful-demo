package com.example.demo.repository;

import com.example.demo.entity.KeyValueEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface KeyValueRepository extends CrudRepository<KeyValueEntity, Long> {
    Optional<KeyValueEntity> findByKey(String key);
    Optional<KeyValueEntity> findByValue(String value);
}
