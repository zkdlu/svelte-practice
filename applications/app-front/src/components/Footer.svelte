<script>
    import Cart from './Cart.svelte'
    import OrderButton from './OrderButton.svelte'
</script>

<footer>
    <Cart/>
    <OrderButton/>
</footer>

<style>
    :global(footer) {
        margin-top: auto;
    }
</style>
