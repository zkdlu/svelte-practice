<script>
  import { onMount } from "svelte";
  import { tick } from "svelte";

  const title = "가게 목록";
  const sectionIcons = ["🍚", "🍿", "🍜", "🍣", "🥩", "☕", "🍰"];

  let position = {
    longitude: 0, latitude: 0
  };

  let shops = [];
  async function fetchShopList() {
    let fetchedShops = [];
    for (let i = 1; i <= 7; i++) {
      fetchedShops.push({
        id: i,
        name: "shop-" + i,
        category: 'chicken',
        minPrice: 10000,
        deliveryPrice: 3000,
        location: {longitude: 10 * i, latitude: 20 * i},
        open: i % 3 !== 0 ? true : false,
        icon: sectionIcons[i % sectionIcons.length],
      });
    }

    await tick();

    shops = [...fetchedShops];
  }

  onMount(async () => {
    await fetchShopList();
  });

  function getDistance(location) {
    return Math.abs(
      Math.pow(position.latitude - location.latitude, 2) 
      - Math.pow(position.longitude - location.longitude, 2)
    );
  }
</script>

<h1>{title}</h1>

<br /><br />

<table>
  <thead>
    <tr>
      <th />
      <th>가게명</th>
      <th>카테고리</th>
      <th>최소주문금액</th>
      <th>배달료</th>
      <th>위치</th>
      <th>상태</th>
      <th />
    </tr>
  </thead>
  <tbody>
    {#each shops as shop (shop.id)}
      <tr>
        <td>{shop.icon}</td>
        <td>{shop.name}</td>
        <td>{shop.category}</td>
        <td>{shop.minPrice}원</td>
        <td>{shop.deliveryPrice}원</td>
        <td>{getDistance(shop.location)} m</td>
        <td>
          {#if shop.open}
            ✔️
          {:else}
            ❌
          {/if}
        </td>
        <td>
          <a href="#/shop/{shop.id}"> 자세히 </a>
        </td>
      </tr>
    {/each}
  </tbody>
</table>

<br /><br />

<a href="/"> ◀️ 메인으로 </a>

<style>
</style>
