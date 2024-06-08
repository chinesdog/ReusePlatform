<script setup>
import {onMounted} from "vue";
import { useRouter} from "vue-router";
const route=useRouter()

onMounted(()=>{
  route.push("/MySeconds")
})
</script>

<template>
<h1>blamkl</h1>
</template>

<style scoped>

</style>