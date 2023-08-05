package com.example.demo.entity;

import jakarta.persistence.*;

@Entity(name = "key_value")
public class KeyValueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String key;

    @Column
    private String value;

    protected KeyValueEntity() {}

    public KeyValueEntity(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
