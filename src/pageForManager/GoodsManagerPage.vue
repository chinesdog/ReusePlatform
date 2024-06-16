<template>

  <el-table ref="tableRef" row-key="date" :data="tableData" style="width: 100%" border>
    <el-table-column
        prop="date"
        label="date"
        width="180">
    </el-table-column>

    <el-table-column prop="bookid" label="bookid" />
    <el-table-column
        prop="photo"
        label="photo"
        width="200px">
      <template #default="scope">
        <img style="width: 60px" :src="scope.row.photo">

      </template>
    </el-table-column>

    <el-table-column prop="price" label="price" />
    <el-table-column prop="name" label="name" />
    <el-table-column prop="username" label="发布人" />

    <el-table-column
        fixed="right"
        label="操作"
        width="200">
      <template #default="scope">
        <el-button type="success" size="small" @click="offshelf(scope.$index)">下架</el-button>


      </template>
    </el-table-column>
  </el-table>
</template>

<script  setup>
import {onMounted, ref} from 'vue'
import {ElMessage, ElMessageBox} from 'element-plus'
import axios from "axios";
import {loginStores} from "../stores/loginStores.js";

onMounted(()=>{
  axios({
    method:'get',
    url:'http://localhost:8080/manager/getbooks'
  }).then((res)=>{
    tableData.value=res.data
  })
})

const tableRef = ref([])
const tableData=ref([])
// {bookid:7, date:'2024-05-03 16:01',photo:'',name:'红楼梦',price:120,place:'琴湖8栋',Username:'jack'},
function offshelf(index){
  // console.log(tableData.value[index].bookid)
  ElMessageBox.confirm(
      "确认下架",
      "off",
      {
        confirmButtonText:"OK",
        cancelButtonText:"取消",
        type:"warning"
      }
  ).then(()=>{

    dealOffshelf(index)


  }).catch(()=>{})


}
function dealOffshelf(index){
  axios({
    method:'post',
    url:'http://localhost:8080/manager/offshelf',
    params:{
      username:loginStores.username,
      password:loginStores.password,
      bookid:tableData.value[index].bookid
    }
  }).then((res)=>{
    if(res.data=="success"){
      ElMessage({
        type:'success',
        message:'你已下架'
      })
      tableData.value.splice(index,1)
    }
  })
}

</script>
