package com.zkdlu.common;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface UuidProvider {
    default UUID randomUUID() {
        return UUID.randomUUID();
    }
}
