<script setup>
import { reactive, ref } from 'vue'

const fruits = reactive(['蘋果', '香蕉', '葡萄'])

const selectedFruit = ref('')

const selectedFruitClick = (fruit) => {
  selectedFruit.value = fruit
}

//判斷選擇的水果相同
const isSelected = (fruit) => selectedFruit.value === fruit
</script>

<template>
  <div>
    <p>請選擇一個水果：</p>
    <button
      v-for="fruit in fruits"
      :key="fruit"
      :class="{ selected: isSelected(fruit) }"
      @click="selectedFruitClick(fruit)"
    >
      {{ fruit }}
    </button>
    <p>你選的是：{{ selectedFruit }}</p>
  </div>
</template>

<style scoped>
button {
  margin: 4px;
  padding: 8px 12px;
  border: 1px solid #ccc;
}
.selected {
  background-color: orange;
  color: white;
  font-weight: bold;
}
</style>
