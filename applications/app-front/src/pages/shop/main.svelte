<script>
  import { onMount } from "svelte";
  import { tick } from "svelte";

  const title = "가게 목록";
  const sectionIcons = ["🍚", "🍿", "🍜", "🍣", "🥩", "☕", "🍰"];

  let shops = [];

  async function fetchShopList() {
    let fetchedShops = [];
    for (let i = 1; i <= 7; i++) {
      fetchedShops.push({
        id: i,
        name: "shop-" + i,
        icon: sectionIcons[i % sectionIcons.length],
      });
    }

    await tick();

    shops = [...fetchedShops];
  }

  onMount(async () => {
    await fetchShopList();
  });
</script>

<h1>{title}</h1>

<ul>
  {#each shops as shop (shop.id)}
    <li>
      <a href="#/shop/{shop.id}">
        {shop.id}
        <span>{shop.icon}</span>
        {shop.name}
      </a>
    </li>
  {/each}
</ul>

<style>
</style>
