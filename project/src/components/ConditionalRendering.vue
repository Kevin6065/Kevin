<script setup>
import { ref, reactive } from 'vue'

const users = reactive([
  {
    username: 'kevin',
    password: '1234',
    role: 'admin',
  },
  {
    username: 'Jerry',
    password: '456',
    role: 'user',
  },
  {
    username: 'guest',
    password: '789',
    role: 'guest',
  },
])

const isLoggedIn = ref(false)
const username = ref('')
const password = ref('')
const errorMsg = ref('')
const role = ref('')

const login = () => {
  const findUser = users.find((user) => {
    return user.username === username.value && user.password === password.value
  })
  if (findUser) {
    isLoggedIn.value = true
    username.value = findUser.username
    role.value = findUser.role
    errorMsg.value = ''
  } else {
    username.value = ''
    password.value = ''
    errorMsg.value = '登入錯誤'
  }
}

const logout = () => {
  isLoggedIn.value = false
  username.value = ''
  password.value = ''
  errorMsg.value = ''
  role.value = ''
}
</script>

<template>
  <div class="container">
    <!-- 顯示登入表單 -->
    <div v-if="!isLoggedIn">
      <h3>請登入</h3>
      <input v-model="username" placeholder="帳號" />
      <input v-model="password" type="password" placeholder="密碼" />
      <button @click="login">登入</button>
      <p v-if="errorMsg" class="error">{{ errorMsg }}</p>
    </div>

    <!-- 登入後顯示身份內容 -->
    <div v-else>
      <div v-if="role === 'admin'">
        <h2>👑 歡迎管理員 {{ username }}</h2>
        <p>這是管理後台畫面。</p>
      </div>

      <div v-else-if="role === 'user'">
        <h2>👤 歡迎會員 {{ username }}</h2>
        <p>這是會員專區。</p>
      </div>

      <div v-else>
        <p>身份不明，請聯絡客服。</p>
      </div>

      <button @click="logout">登出</button>
    </div>
  </div>
</template>

<style scoped>
.container {
  max-width: 400px;
  margin: 2rem auto;
  padding: 1rem;
  border: 1px solid #ccc;
  border-radius: 8px;
}
input {
  display: block;
  width: 100%;
  margin: 0.5rem 0;
  padding: 0.5rem;
}
button {
  padding: 0.5rem 1rem;
}
.error {
  color: red;
}
</style>
