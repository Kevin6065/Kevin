<script setup>
import { ref, reactive } from 'vue'
const count = ref(0)
const box = reactive({ color: 'blue' })
</script>

<template>
  <div :class="'divbox'" :style="{ backgroundColor: box.color }">
    <p>按下按鈕次數：{{ count }}</p>
    <button @click="changeColor">變更顏色</button>
  </div>
</template>

<style scoped>
.divbox {
  margin: 20px;
  padding: 20px;
  color: #fff;
}
</style>
