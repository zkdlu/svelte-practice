package com.zkdlu.common;

import java.time.LocalDateTime;

public class StubLocalDateTimeProvider extends LocalDateTimeProvider {
    public LocalDateTime now_returnValue;

    @Override
    public LocalDateTime now() {
        return now_returnValue;
    }
}
