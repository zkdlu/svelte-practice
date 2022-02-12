<script>
    import { cart } from "../store";
    import { isEmpty } from "../utils/arrayUtils";

    export let buttonName = "주문하기";
    export let onClickCallback = goToOrderPage;

    function goToOrderPage() {
        if (isEmpty($cart)) {
            alert('장바구니가 비어있습니다.');
            window.location.href = "#/";
            return;
        }

        window.location.href = "#/order";
    }
</script>

<div>
    <button on:click={onClickCallback}>{buttonName}</button>
</div>

<style>
    button {
        background-color: burlywood;
        display: block;
        width: 100%;
    }
</style>
