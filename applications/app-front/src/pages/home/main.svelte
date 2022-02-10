<script>
    function goToShop() {
        window.location.href = '#/shop'
    }

</script>

<div class="shop" on:click={goToShop}>
    주문하러 가기
</div>

<style>
    .shop {
        border: 1px solid black;
        background-color:cornsilk;
        width: 100px;
        height: 100px;
        text-align: center;
        font-size: large;
        font-weight: bold;
    }
    
    .shop:hover {
        border: 2px solid black;
        background-color:bisque;
    }
</style>