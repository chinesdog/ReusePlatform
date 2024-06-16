<template>
  <el-button class="btn btn-success" @click="add">添加</el-button>
  <el-table ref="tableRef" row-key="date" :data="tableData" style="width: 100%" border>
    <el-table-column
        prop="date"
        label="开始交易时间"
        width="180">
    </el-table-column>

    <el-table-column

        label="photo"
        width="200">
      <template #default="scope">
        <img style="width: 60px" :src="scope.row.photo">

      </template>
    </el-table-column>

    <el-table-column prop="bookid" label="bookid" />
    <el-table-column prop="price" label="price" />
    <el-table-column prop="phone" label="联系电话" />
  </el-table>
</template>

<script  setup>
import {onMounted, ref} from 'vue'
import {useRouter} from "vue-router";
import axios from "axios";
import {loginStores} from "../stores/loginStores.js";


onMounted(()=>{
  axios({
    method:'post',
    url:'http://localhost:8080/getDealing',
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
const route=useRouter()
function add(){
  route.push('/GoodsForm')
}


</script>
