package com.zkdlu.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
        assertThat(shops.get(0).getCategory()).isEqualTo(ShopCategory.CHICKEN);
        assertThat(shops.get(0).getMinPrice()).isEqualTo(10000);
        assertThat(shops.get(0).getDeliveryPrice()).isEqualTo(1000);
        assertThat(shops.get(0).getLocation().getLongitude()).isEqualTo(100L);
        assertThat(shops.get(0).getLocation().getLatitude()).isEqualTo(100L);
        assertThat(shops.get(0).isOpen()).isEqualTo(true);
        assertThat(shops.get(0).getIcon()).isEqualTo("icon");
    }

    @Test
    void getFoods_passesShopIdToRepository() {
        spyShopRepository.findById_returnValue = Optional.of(getDefaultShop());

        shopService.getFoods(1L);

        assertThat(spyShopRepository.findById_argumentShopId).isEqualTo(1L);
    }

    @Test
    void getFoods_returnsShop() {
        List<Food> givenFoods = List.of(new Food(1L,
                "찜닭",
                10000,
                "식사류",
                "icon",
                true));
        spyShopRepository.findById_returnValue = Optional.of(new Shop(0L, null,
                null, 0, 0, null, false, null, givenFoods));

        var actual = shopService.getFoods(1L);

        assertThat(actual).hasSize(1);
        assertThat(actual.get(0).getId()).isEqualTo(1L);
        assertThat(actual.get(0).getName()).isEqualTo("찜닭");
        assertThat(actual.get(0).getPrice()).isEqualTo(10000);
        assertThat(actual.get(0).getCategory()).isEqualTo("식사류");
        assertThat(actual.get(0).getIcon()).isEqualTo("icon");
        assertThat(actual.get(0).isSaled()).isEqualTo(true);
    }

    @Test
    void getFoods_throwsNotExistShopException_whenNotExistsShopId() {
        spyShopRepository.findById_returnValue = Optional.empty();

        Assertions.assertThrows(NotExistShopException.class, () -> {
            shopService.getFoods(0L);
        });
    }

    private Shop getDefaultShop() {
        return new Shop(1L,
                "shop-1",
                ShopCategory.CHICKEN,
                10000,
                1000,
                new ShopLocation(100L, 100L),
                true,
                "icon", Collections.emptyList());
    }
}