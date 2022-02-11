<script>
    import { cart } from "../store";
    export let buttonName = '주문하기';

    function goToOrderPage() {
        window.location.href = '#/order'
    }
</script>

<div>
    <button on:click="{goToOrderPage}">{buttonName}</button>
</div>

<style>
    button {
        background-color: burlywood;
        display: block;
        width: 100%;
    }
</style>
