package com.zkdlu.common;

import java.util.UUID;

public class StubUuidProvider extends UuidProvider {
    public UUID randomUUID_returnValue;

    @Override
    public UUID randomUUID() {
        return randomUUID_returnValue;
    }
}
