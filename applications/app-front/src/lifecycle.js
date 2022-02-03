import { beforeUpdate, afterUpdate, onMount, onDestroy } from 'svelte'

export function lifecycle() {
    onMount(() => {
        console.log('Mounted!')
    })
    onDestroy(() => {
        console.log('Before destroy!')
    })
    beforeUpdate(() => {
        console.log('Before update!')
    })
    afterUpdate(() => {
        console.log('After update!')
    })
}