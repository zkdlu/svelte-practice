package com.zkdlu.shop;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@Getter
class ShopLocation {
    private long longitude;
    private long latitude;

    public ShopLocation(long longitude, long latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
