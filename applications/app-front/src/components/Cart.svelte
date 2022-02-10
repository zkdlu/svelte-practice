<script>
    import { cart } from "../store";

    $: totalPrice = $cart.reduce((sum, item) => {
        return sum + item.food.price;
    }, 0);
    
</script>

<div>
    {#if totalPrice > 0}
        결제 예정 금액: {totalPrice} 원
        <a href='/#/cart'>카트보기</a>
    {/if}
</div>

<style>
</style>
