<script setup>
import {useRouter} from "vue-router";
import axios from "axios";
import {ref} from "vue";
import {loginStores} from "../stores/loginStores.js";
import {ElMessage} from "element-plus";
import {UserStores} from "../mockData/mockFetchUserInfo.js";


  const radio1 = ref('1')
  let username;
  let password;
  const route=useRouter();
  function  login(){
    let role
    if(radio1.value==='1'){

      role="user"
      loginStores.storeinfo(username,password,'user');
    }
    else if(radio1.value==='2'){

      role="manager"
      loginStores.storeinfo(username,password,'manager');
    }


    axios({
      method:'post',
      url:'http://localhost:8080/login',
      params:{
        username:username,
        password:password,
        role:role
      }
    }).then((res)=>{
      if(res.data!=-1){
        ElMessage({
          type:'success',
          message:"登录成功"
        })
        loginStores.userid=res.data
        if(loginStores.role=='user'){
          route.push("/Market")
        }
        else {
          route.push("/UserManage")
        }
      }
      else {
        ElMessage({
          type:'warning',
          message:"其它错误"
        })
      }
    })
  }

  function register(){
    route.push('/Register')
  }

</script>

<template >
  <div class="container card" id="login" style="width:300px ;"  >
    <div class="card-body" method="post">
      <div class="mb-3">
        <label for="text1" class="form-label">用户名</label>
        <input type="text" class="form-control" name="username" required v-model="username" maxlength="15">

      </div>
      <div class="mb-3">
        <label for="Password1" class="form-label">密码</label>
        <input type="password" class="form-control"  name="password" required v-model="password" maxlength="15">
      </div>
      <div class="mb-2 flex items-center text-sm">
        <el-radio-group v-model="radio1" class="ml-4">
          <el-radio value="1" size="large">用户</el-radio>
          <el-radio value="2" size="large">管理员</el-radio>
        </el-radio-group>
      </div>
      <div class="mb-3">
          <input type="submit" class=" btn btn-primary" value="登录" @click="login">
          <input type="submit" class=" btn btn-primary"  value="注册" @click="register" style="margin-left: 30px">
      </div>
    </div>
  </div>
</template>

<style scoped>

.card{
  top: 100px;
}
</style>