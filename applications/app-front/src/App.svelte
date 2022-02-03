<script>
import { each } from "svelte/internal";
import { storeName } from './store'
import Component from "./Component.svelte";

	export let name;
	let text = '';
	let buttonName = '잉'
	let toggle = false;
	let value = 0;
	let numbers = [];

	function enter() {
		buttonName = '잉';
	}

	function leave() {
		buttonName = '엥?';
	}

	function repeat() {
		setInterval(() => {
			value += 1;
		}, 1000);
	}

	repeat();

	for (let i = 0; i < 10; i++) {
		numbers.push(i);
	}

	$storeName = 'test';
</script>

<main>
	<h1>Hello {name}!</h1>
	<button on:click={() => { toggle = !toggle;}}
		on:mouseenter={enter}
		on:mouseleave={leave}>
		{buttonName}
	</button>
	<div>
		<input type="text" bind:value="{text}"/>
		=> {text}
	</div>
	<div style="display: {toggle ? 'none' : 'block'};">
		<div>
			<h2>조건문</h2>
			<p style="display:{value % 2 == 0 ? 'none' : 'block'}">{value}</p>
			{#if value % 2 == 0}
				<p>짝수</p>
			{:else}
				<p>홀수</p>
			{/if}
		</div>
		<div>
			<h2>반복문</h2>
			{#each numbers as number}
				{number}
			{/each}
		</div>
		<div>
			<Component {numbers}/>
			<Component {numbers} reverse/>
			<Component {numbers} slice='-2'/>
			<Component {numbers} slice='0,4'/>
		</div>
		<div>
			<h2>Store</h2>
			{$storeName}
		</div>
	</div>
</main>

<style>
	main {
		text-align: center;
		padding: 1em;
		max-width: 240px;
		margin: 0 auto;
	}

	h1 {
		color: #ff3e00;
		text-transform: uppercase;
		font-size: 4em;
		font-weight: 100;
	}

	@media (min-width: 640px) {
		main {
			max-width: none;
		}
	}
</style>
