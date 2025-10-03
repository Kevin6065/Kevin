<template>
  <div>
    <p>Count:{{ count }}</p>
    <button @click="increment">+</button>
    <!-- <button @click="count++">+</button> -->
    <button @click="decrement">-</button>
    <!-- <button @click="count > 0 ? count-- : count">-</button> -->
    <button @click="reset">Reset</button>
    <!-- <button @click="count = 0">Reset</button> -->
  </div>
</template>

<script setup>
import { ref } from 'vue'
const count = ref(0)

const increment = () => {
  count.value++
}

const decrement = () => {
  count.value--
}

const reset = () => {
  count.value = 0
}
</script>

<style lang="scss" scoped></style>
