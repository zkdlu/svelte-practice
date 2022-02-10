<script>
    import { cart } from "../store";

    function goToOrderPage() {
        window.location.href = '#/order'
    }
</script>

<div>
    <button on:click="{goToOrderPage}">주문하기</button>
</div>

<style>
    button {
        background-color: burlywood;
        display: block;
        width: 100%;
    }
</style>
