<script setup>
import { defineExpose } from 'vue'

const sayHello = () => {
  alert('Hello from Child Component!')
}

const text = 'text'
// 使用 defineExpose 暴露 sayHello 方法
defineExpose({ sayHello, text })
</script>

<template>
  <div>
    <h2>子組件</h2>
    <p>這是一個子組件!</p>
  </div>
</template>

<style scoped></style>
