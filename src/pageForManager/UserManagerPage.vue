<template>

  <el-table ref="tableRef" row-key="date" :data="tableData" style="width: 100%" border>


    <el-table-column prop="userid" label="userid" />
    <el-table-column prop="name" label="name" />
    <el-table-column prop="username" label="username" />
    <el-table-column prop="liveplace" label="liveplace" />
    <el-table-column prop="dealplace" label="dealplace" />
    <el-table-column
        fixed="right"
        label="操作"
        width="200">
      <template #default="scope">
        <el-button type="success" size="small" @click="reset(scope.$index)">重置密码</el-button>


      </template>
    </el-table-column>
  </el-table>
</template>
<!--{date:'', userid:4,name:'123',username:'hah',liveplace:'琴湖', dealplace:'琴湖'}-->
<script  setup>
import {onMounted, ref} from 'vue'
import {ElMessage} from 'element-plus'
import axios from "axios";
import {loginStores} from "../stores/loginStores.js";

onMounted(()=>{
  axios({
    method:"get",
    url:'http://localhost:8080/manager/getusers',

  }).then((res)=>{
    tableData.value=res.data
  })
})

const tableRef = ref([])
const tableData=ref([])
function reset(index){

  axios({
    method:'post',
    url:'http://localhost:8080/manager/reset',
    params:{
      username:loginStores.username,
      password:loginStores.password,
      userid:tableData.value[index].userid
    }
  }).then((res)=>{
    if(res.data=="success"){
      ElMessage({
        type:'success',
        message:'重置成功'
      })

    }
  })



}

</script>
