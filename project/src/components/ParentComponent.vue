<script setup>
import ChildComponent from './ChildComponent.vue'
import { ref } from 'vue'

const child = ref()

const callChildMethod = () => {
  child.value.sayHello()
  alert(child.value.text)
}
</script>

<template>
  <div>
    <h1>父組件</h1>
    <ChildComponent ref="child" />
    <button @click="callChildMethod">呼叫子組件方法</button>
  </div>
</template>

<style scoped>
/* 添加一些樣式 */
button {
  margin-top: 10px;
}
</style>
