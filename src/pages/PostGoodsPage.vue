
<script setup>


import {onMounted} from "vue";

onMounted(()=>{
  const input=document.getElementById("input")
  input.addEventListener("change",solve,false);
})
function solve(e){
  const show=document.getElementById("show")
  console.log(e.target.files)
  show.src=URL.createObjectURL(e.target.files[0])

}

</script>

<template>
  <input type="file" id="input" multiple>
  <img id="show" src="#" width="100px">
</template>

<style scoped>

</style>