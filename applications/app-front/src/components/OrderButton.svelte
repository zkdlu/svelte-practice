<script>
    export let buttonName = '주문하기';
    export let onClickCallback = goToOrderPage;

    function goToOrderPage() {
        window.location.href = '#/order'
    }
</script>

<div>
    <button on:click="{onClickCallback}">{buttonName}</button>
</div>

<style>
    button {
        background-color: burlywood;
        display: block;
        width: 100%;
    }
</style>
