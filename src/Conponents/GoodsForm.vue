<script setup>


import {FormGoodsName, GoodStores} from "../logic/GoodsData.js";
import {useRouter} from "vue-router";
import {ElMessage} from "element-plus";
const route=useRouter()
let ContentWrapper={name:'',price:'',publishMan:''}

function ret(){
  //返回主页
  route.push('/MySeconds')
}
function submit(){
  GoodStores.addGoods(ContentWrapper)
  ElMessage({
    message:"添加成功",
    type:"success"
  })
  route.push('/MySeconds')
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
    <label  class="form-label">publishMan</label>
    <input class="form-control"  v-model="ContentWrapper.publishMan" >
    <div class="row" style="margin-top: 10px">
      <button class="btn btn-success col-4" @click="submit" id="liveToastBtn">提交</button>

    </div>
  </div>

<!--Toast-->


</template>

<style scoped>

</style>