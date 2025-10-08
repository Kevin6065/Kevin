<template>
  <div>
    <h2>購物車</h2>
    <div class="items-container">
      <div v-for="(item, index) in cartItems" :key="index" class="item">
        <img :src="item.image" alt="item.name" class="item-image" />
        <div class="item-details">
          <h3>{{ item.name }}</h3>
          <p>價格: ${{ item.price }}</p>
          <div>
            <button @click="decrementQuantity(index)">-</button>
            <span>{{ item.quantity }}</span>
            <button @click="incrementQuantity(index)">+</button>
          </div>
        </div>
      </div>
    </div>
    <div class="cart-summary">
      <h3>購物車摘要</h3>
      <p>總數量: {{ totalQuantity }}</p>
      <p>總價格: ${{ totalPrice }}</p>
      <button @click="checkout">結算</button>
    </div>
  </div>
</template>

<script setup>
import { reactive, computed } from 'vue'

// 購物車商品
const cartItems = reactive([
  {
    name: '蘋果',
    price: 10,
    quantity: 0,
    image:
      'https://images.pexels.com/photos/672101/pexels-photo-672101.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1',
  },
  {
    name: '西瓜',
    price: 30,
    quantity: 0,
    image:
      'https://images.pexels.com/photos/3513238/pexels-photo-3513238.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1',
  },
  {
    name: '鳳梨',
    price: 50,
    quantity: 0,
    image:
      'https://images.pexels.com/photos/2469772/pexels-photo-2469772.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1',
  },
])
const decrementQuantity = (index) => {
  if (cartItems[index].quantity > 0) {
    cartItems[index].quantity--
  }
}

const incrementQuantity = (index) => {
  cartItems[index].quantity++
}
const totalQuantity = computed(() => cartItems.reduce((acc, product) => acc + product.quantity, 0))

const totalPrice = computed(() =>
  cartItems.reduce((acc, product) => acc + product.quantity * product.price, 0),
)
</script>
<style>
.items-container {
  display: flex;
  flex-wrap: wrap;
}

.item {
  display: flex;
  margin-bottom: 20px;
}

.item-image {
  width: 100px;
  height: 100px;
  margin-right: 20px;
}

.item-details {
  display: flex;
  flex-direction: column;
}

button {
  margin: 0 5px;
}
</style>
