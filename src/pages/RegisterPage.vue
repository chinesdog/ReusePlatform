<script setup>
import {useRouter} from "vue-router";
import {ElMessage} from "element-plus";
import axios from "axios";
const route=useRouter()
let username,password,phonenumber;

function register(){
  // console.log(username,password,phonenumber)

  if(phonenumber==null||phonenumber.length==0){
    ElMessage({
      type:'warning',
      message:'手机号不能未空'
    })
    return
  }

  let phoneReg=/^1[3-9]\d{9}$/
  if(!phoneReg.test(phonenumber)){
    ElMessage({
      type:'warning',
      message:'手机号格式不对'
    })
    return
  }


  axios({
    method:'post',
    url:'http://localhost:8080/register',
    params:{
      username:username,
      password:password,
      phone:phonenumber
    }
  }).then((res)=>{
    if(res.data=="success"){
      ElMessage({
        type:'success',
        message:"注册成功"
      })
      route.push('/')
    }
    else {
      ElMessage({
        type:"warning",
        message:"注册失败"
      })
    }
  })
}
function close(){
  route.push("/")
}
</script>

<template>
<div class="container card" id="register" style="width:300px ;">
<button class="btn btn-close" @click="close"></button>
<div class="card-body" method="post">
  <div class="mb-3">
    <label for="text1" class="form-label">用户名</label>
    <input type="text" class="form-control" name="username" required v-model="username" maxlength="15">

  </div>
  <div class="mb-3">
    <label for="Password1" class="form-label">密码</label>
    <input type="password" class="form-control"  name="password" required v-model="password" maxlength="15">
  </div>
  <div class="mb-3">
    <label  class="form-label">电话</label>
    <input type="text" class="form-control"  name="phonenumber" required v-model="phonenumber" maxlength="15">
  </div>
  <div class="mb-3">
    <input type="submit" class=" btn btn-primary" value="注册" @click="register">

  </div>

</div>
</div>
</template>
<style scoped>
.card{
  top: 100px;
}
</style>