<script>
    import { cart } from "../store";

    function deleteCartItem(cartItem) {
        cart.update(contents => contents.filter(content => content != cartItem));
    }

    $: totalPrice = $cart.reduce((sum, item) => {
        return sum + item.food.price;
    }, 0);
    
</script>

<div>
    {#if $cart.length > 0}
        <ul>
        {#each $cart as cartItem}
            <li>{cartItem.food.name}<button on:click="{deleteCartItem(cartItem)}">삭제</button></li>
        {/each}
        </ul>
        결제 예정 금액: {totalPrice} 원
    {/if}
</div>

<style>
</style>
