import Home from './routes/Home.svelte'
import About from './routes/About.svelte'
import Main from './routes/Main.svelte'
import Test from './routes/Test.svelte'

const routes = {
  '/': Home,
  '/about': About,
  '/main': Main,
  '/test': Test,
}

export default routes