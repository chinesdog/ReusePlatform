<template>

  <el-table ref="tableRef" row-key="date" :data="tableData" style="width: 100%" border>


    <el-table-column prop="userid" label="userid" />

    <el-table-column

        label="photo"
        width="200">
      <template #default="scope">
        <img style="width: 60px" :src="scope.row.photo">

      </template>
    </el-table-column>

    <el-table-column prop="name" label="name" />
    <el-table-column prop="price" label="price" />
    <el-table-column prop="phone" label="电话" />

    <el-table-column
        fixed="right"
        label="操作"
        width="200">
      <template #default="scope">
        <el-button type="success" size="small" @click="accept(scope.$index)">接受</el-button>
        <el-button type="danger" size="small" @click="reject(scope.$index)">拒绝</el-button>

      </template>
    </el-table-column>
  </el-table>
</template>
<!--{name:'西游记',price:122,photo:'',userid:2}-->
<script  setup>
import {onMounted, ref} from 'vue'
import {ElMessage} from 'element-plus'

import axios from "axios";
import {loginStores} from "../stores/loginStores.js";
const tableRef = ref([])
const tableData=ref([])

onMounted(()=>{
  axios({
    method:'post',
    url:'http://localhost:8080/manager/getposts',
    params:{
      username:loginStores.username,
      password:loginStores.password
    }
  }).then((res)=>{
    tableData.value=res.data
  })
})

function accept(index){

  axios({
    method:'post',
    url:'http://localhost:8080/manager/dealposts',
    params:{
      username:loginStores.username,
      password:loginStores.password,
      postid:tableData.value[index].postid,
      tag:"accept"
    }
  }).then((res)=>{
    if(res.data=="success"){
      ElMessage({
        type:'success',
        message:'你已同意'
      })
      tableData.value.splice(index,1)
    }
  })
}

function reject(index){

  axios({
    method:'post',
    url:'http://localhost:8080/manager/dealposts',
    params:{
      username:loginStores.username,
      password:loginStores.password,
      postid:tableData.value[index].postid,
      tag:"reject"
    }
  }).then((res)=>{
    if(res.data=="success"){
      ElMessage({
        type:'success',
        message:'你已拒绝'
      })
      tableData.value.splice(index,1)
    }
  })
}
</script>
