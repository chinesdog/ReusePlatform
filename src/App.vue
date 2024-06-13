<script setup>

import {useRouter} from "vue-router";
const myroute=useRouter();
function jump(path){
  myroute.push(path);
}

</script>

<template>
  <ul class="nav justify-content-center">
    <li class="nav-item">
      <a class="nav-link" @click="jump('/Market')" aria-current="page" href="#">二手市场</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" @click="jump('/PostGoods')" href="#">发布二手</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" @click="jump('/MySeconds')" href="#">我的二手</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" @click="jump('/Center')" href="#">个人中心</a>
    </li>
  </ul>
  <div style="height: 3px ;background-color: gray"></div>
<!--  <button type="button" class="btn btn-primary"><router-link to="PostGoods">发布二手</router-link></button>-->

<!--  <router-link to="MySeconds">我的二手</router-link>-->
  <RouterView></RouterView>
</template>

<style scoped>
/* <li class="nav-item"> */
      /* <a class="nav-link" @click="jump('/Market')" aria-current="page" href="#">二手市场</a> */
    /* </li> */
</style>

