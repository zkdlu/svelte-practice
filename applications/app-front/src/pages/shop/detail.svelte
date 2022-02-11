<script>
  import { onMount } from "svelte";
  import { isEmpty } from "../../utils/arrayUtils";
  import { cart } from "../../store";
  import api from "../../utils/api"
  import Cart from '../../components/Cart.svelte'

  export let params = {};

  const title = "가게";

  let foods = [];

  async function fetchFoods(shopId) {
    let fetchedFoods = [];

    const json = await api.get(`shops/${shopId}/foods`);
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

  function putInBucket(food) {
    const cartItem = {
      shopId: params.id,
      foodId: food.id,
      foodName: food.name,
      foodPrice: food.price,
      foodImage: food.icon,
    }
    
    cart.update(contents => [...contents, cartItem]);
  }

  onMount(async () => {
    await fetchFoods(params.id);
  });
</script>

<h1>{title} {params.id}</h1>

<br /><br />

{#if !isEmpty(foods)}
  {#each Object.entries(categorizing(foods)) as [category, foods]}
    <table>
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
      <tbody>
        {#each foods as food (food.id)}
          <tr>
            <td>{food.icon}</td>
            <td>{food.name}</td>
            <td>{food.category}</td>
            <td>{food.price}원</td>
            <td>
              {#if food.saled}
                <button on:click="{putInBucket(food)}">담기</button>
              {:else}
                ❌
              {/if}
            </td>
          </tr>
        {/each}
      </tbody>
    </table>
  {/each}
{:else}
  <h1>텅</h1>
{/if}

<br /><br />

<a href="#/shop"> ◀️ 목록으로 </a>
<Cart/>

<style>
</style>
