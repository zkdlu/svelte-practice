<script>
  import { onMount } from "svelte";
  import api from "../../utils/api";
  export let params = {};

  const title = "결제중";

  onMount(async() => {
    const orderId = params.id;

    try {
      const order = await api.get(`orders/${orderId}`);
      console.log(order);

      const payment = await api.post(`payment/${orderId}`);
      if (payment.status == 200) {
        console.log('결제 요청');
      }
    } catch(err) {
      console.log(err);
      window.location.href = '/';
    }
  });

</script>

<h1>{title} {params.id}</h1>

<style scoped>
</style>
