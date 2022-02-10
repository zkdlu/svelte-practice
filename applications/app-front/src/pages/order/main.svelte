<script>
  import { onMount } from "svelte";
  import { cart } from "../../store";

  const title = "주문 페이지";

  let orderItems = [];

  onMount(() => {
    for (const cartItem of $cart) {
      console.log(cartItem);
    }
  });
  
</script>

<h1>{title}</h1>

{#each $cart as cartItem}
  {cartItem.shopId}<br/>
{/each}

<style>
</style>
