<script setup>

import {ElMessage, ElMessageBox} from "element-plus";
import axios from "axios";
import {loginStores} from "../stores/loginStores.js";


const props=defineProps(['goods'])
const goods=props.goods
function deal(bookid){


  ElMessageBox.confirm(
      "确认交易",
        "hah",
      {
        confirmButtonText:"OK",
        cancelButtonText:"取消",
        type:"warning"
      }
  ).then(()=>{
    solvedealing(bookid)

  }).catch(()=>{})
}

function solvedealing(bookid){
  axios({
    method:'post',
    url:'http://localhost:8080/selectWanted',
    params:{
      username:loginStores.username,
      password:loginStores.password,
      bookid:bookid

    }
  }).then((res)=>{
    if(res.data=="success"){
      ElMessage({
        type:'success',
        message:'请求交易'
      })
    }
  })
}

</script>

<template>
  <div class="card" style="width: 18rem;">

    <div class="card-body">

      <img :src="props.goods.photo" width="50px" height="70px">
      <p>{{props.goods.name}}</p>
      <p> <strong>id：</strong>  {{props.goods.bookid}}</p>
      <p> <strong>价格：</strong>  {{props.goods.price}}</p>
      <p><strong>交易地点：</strong>{{props.goods.dealplace}}</p>
      <p><strong>发布用户：</strong>{{props.goods.username}}</p>
      <p><strong>联系电话：</strong>{{props.goods.phone}}</p>
      <button type="button" class="btn btn-primary" @click="deal(props.goods.bookid)">想要交易</button>
    </div>
  </div>
</template>

<style scoped>

</style>