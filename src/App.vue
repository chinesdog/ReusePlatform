<script setup>

import {useRouter} from "vue-router";
import {loginStores} from "./stores/loginStores.js";
import {ref} from "vue";
const myroute=useRouter();
const currentpath=ref('/Market')
// const Market=ref(true)
// const PostGoods=ref(false)
// const WantedSeconds=ref(false)
// const Notice=ref(false)
// const  MySeconds=ref(false)
// const Center=ref(false)
// const UserManage=ref(false)
// const IssueItem=ref(false)
// const GoodsManage=ref(false)
// const Center=ref(false)
function jump(path){
  currentpath.value=path

  myroute.push(path);
}
function exit(){
  loginStores.role=""
  currentpath.value='/Market'
  myroute.push("/")
}
function computed(apath){
  if(apath===currentpath.value)return true
  return false
}
</script>

<template>

  <template v-if="loginStores.role=='user' ">
    <ul class="nav justify-content-center">
      <li class="nav-item" :class="{myactive:computed('/Market')}" >
        <a class="nav-link"  @click="jump('/Market')" aria-current="page" href="#">二手市场</a>
      </li>
      <li class="nav-item" :class="{myactive:computed('/PostGoods')}">
        <a class="nav-link" @click="jump('/PostGoods')" href="#">已发布的二手</a>
      </li>
      <li class="nav-item" :class="{myactive:computed('/WantedSeconds')}">
        <a class="nav-link" @click="jump('/WantedSeconds')" href="#">想要的二手</a>
      </li>
      <li class="nav-item" :class="{myactive:computed('/Notice')}">
        <a class="nav-link" @click="jump('/Notice')" href="#">通知</a>
      </li>
      <li class="nav-item" :class="{myactive:computed('/MySeconds')}">
        <a class="nav-link" @click="jump('/MySeconds')" href="#">正在交易中的二手</a>
      </li>
      <li class="nav-item" :class="{myactive:computed('/Center')}">
        <a class="nav-link" @click="jump('/Center')" href="#">个人中心</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" @click="exit" href="#">退出登录</a>
      </li>
    </ul>
  </template>

  <template v-if="loginStores.role=='manager' ">
    <ul class="nav justify-content-center">
      <li class="nav-item" :class="{myactive:computed('/UserManage')}">
        <a class="nav-link" @click="jump('/UserManage')" href="#">用户管理</a>
      </li>
      <li class="nav-item" :class="{myactive:computed('/IssueItem')}">
        <a class="nav-link" @click="jump('/IssueItem')" href="#">提交管理</a>
      </li>
      <li class="nav-item" :class="{myactive:computed('/GoodsManage')}">
        <a class="nav-link" @click="jump('/GoodsManage')" href="#">书籍管理</a>
      </li>
      <li class="nav-item" :class="{myactive:computed('/Center')}">
        <a class="nav-link" @click="jump('/Center')" href="#">个人中心</a>
      </li>
      <li class="nav-item" >
        <a class="nav-link" @click="exit" href="#">退出登录</a>
      </li>
    </ul>
  </template>

  <div style="height: 3px ;background-color: gray"></div>
<!--  <button type="button" class="btn btn-primary"><router-link to="PostGoods">发布二手</router-link></button>-->

<!--  <router-link to="MySeconds">我的二手</router-link>-->
  <RouterView></RouterView>
</template>

<style scoped>
  .myactive{
    background: #cb5454;
  }
</style>

