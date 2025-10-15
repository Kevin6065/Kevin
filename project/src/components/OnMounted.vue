<script setup>
import { ref, onMounted } from 'vue'

const users = ref([])
const loading = ref(true)
const error = ref(null)

onMounted(async () => {
  try {
    // 模擬載入延遲 5 秒
    await new Promise((resolve) => setTimeout(resolve, 5000))

    const res = await fetch('https://jsonplaceholder.typicode.com/users')

    if (!res.ok) {
      throw new Error(`伺服器錯誤：${res.status}`)
    }

    users.value = await res.json()
  } catch (err) {
    error.value = err.message || '未知錯誤'
  } finally {
    loading.value = false
  }
})
</script>

<template>
  <div class="user-container">
    <h2>📋 使用者列表</h2>

    <!-- Loading Spinner -->
    <div v-if="loading" class="spinner-container">
      <div class="spinner"></div>
      <p>資料載入中，請稍候...</p>
    </div>

    <!-- Error -->
    <div v-else-if="error" class="error-message">⚠️ 無法載入資料：{{ error }}</div>

    <!-- Users -->
    <div v-else>
      <div v-for="user in users" :key="user.id" class="user-card">
        <h3>{{ user.name }}</h3>
        <p><strong>Email:</strong> {{ user.email }}</p>
        <p><strong>Website:</strong> {{ user.website }}</p>
        <p><strong>Phone:</strong> {{ user.phone }}</p>

        <div class="address">
          <h4>🏠 Address</h4>
          <p>{{ user.address.suite }}, {{ user.address.street }}</p>
          <p>{{ user.address.city }}, {{ user.address.zipcode }}</p>
          <p>
            <strong>Lat:</strong> {{ user.address.geo.lat }}, <strong>Lng:</strong>
            {{ user.address.geo.lng }}
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.user-container {
  max-width: 800px;
  margin: 40px auto;
  padding: 0 16px;
  font-family: Arial, sans-serif;
  text-align: center;
}

h2 {
  margin-bottom: 24px;
  color: #333;
}

.spinner-container {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.spinner {
  border: 6px solid #f3f3f3;
  border-top: 6px solid #42b983;
  border-radius: 50%;
  width: 50px;
  height: 50px;
  animation: spin 1s linear infinite;
  margin-bottom: 10px;
}

@keyframes spin {
  to {
    transform: rotate(360deg);
  }
}

.error-message {
  color: red;
  font-weight: bold;
  margin-top: 20px;
}

.user-card {
  background-color: #f9f9f9;
  border-left: 4px solid #42b983;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.05);
  padding: 16px;
  margin-bottom: 20px;
  border-radius: 8px;
  text-align: left;
}

.user-card h3 {
  margin-top: 0;
  color: #2c3e50;
}

.user-card p {
  margin: 4px 0;
}

.address {
  margin-top: 10px;
  background-color: #fff;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 6px;
}
</style>
