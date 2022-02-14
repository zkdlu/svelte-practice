import Home from './pages/home/main.svelte'
import Shop from './pages/shop/main.svelte'
import ShopDetail from './pages/shop/detail.svelte'
import Cart from './pages/cart/main.svelte'
import Order from './pages/order/main.svelte'
import OrderPayment from './pages/order/payment.svelte'
import OrderComplete from './pages/order/complete.svelte'

const routes = {
  '/': Home,
  '/shop': Shop,
  '/shop/:id': ShopDetail,
  '/cart': Cart,
  '/order': Order,
  '/order/:id': OrderPayment,
  '/complete/:id': OrderComplete,
}

export default routes