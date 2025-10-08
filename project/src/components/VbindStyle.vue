<script setup>
import { reactive } from 'vue'

const products = reactive([
  { id: 1, name: '耳機', price: 500 },
  { id: 2, name: '滑鼠', price: 1000 },
  { id: 3, name: '筆電', price: 30000 },
])

const getPriceStyle = (price) => {
  return {
    color: price > 2000 ? 'red' : 'green',
    fontWeight: 'bold',
  }
}
</script>

<template>
  <div v-for="product in products" :key="product.id" :style="getPriceStyle(product.price)">
    {{ product.name }} - ${{ product.price }}
  </div>
</template>

<style scoped></style>
