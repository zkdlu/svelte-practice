<script>
    import { link } from "svelte-spa-router";
    import active from "svelte-spa-router/active";
    import {myLocation} from '../store'
    
    $myLocation = {
        latitude: 100,
        longitude: 100
    };
</script>

<header>
    <a href="/" use:link use:active> Home </a>
    <a href="/shop" use:link use:active> Shop </a>
</header>
<div>
    내 위치 [{$myLocation.latitude}, {$myLocation.longitude}]
</div>

<style>
    :global(header) {
        background-color:burlywood;
    }

    :global(header a.active) {
        font-weight: bold;
        text-decoration: underline;
    }
</style>
