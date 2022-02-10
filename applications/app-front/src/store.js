import { writable } from "svelte/store";

export let storeName = writable('init');
export let myLocation = writable({
    longitude: 0,
    latitude: 0
});

export let bucket = writable([]);