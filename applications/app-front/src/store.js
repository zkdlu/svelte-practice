import { writable } from "svelte/store";

export let myLocation = writable({
    longitude: 0,
    latitude: 0
});

export let shops = writable([]);
export let cart = writable([]);
