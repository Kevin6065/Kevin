<script setup>
import { ref } from 'vue'
import TimerComponent from './TimerComponent.vue'

const showTimer = ref(true)
const seconds = ref(0)
</script>

<template>
  <div>
    <button @click="showTimer = !showTimer">
      {{ showTimer ? '隱藏計時器' : '顯示計時器' }}
    </button>

    <TimerComponent v-if="showTimer" :sec="seconds" />
  </div>
</template>

<style scoped></style>
