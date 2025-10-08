<script setup>
import { ref, computed } from 'vue'

const email = ref('')
const password = ref('')

// 簡單驗證：是否為空
const canSubmit = computed(() => {
  return email.value.trim() !== '' && password.value.trim() !== ''
})
</script>

<template>
  {{ canSubmit }}
  <p>Email: <input v-model="email" /></p>
  <p>Password: <input type="password" v-model="password" /></p>
  <button :disabled="!canSubmit">送出</button>
</template>
