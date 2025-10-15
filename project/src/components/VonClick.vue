<script setup>
import { ref } from 'vue'

const counter = ref(0)
const counterMethod = (event) => {
  console.log('🚀 ~ counterMethod ~ event:', event.target.tagName)
  counter.value++
}
</script>

<template>
  <button @click="counterMethod">Add 1</button>
  <p>The button above has been clicked {{ counter }} times.</p>
</template>

<style scoped></style>
