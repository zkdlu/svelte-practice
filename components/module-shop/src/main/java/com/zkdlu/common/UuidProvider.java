package com.zkdlu.common;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UuidProvider {
    public UUID randomUUID() {
        return UUID.randomUUID();
    }
}
