<template>

  <el-table ref="tableRef"  row-key="date" :data="tableData"  style="width: 100%">
    <el-table-column
        prop="date"
        label="书籍发布时间"
        width="180"
    />
    <el-table-column prop="bookid" label="bookid" />
    <el-table-column prop="name" label="name" />

    <el-table-column prop="price" label="price" />
    <el-table-column
        prop="tag"
        label="tag"
        :filters="[
        { text: '审核中', value: 'wait' },
        { text: '已通过', value: 'accept' },
        { text: '被拒绝', value: 'reject' },
        ]"
        :filter-method="filterTag">
      <template #default="scope">
        <el-tag
            v-if="scope.row.tag === 'accept' "
            :type=" 'success' "
            disable-transitions
        >{{ scope.row.tag }}</el-tag
        >
        <el-tag
            v-if="scope.row.tag === 'wait' "
            :type=" 'primary' "
            disable-transitions
        >{{ scope.row.tag }}</el-tag
        >
        <el-tag
            v-if="scope.row.tag === 'reject' "
            :type=" 'danger' "
            disable-transitions
        >{{ scope.row.tag }}</el-tag
        >
      </template>

    </el-table-column>

    />


  </el-table>
</template>



<script  setup>
import {onMounted, ref} from 'vue'
// import  { TableColumnCtx, TableInstance } from 'element-plus'
import {releaseStores} from "../mockData/mockrelease.js";
import {loginStores} from "../stores/loginStores.js";
import axios from "axios";


onMounted(()=>{
  axios({
    method:'post',
    url:'http://localhost:8080/getPosts',
    params:{
      username:loginStores.username,
      password:loginStores.password
    }
  }).then((res)=>{
    tableData.value=res.data
  })
})

const tableRef=ref([])
// const tableData=releaseStores.goods
const tableData=ref([])
const filterTag = (value, row) => {
  return row.tag === value
}


</script>
