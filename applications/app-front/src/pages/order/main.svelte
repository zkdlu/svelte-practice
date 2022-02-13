<script>
  import { onMount } from "svelte";
  import { cart } from "../../store";
  import { isEmpty } from "../../utils/arrayUtils";
  import api from "../../utils/api";
  import OrderButton from "../../components/OrderButton.svelte";

  const title = "주문 페이지";

  const totalPrice = $cart.reduce((sum, item) => {
    return sum + item.foodPrice;
  }, 0);

  onMount(() => {
    if (isEmpty($cart)) {
      window.location.href = "/";
    }

    for (const cartItem of $cart) {
      console.log(cartItem);
    }
  });

  async function placeOrder() {
    const cartItems = [...$cart];

    try {
      const response = await api.post("orders", {
        cartItems
      });
      const json = await response.json();

      cart.update(() => []);
      window.location.href = `#/order/${json.orderId}`;
    } catch (err) {
      console.log(err);
    }
  }
</script>

<h1>{title}</h1>

<div class="container">
  <div class="order-items">
    <table>
      <thead>
        <tr>
          <th />
          <th>음식이름</th>
          <th>가격</th>
          <th />
        </tr>
      </thead>
      <tbody>
        {#each $cart as cartItem}
          <tr>
            <td>{cartItem.foodImage}</td>
            <td>{cartItem.foodName}</td>
            <td>{cartItem.foodPrice}원</td>
          </tr>
        {/each}
      </tbody>
    </table>
  </div>
  <h2>결제 금액: {totalPrice} 원</h2>
</div>
<OrderButton buttonName="결제하기" onClickCallback={placeOrder} />

<style scoped>
  h2 {
    float: right;
  }

  .container {
    height: 100%;
  }

  .order-items {
    width: 100%;
    height: 30%;
    overflow: auto;
    border: 1px solid brown;
  }

  table {
    width: 100%;
    border-collapse: separate;
    border-spacing: 0;
  }

  table th {
    border-bottom: 1px solid brown;
  }

  table td {
    text-align: center;
  }
</style>
