<script setup>
const event = (e) => {
  alert(e.key)
}
</script>

<template>
  <input @keyup.enter="event" :placeholder="'請按鍵盤enter'" />
  <br />
  <input @keyup.space="event" :placeholder="'請按鍵盤space'" />
  <br />
  <input @keyup.delete="event" :placeholder="'請按鍵盤delete'" />
  <br />
  <input @keyup.page-down="event" :placeholder="'請按鍵盤page-down'" />
</template>

<style scoped></style>
