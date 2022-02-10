<script>
  import OrderButton from "../../components/OrderButton.svelte";
  import { cart } from "../../store";
  const title = "장바구니";

  function deleteCartItem(cartItem) {
    cart.update(contents => contents.filter(content => content != cartItem));
  }
</script>

<h1>{title}</h1>

<div class="cart">
  <ul>
    {#each $cart as cartItem}
        <li>{cartItem.food.name}<button on:click="{deleteCartItem(cartItem)}">삭제</button></li>
    {/each}
  </ul>
</div>
<OrderButton/>

<style>
  .cart {
    width: 100%;
    height: 100%;
    overflow: auto
  }
</style>
