<script setup>
import { reactive, watch } from 'vue'

const user = reactive({
  name: 'Alice',
  address: {
    city: 'Taipei',
    street: 'Zhongshan Rd.',
  },
})

//修改user.name
const changName = () => {
  user.name = user.name === 'Alice' ? 'Bob' : 'Alice'
}

//修改user.address.city
const changCity = () => {
  user.address.city = user.address.city === 'Taipei' ? 'Taichung' : 'Taipei'
}

watch(
  () => user.name,
  (val) => {
    console.log('🚀 ~ 修改name:', val)
  },
)

//監聽 user.address（無 deep） 無任何變化時是不會被觸發的，除非下了deep
watch(
  () => user.address,
  (newVal) => {
    console.log('監聽city (有 deep) : ', newVal)
  },
)

watch(
  user,
  (val) => {
    console.log('修改 city (無 deep) : ', val)
  },
  { immediate: true, deep: true },
)

watch([() => user.name, () => user.address.city], ([newName, newCity], [OldName, OldCity]) => {
  console.log('🚀 ~ newName:', newName, OldName)
  console.log('🚀 ~ newCity:', newCity, OldCity)
})
</script>

<template>
  <div>
    <button @click="changName">改名</button>
    <button @click="changCity">改城市</button>

    <pre>
      {{ user }}
    </pre>
  </div>
</template>

<style scoped>
button {
  margin-right: 10px; /* 添加右邊的間距 */
  margin-bottom: 10px; /* 添加下方的間距 */
  padding: 5px 10px; /* 添加內邊距 */
  background-color: #0077cc; /* 按鈕的顏色 */
  color: #fff; /* 按鈕的文字顏色 */
  border: none; /* 移除按鈕的邊框 */
  border-radius: 4px; /* 添加圓角 */
  cursor: pointer; /* 添加指標樣式 */
}
button:active {
  background-color: #003366; /* 按下時的顏色 */
  transform: translateX(2px) translateY(2px); /* 將按鈕 右移2px 下移2px */
}
</style>
