<script>
  import { onMount } from "svelte";
  export let params = {};

  const title = "가게";

  let foods = [];

  async function fetchFoods(shopId) {
    let fetchedFoods = [];

    const result = await fetch(`http://localhost:8080/shops/${shopId}/foods`);
    const json = await result.json();

    console.log(json);

    fetchedFoods.push(...json);

    foods = [...fetchedFoods];
  }

  function categorizing(fetchedFoods) {
    let categorizingFoods = {};

    fetchedFoods.map((food) => {
      if (categorizingFoods[food.category] == null) {
        categorizingFoods[food.category] = [food];
      } else {
        categorizingFoods[food.category].push(food);
      }
    });

    return { ...categorizingFoods };
  }

  function isEmpty(arr) {
    return Array.isArray(arr) && arr.length === 0;
  }

  onMount(async () => {
    await fetchFoods(params.id);
  });
</script>

<h1>{title} {params.id}</h1>

<br /><br />

{#if !isEmpty(foods)}
  <table>
    {#each Object.entries(categorizing(foods)) as [category, foods]}
      {category}
      <thead>
        <tr>
          <th />
          <th>음식이름</th>
          <th>카테고리</th>
          <th>가격</th>
          <th />
        </tr>
      </thead>
      {#each foods as food (food.id)}
        <tbody>
          <tr>
            <td>{food.icon}</td>
            <td>{food.name}</td>
            <td>{food.category}</td>
            <td>{food.price}원</td>
            <td>
              {#if food.saled}
                <button>담기</button>
              {:else}
                ❌
              {/if}
            </td>
          </tr>
        </tbody>
      {/each}
    {/each}
  </table>
{:else}
  <h1>텅</h1>
{/if}

<br /><br />

<a href="#/shop"> 목록으로 ▶️ </a>

<style>
</style>
