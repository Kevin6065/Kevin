<script setup>
defineProps({
  name: {
    type: String,
  },
  price: {
    type: Number,
  },
})
</script>

<template>
  <div class="product-item">
    <p>{{ name }} - ${{ price }}</p>
  </div>
</template>

<style scoped>
.product-item {
  padding: 10px;
  margin-bottom: 6px;
  border: 1px solid #ccc;
  border-radius: 6px;
}
</style>
