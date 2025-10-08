<script setup>
import { ref } from 'vue'
import ProductItemComp from './ProductItemComp.vue'
// 商品編號
let nextId = 1
// 商品清單
const products = ref([
  {
    id: nextId++,
    name: '滑鼠',
    price: 500,
  },
  {
    id: nextId++,
    name: '鍵盤',
    price: 800,
  },
  {
    id: nextId++,
    name: '顯示器',
    price: 3000,
  },
])
const form = ref({
  id: null,
  name: '',
  price: '',
})
</script>

<template>
  <div class="container">
    <h2>🛒 商品管理系統</h2>

    <!-- 商品輸入表單 -->
    <form @submit.prevent="handleSubmit">
      <input v-model="form.name" placeholder="商品名稱" required />
      <input v-model.number="form.price" type="number" placeholder="價格" required />

      <button type="submit">
        {{ form.id ? '更新商品' : '新增商品' }}
      </button>

      <button v-if="form.id" type="button" @click="resetForm">取消編輯</button>
    </form>

    <hr />

    <!-- 商品清單 -->
    <ProductItemComp
      v-for="product in products"
      :key="product.id"
      :product="product"
      @delete="removeProduct"
      @edit="editProduct"
    />

    <p v-if="products.length === 0">⚠️ 沒有商品</p>
  </div>
</template>

<style scoped>
.container {
  max-width: 500px;
  margin: auto;
}
form {
  display: flex;
  flex-direction: column;
  gap: 8px;
  margin-bottom: 1rem;
}
input {
  padding: 6px;
}
button {
  padding: 6px 12px;
}
</style>
