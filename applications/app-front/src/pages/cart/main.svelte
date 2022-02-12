<script>
  import { onMount } from "svelte";
  import OrderButton from "../../components/OrderButton.svelte";
  import { cart } from "../../store";
  import { shops } from "../../store";
  const title = "장바구니";

  const totalPrice = $cart.reduce((sum, item) => {
    return sum + item.foodPrice;
  }, 0);

  function deleteCartItem(cartItem) {
    cart.update((contents) =>
      contents.filter((content) => content != cartItem)
    );
  }

  function getShopsFromCart(cartItems) {
    let shops = {};
    cartItems.map((cartItem) => {
      const shopId = cartItem.shopId;
      if (shops[shopId] == null) {
        shops[shopId] = [cartItem];
      } else {
        shops[shopId].push(cartItem);
      }
    });
    return shops;
  }

  function getShopName(shopId) {
    return $shops.find((shop) => shop.id == shopId).name;
  }
</script>

<h1>{title}</h1>

<div class="cart">
  {#each Object.entries(getShopsFromCart($cart)) as [shopId, cartItems]}
    {getShopName(shopId)}
    <ul>
      {#each cartItems as cartItem}
        <li>
          {cartItem.foodName}<button on:click={deleteCartItem(cartItem)}>삭제</button>
        </li>
      {/each}
    </ul>
  {/each}
</div>
{#if totalPrice > 0}
<h2>결제 금액: {totalPrice} 원</h2>  
{/if}
<OrderButton />

<style>
  .cart {
    width: 100%;
    height: 100%;
    overflow: auto;
  }
</style>
