<script>
    import { link } from "svelte-spa-router";
    import { bucket } from "../store";
</script>

<div>
    {#each $bucket as bucketItem}
        <span>{bucketItem.food.name}</span>
    {/each}
</div>

<style>
</style>
