package com.zkdlu.shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ShopServiceImplTest {

    private ShopService shopService;
    private SpyShopRepository spyShopRepository;

    @BeforeEach
    void setUp() {
        spyShopRepository = new SpyShopRepository();
        shopService = new ShopServiceImpl(spyShopRepository);
    }

    @Test
    void getShops_returnsShops() {
        spyShopRepository.findAll_returnValue = List.of(getDefaultShop());

        var shops = shopService.getShops();

        assertThat(shops).hasSize(1);
        assertThat(shops.get(0).getId()).isEqualTo(1L);
        assertThat(shops.get(0).getName()).isEqualTo("shop-1");
        assertThat(shops.get(0).getMinPrice()).isEqualTo(10000);
        assertThat(shops.get(0).getDeliveryPrice()).isEqualTo(1000);
        assertThat(shops.get(0).getLocation().getLongitude()).isEqualTo(100L);
        assertThat(shops.get(0).getLocation().getLatitude()).isEqualTo(100L);
        assertThat(shops.get(0).isOpen()).isEqualTo(true);
        assertThat(shops.get(0).getIcon()).isEqualTo("icon");
    }

    private Shop getDefaultShop() {
        return new Shop(1L,
                "shop-1",
                ShopCategory.CHICKEN,
                10000,
                1000,
                new ShopLocation(100L, 100L),
                true,
                "icon");
    }
}