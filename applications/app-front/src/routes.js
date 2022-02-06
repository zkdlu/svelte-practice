import Home from './pages/home/main.svelte'
import About from './pages/about/main.svelte'
import Shop from './pages/shop/main.svelte'
import ShopDetail from './pages/shop/detail.svelte'
import Test from './routes/Test.svelte'

const routes = {
  '/': Home,
  '/about': About,
  '/shop': Shop,
  '/shop/:id': ShopDetail,
  '/test': Test,
}

export default routes