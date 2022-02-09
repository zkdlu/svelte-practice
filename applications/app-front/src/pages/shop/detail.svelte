<script>
  import { onMount } from "svelte";
  export let params = {}

  const title = "가게";

  let foods = [];

  function fetchFoods(shopId) {
    let fetchedFoods = [];

    for (let i = 1; i <= 5; i++) {
      fetchedFoods.push({
        id: i,
        name: '음식-' + i,
        price: 10000 + 1000 * i,
        category: '식사류',
        icon: '🍣',
        saled: true,
      });
    }

    for (let i = 6; i <= 10; i++) {
      fetchedFoods.push({
        id: i,
        name: '간식-' + i,
        price: 1000 * i,
        category: '간식',
        icon: '🍿',
        saled: true,
      });
    }
    
    foods = [...fetchedFoods];
  }
  
  function categorizing(fetchedFoods) {
    let categorizingFoods = {};
    
    fetchedFoods.map(food => {
      if (categorizingFoods[food.category] == null) {
        categorizingFoods[food.category] = [food];
      } else {
        categorizingFoods[food.category].push(food);
      }
    });

    return {...categorizingFoods};
  }

  onMount(async () => {
    await fetchFoods(params.id);
  });
</script>

<h1>{title} {params.id}</h1>

<br /><br />

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
    {#each foods as food(food.id)}
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

<br /><br />


<a href="#/shop">
  목록으로 ▶️
</a>


<style>
</style>