<script setup>


import { goodsInterface} from "../mockData/mockSecondHands.ts";
import {useRouter} from "vue-router";
import {ElMessage} from "element-plus";
import {ref} from "vue";
import {Plus} from '@element-plus/icons-vue'
import axios from "axios";
import {loginStores} from "../stores/loginStores.js";
const route=useRouter()
let ContentWrapper=goodsInterface




function ret(){
  //返回主页
  route.push('/MySeconds')
}
function submit(){

  axios({
    method:'post',
    url:'http://localhost:8080/postPosts',
    params:{
      username:loginStores.username,
      password:loginStores.password,
      photo:ContentWrapper.photo,
      name:ContentWrapper.name,
      price:ContentWrapper.price
    }
  }).then((res)=>{
    if(res.data=="success"){
      ElMessage({
        message:"添加成功",
        type:"success"
      })
      route.push('/MySeconds')
    }
  })

}

</script>

<template>

<!--  表单-->
  <div class="card col-4" style="margin-top: 30px;padding: 20px;margin-left: 100px" >
    <button class="btn btn-close" @click="ret"></button>

    <label  class="form-label">name</label>
    <input class="form-control"  v-model="ContentWrapper.name" >
    <label  class="form-label">price</label>
    <input class="form-control"  v-model="ContentWrapper.price" >

    <label  class="form-label">图片地址</label>
    <input class="form-control"  v-model="ContentWrapper.photo" >
    <el-image style="width: 100px ; height: 100px;margin-top: 20px" :src="ContentWrapper.photo" />

    <div class="row" style="margin-top: 10px">
      <button class="btn btn-success col-4" @click="submit" id="liveToastBtn">提交</button>

    </div>
  </div>

<!--Toast-->


</template>

<style scoped>
.avatar-uploader .avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>

<style>
.avatar-uploader .el-upload {
  border: 1px dashed var(--el-border-color);
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  transition: var(--el-transition-duration-fast);
}

.avatar-uploader .el-upload:hover {
  border-color: var(--el-color-primary);
}

.el-icon.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  text-align: center;
}
</style>