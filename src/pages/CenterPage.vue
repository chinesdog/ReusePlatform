<script setup>

import {UserStores} from "../mockData/mockFetchUserInfo.js";
import {onBeforeMount, onMounted, ref} from "vue";
import {ElMessage} from "element-plus";
import axios from "axios";
import {loginStores} from "../stores/loginStores.js";
import {useRouter} from "vue-router";



onMounted(()=>{

  axios({
    method:'post',
    url:'http://localhost:8080/getUserCenter',
    params:{
      username:loginStores.username,
      password:loginStores.password
    }
  }).then((res)=>{
    UserStores.UserInfo=res.data
  })

})


const Visible=ref(false)

function modify(){
  Visible.value=true



}
function submit(){
  Visible.value=false
  axios({
    method:'post',
    url:'http://localhost:8080/manager/modify',
    params:{
      username:loginStores.username,
      password:loginStores.password,
      name:UserStores.UserInfo.name,
      liveplace:UserStores.UserInfo.liveplace,
      dealplace:UserStores.UserInfo.dealplace
    }
  }).then((res)=>{
    if(res.data=='success'){
      ElMessage({
        type:'success',
        message:'修改成功'
      })
    }
  })
}
</script>

<template>
  <div class="card col-4 " style="margin-top: 30px;padding: 20px;margin-left: 40%"  >
    <label  class="form-label">用户id</label>
    <input class="form-control" v-model="UserStores.UserInfo .userid" disabled>

    <label  class="form-label">名字</label>
    <input v-if="Visible" class="form-control" v-model="UserStores.UserInfo.name">
    <input v-else class="form-control" v-model="UserStores.UserInfo .name" disabled>

    <label  class="form-label" >账号昵称</label>
    <input  class="form-control" v-model="UserStores.UserInfo .username" disabled>

    <label  class="form-label">住址</label>
    <input v-if="Visible" class="form-control" v-model="UserStores.UserInfo .liveplace">
    <input v-else class="form-control" v-model="UserStores.UserInfo .liveplace" disabled>

    <label  class="form-label">常见交易地址</label>
    <input v-if="Visible" class="form-control" v-model="UserStores.UserInfo .dealplace" >
    <input v-else class="form-control" v-model="UserStores.UserInfo.dealplace" disabled>

    <label  class="form-label">联系电话</label>
    <input  class="form-control" v-model="UserStores.UserInfo .phone" disabled>

    <div class="row" style="margin-top: 30px">
      <div class="col-4">
        <button class="btn btn-primary" @click="modify">修改</button>
      </div>
      <div class="col-4">
        <button class="btn btn-danger" @click="submit">提交</button>
      </div>

    </div>


  </div>
</template>

<style scoped>

</style>