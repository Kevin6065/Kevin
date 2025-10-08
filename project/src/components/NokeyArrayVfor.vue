<script setup>
import { reactive } from 'vue'

const animals = reactive(['狗', '貓', '兔子', '鳥'])
</script>
<template>
  <div>
    <h2>動物列表</h2>
    <ul>
      <li v-for="(animal, index) in animals" :key="index">{{ index + 1 }}. {{ animal }}</li>
    </ul>
  </div>
</template>

<style scoped></style>
