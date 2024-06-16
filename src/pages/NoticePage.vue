<template>

  <el-table ref="tableRef" row-key="date" :data="tableData" style="width: 100%" border>
    <el-table-column
        prop="date"
        label="提出申请时间"
        width="180">
    </el-table-column>

    <el-table-column prop="bookid" label="bookid" />
    <el-table-column prop="name" label="name" />
    <el-table-column prop="phone" label="联系电话" />

    <el-table-column
        fixed="right"
        label="操作"
        width="200">
      <template #default="scope">
<!--        <div class="row"></div>-->
        <el-button type="success" size="small" @click="accept(scope.$index)">接受</el-button>
        <el-button type="danger" size="small" @click="reject(scope.$index)">拒绝</el-button>

      </template>
    </el-table-column>
  </el-table>
</template>



<script  setup>
import {onMounted, ref} from 'vue'
import {ElMessage} from 'element-plus'

import axios from "axios";
import {loginStores} from "../stores/loginStores.js";
// {date:'2024-05-03',photo:'',name:'西游记',publisher:'',price:100,tag:'审核中'},

onMounted(()=>{
  axios({
    method:'post',
    url:'http://localhost:8080/getnotice',
    params:{
      username:loginStores.username,
      password:loginStores.password,
      userid:loginStores.userid
    }
  }).then((res)=>{
    tableData.value=res.data
  })
})

const tableRef = ref([])
const tableData=ref([])
// {date:'2024-05-04 16:01',bookid:2,name:'平凡的世界',Username:'Mary'},
function accept(index){

  axios({
    method:'post',
    url:'http://localhost:8080/dealNotice',
    params:{
      username:loginStores.username,
      password:loginStores.password,
      tag:"accept",
      bookid:tableData.value[index].bookid
    }
  }).then((res)=>{
    if(res.data=="success"){
      ElMessage({
        type:'success',
        message:'你已接受'
      })
      tableData.value.splice(index,1)
    }
  })



}
function reject(index){
  axios({
    method:'post',
    url:'http://localhost:8080/dealNotice',
    params:{
      username:loginStores.username,
      password:loginStores.password,
      tag:"reject",
      bookid:tableData.value[index].bookid
    }
  }).then((res)=>{
    if(res.data=="success"){
      ElMessage({
        type:'warning',
        message:'你已拒绝'
      })
      tableData.value.splice(index,1)
    }
  })

}
</script>
