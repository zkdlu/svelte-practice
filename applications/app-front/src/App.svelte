<script>
import Router from 'svelte-spa-router'
import routes from './routes'
import Header from './components/Header.svelte'
</script>

<div class="container">
    <Header />
    <Router {routes} />
</div>

<style>
    .container {
        background-color:antiquewhite;
        width: 100%;
        height: 100%;
        display: flex;
        flex-direction: column;
    }
</style>
