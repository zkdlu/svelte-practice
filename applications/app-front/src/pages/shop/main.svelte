<script>
  import { onMount } from "svelte";
  import { myLocation } from "../../store";
  import { isEmpty } from "../../utils/arrayUtils";
  import api from "../../utils/api"
  import Cart from '../../components/Cart.svelte'

  const title = "가게 목록";

  let position = $myLocation;

  let shops = [];

  async function fetchShopList() {
    let fetchedShops = [];

    const json = await api.get("shops");
    fetchedShops.push(...json);

    shops = [...fetchedShops];
  }

  onMount(async () => {
    await fetchShopList();
  });

  function getDistance(location) {
    return Math.sqrt(
      Math.pow(Math.abs(position.latitude - location.latitude), 2) +
        Math.pow(Math.abs(position.longitude - location.longitude), 2)
    ).toFixed(1);
  }
</script>

<h1>{title}</h1>

<br /><br />

{#if !isEmpty(shops)}
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
            {#if shop.open}
              <a href="#/shop/{shop.id}"> 자세히 </a>
            {:else}
              <span>다음에..</span>
            {/if}
          </td>
        </tr>
      {/each}
    </tbody>
  </table>
{:else}
  <h1>주변에 가게가 없어요</h1>
{/if}

<br /><br />

<a href="#/"> ◀️ 메인으로 </a>

<Cart/>

<style>
</style>
