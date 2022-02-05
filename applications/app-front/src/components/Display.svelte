<script>
    let items = [];

    function fetchItems() {
        for (let i = 0; i < 10; i++) {
            items.push({
                id: i,
                name: 'name-' + i
            });
        }
    }

    fetchItems();
</script>

<ul>
    {#each items as item (item.id)}
        <li>{item.name}</li>
    {/each}
</ul>

<style>
    :global(header a.active) {
        font-weight: bold;
        text-decoration: underline;
    }
</style>
