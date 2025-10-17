<script setup>
import { ref, watchEffect } from 'vue'
const guess = ref(Math.floor(Math.random() * 100))
const count = ref(0)
const message = ref('')

// 限制count輸入數字範圍, 0-100
watchEffect(() => {
  if (count.value < 0) {
    count.value = 0
  } else if (count.value > 100) {
    count.value = 100
  }
})

watchEffect(() => {
  if (count.value < guess.value) {
    message.value = 'too low'
  } else if (count.value > guess.value) {
    message.value = 'too hight'
  } else {
    message.value = 'Correct'
  }
})
</script>

<template>
  <div>
    <input v-model="count" type="number" />
    <p>Count: {{ count }}</p>
    <p>Message: {{ message }}</p>
  </div>
</template>

<style scoped></style>
