<script>
import { each } from "svelte/internal";


    export let numbers;
    export let reverse;
    export let slice;

    let computedNumbers = [];

    if (reverse) {
        computedNumbers = [...numbers].reverse();
    } else if (slice) {
        computedNumbers = [...numbers].slice(...slice.split(','))
    } else {
        computedNumbers = [...numbers];
    }

</script>


<h4>Component</h4>
{#each computedNumbers as number}
    {number}
{/each}