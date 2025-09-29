<template>
  <div class="greetings">
    <h1 class="green">{{ msg }}</h1>
    <h1 class="black">{{ msg }} {{ userName }}</h1>
    <h1 class="green">{{ `${msg} ${userName}` }}</h1>
    <h1 class="red">{{ helloWorld }}</h1>
    <h1 class="blue">{{ age }}</h1>
    <h1 class="green">{{ defaultUserName }}</h1>
    <h1 class="green">{{ propF }}</h1>
    <h1 class="green">{{ propG }}</h1>
  </div>
</template>

<script setup>
const props = defineProps({
  msg: {
    type: String,
    required: true,
  },
  // age: {
  //   type: Number,
  //   required: true,
  // },
  age: [String, Number, Object],
  userName: String,
  defaultUserName: { type: String, default: 'Chloe' },

  propF: {
    type: Object,
    default(rawProps) {
      return { message: 'hello' }
    },
  },
  propG: {
    validator(value, props) {
      return ['success', 'warning', 'danger'].includes(value)
    },
  },
})

const helloWorld = `${props.msg} ${props.userName}`
</script>

<style scoped>
header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
}
</style>
