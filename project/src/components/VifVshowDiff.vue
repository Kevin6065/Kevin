<script setup>
import { ref } from 'vue'

const show1 = ref(true)
const show2 = ref(true)

const toggleShow1 = () => {
  show1.value = !show1.value
}

const toggleShow2 = () => {
  show2.value = !show2.value
}
</script>

<template>
  <div>
    <button @click="toggleShow1">Toggle Section 1</button>
    <button @click="toggleShow2">Toggle Section 2</button>
    <div class="section" v-if="show1">Section 1 - Shown using v-if</div>
    <div class="section" v-show="show2">Section 2 - Shown using v-show</div>
  </div>
</template>

<style scoped>
.section {
  margin: 10px;
  padding: 10px;
  border: 1px solid black;
}

.section:nth-child(odd) {
  background-color: lightblue;
}

.section:nth-child(even) {
  background-color: lightgreen;
}
</style>
