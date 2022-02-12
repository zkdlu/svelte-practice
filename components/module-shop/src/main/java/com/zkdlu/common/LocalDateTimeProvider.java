package com.zkdlu.common;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LocalDateTimeProvider {
    public LocalDateTime now_returnValue;

    public LocalDateTime now() {
        return now_returnValue;
    }
}
