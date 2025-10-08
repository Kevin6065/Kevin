<script setup>
import { ref } from 'vue'

let idCounter = 4

const products = ref([
  { id: 1, name: '滑鼠', price: 300 },
  { id: 2, name: '鍵盤', price: 800 },
  { id: 3, name: '螢幕', price: 1500 },
])

const addItem = () => {
  products.value.push({ id: products.value.length + 1, name: '新商品', price: 999 })
}

const removeLast = () => {
  products.value.pop()
}

const addFirst = () => {
  products.value.unshift({ id: products.value[0].id - 1, name: '新商品', price: 999 })
}

const removeFirst = () => {
  products.value.shift()
}

const sortClicked = ref(false)
const sortByPrice = () => {
  if (sortClicked.value) {
    products.value.sort((a, b) => a.price - b.price)
    sortClicked.value = false
  } else {
    products.value.sort((a, b) => b.price - a.price)
    sortClicked.value = true
  }
}

const reverseList = () => {
  products.value.reverse()
}

const insertMiddle = () => {
  const mid = Math.floor(products.value.length / 2)
  products.value.splice(mid, 0, { id: idCounter++, name: '中間商品', price: 456 })
}
</script>

<template>
  <div class="container">
    <h2>🛒 商品列表操作器</h2>

    <!-- 操作按鈕 -->
    <div class="actions">
      <button @click="addItem">push（加尾端）</button>
      <button @click="removeLast">pop（移除尾端）</button>
      <button @click="addFirst">unshift（加開頭）</button>
      <button @click="removeFirst">shift（移除開頭）</button>
      <button @click="sortByPrice">sort（價格排序）</button>
      <button @click="reverseList">reverse（反轉順序）</button>
      <button @click="insertMiddle">splice（中間插入）</button>
    </div>

    <!-- 列表渲染 -->
    <ul>
      <li v-for="(item, index) in products" :key="item.id">
        {{ index + 1 }}. {{ item.name }} - ${{ item.price }}
      </li>
    </ul>
  </div>
</template>

<style scoped>
.container {
  max-width: 600px;
  margin: auto;
}
.actions {
  display: flex;
  flex-wrap: wrap;
  gap: 10px;
  margin-bottom: 16px;
}
button {
  padding: 6px 10px;
}
ul {
  list-style: none;
  padding: 0;
}
li {
  padding: 6px 0;
  border-bottom: 1px solid #ddd;
}
</style>
