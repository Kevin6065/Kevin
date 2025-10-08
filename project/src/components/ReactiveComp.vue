<script setup>
import { reactive } from 'vue'
import { ref } from 'vue'
const ar = reactive([
  { key: 1, value: 'a' },
  { key: 2, value: 'B' },
])

const IncreaseNumber = ref(3)
function add() {
  ar.push({ key: IncreaseNumber.value++, value: 'c' })
}



let noReactiveArray = [
  { key: 1, value: 'a' },
  { key: 2, value: 'B' },
]

const addnoreactiveArray = () => {
  noReactiveArray.push({ key: 3, value: 'c' })
}
</script>
<template>
  <button @click="add">Array add</button>
  <table>
    <tr v-for="(item, index) in ar" :key="index">
      <td>{{ item.key }}</td>
      <td>{{ item.value }}</td>
    </tr>
  </table>
  <!-- <pre>{{ ar }}</pre> -->
  <hr />
  <button @click="addnoreactiveArray">no_reactive_Array add</button>
  <table>
    <tr v-for="(item, index) in noReactiveArray" :key="index">
      <td>{{ item.key }}</td>
      <td>{{ item.value }}</td>
    </tr>
  </table>
  <!-- <pre>{{ noReactiveArray }}</pre> -->
</template>
<style scoped>
table,
th,
td {
  border: 1px solid;
  text-align: center;
  width: 20lvw;
}
</style>
