<script setup>
import { ref } from 'vue'

const message = ref('')

const onInput = (e) => {
  message.value = e.target.value
}
const message2 = ref('')
const method2 = (e, msg2) => {
  console.log('🚀 ~ method2 ~ e.target:', e)
  e.target.disabled = true
  alert(msg2)
}
</script>

<template>
  <div>
    <input @input="onInput" placeholder="輸入文字" />
    <p>你輸入了：{{ message }}</p>
    <hr />
    <label>使用 event 又要傳入值</label>
    <input v-model="message2" placeholder="輸入文字2" />
    <button
      @click="
        (e) => {
          method2(e, message2)
        }
      "
    >
      送出
    </button>
  </div>
</template>

<style scoped></style>
