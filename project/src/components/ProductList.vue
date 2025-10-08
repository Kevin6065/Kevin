<script setup>
import ProductItem from './ProductItem.vue'
import { reactive } from 'vue'

const products = reactive([
  { id: 1, name: '滑鼠', price: 500 },
  { id: 2, name: '鍵盤', price: 800 },
  { id: 3, name: '顯示器', price: 3000 },
])
</script>

<template>
  <div class="product-list">
    <h2>📦 商品清單</h2>
    <ProductItem
      v-for="product in products"
      :key="product.id"
      :name="product.name"
      :price="product.price"
    />
  </div>
</template>

<style scoped>
.product-list {
  max-width: 400px;
  margin: auto;
}
</style>
