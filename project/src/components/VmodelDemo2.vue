<script setup>
import { reactive, ref } from 'vue'
const form = reactive({
  name: '',
  gender: '',
  hobbies: [],
  country: '',
})

const genderOptions = ref(['男', '女'])
const hobbyOptions = ref(['閱讀', '運動', '旅行'])
const countryOptions = ref([
  { numeric: 158, code: 'tw', name: '台灣' },
  { numeric: 392, code: 'jp', name: '日本' },
  { numeric: 840, code: 'us', name: '美國' },
  { numeric: 410, code: 'kr', name: '韓國' },
  { numeric: 156, code: 'cn', name: '中國' },
  { numeric: 826, code: 'gb', name: '英國' },
  { numeric: 250, code: 'fr', name: '法國' },
  { numeric: 276, code: 'de', name: '德國' },
])
const result = ref(null)

const submit = () => {
  if (form.name && form.gender && form.country) {
    result.value = { ...form }
  } else {
    alert('姓名、性別、國家 為必填選項')
  }
}

const reset = () => {
  form.name = ''
  form.gender = ''
  form.hobbies = []
  form.country = ''

  result.value = null
}
</script>

<template>
  <div class="form-container">
    <h2>📝 個人資料表單</h2>

    <!-- 姓名 -->
    <div class="form-group">
      <label>姓名：</label>
      <input v-model="form.name" placeholder="請輸入姓名" />
    </div>

    <!-- 性別 -->
    <div class="form-group">
      <label>性別：</label>
      <label v-for="(option, index) in genderOptions" :key="index">
        <input type="radio" :value="option" v-model="form.gender" />
        {{ option }}
      </label>
    </div>

    <!-- 興趣 -->
    <div class="form-group">
      <label>興趣：</label>
      <label v-for="(interest, index) in hobbyOptions" :key="index">
        <input type="checkbox" :value="interest" v-model="form.hobbies" />
        {{ interest }}
      </label>
    </div>

    <!-- 國家 -->
    <div class="form-group">
      <label>國家：</label>
      <select v-model="form.country">
        <option disabled value="">請選擇</option>
        <option v-for="country in countryOptions" :key="country.code" :value="country?.numeric">
          {{ country.name }}
        </option>
      </select>
    </div>

    <!-- 送出按鈕 -->
    <button class="submit" @click="submit">送出</button>
    <button class="reset" @click="reset">重置</button>

    <!-- 顯示填寫結果 -->
    <div v-if="result" class="result">
      <h3>✔️ 填寫結果</h3>
      <p>姓名：{{ result.name }}</p>
      <p>性別：{{ result.gender }}</p>
      <p>興趣：{{ result.hobbies.join('、') }}</p>
      <p>國家代碼：{{ result.country }}</p>
    </div>
  </div>
</template>

<style scoped>
.form-container {
  max-width: 500px;
  margin: auto;
  border: 2px solid #ccc;
  border-radius: 6px;
  padding: 20px;
  background: #f9f9f9;
}
.form-group {
  margin-bottom: 16px;
}
label {
  margin-right: 12px;
}
input,
select {
  padding: 6px;
  margin-top: 4px;
}

button {
  padding: 8px 16px;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-right: 8px;
}
.submit {
  background-color: #42b983;
}
.reset {
  background-color: #ee2e2e;
}

.result {
  margin-top: 24px;
  padding: 16px;
  background: #eaffea;
  border-left: 4px solid #42b983;
}
</style>
