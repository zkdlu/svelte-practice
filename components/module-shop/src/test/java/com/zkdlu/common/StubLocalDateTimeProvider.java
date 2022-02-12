package com.zkdlu.common;

import java.time.LocalDateTime;

public class StubLocalDateTimeProvider extends LocalDateTimeProvider {
    @Override
    public LocalDateTime now() {
        return super.now();
    }
}
