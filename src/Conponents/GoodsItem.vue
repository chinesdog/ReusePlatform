<script setup>
import {ref} from "vue";
import { GoodStores} from "../logic/GoodsData.js";
import {ElMessage, ElMessageBox} from "element-plus";
import {useRouter} from "vue-router";


const props=defineProps(['items','index'])
const route=useRouter()
let items=props.items
const index=props.index
const Visible=ref(false)
let ContentWrapper={name:items.name,price:items.price,publishMan:items.publishMan}
function edit(){
  Visible.value=true
}
function save(){
  GoodStores.modifyGoods(ContentWrapper,index)
  ElMessage({
    message:"保存成功",
    type:"success"
  })
  Visible.value=false
}
function del(){
  ElMessageBox.confirm(
      `确认删除 第 ${index} 行`,
      "表格项",
      {
        confirmButtonText:"OK",
        cancelButtonText:"取消",
        type:"warning"
      }
  ).then(()=>{
    GoodStores.delGoods(index)
    route.push({
      path:'/Blank'
    })
    ElMessage({
      message:'删除成功',
      type:"success"
    })
  })

}
</script>

<template>
  <th scope="row">{{ index}}</th>

  <template v-if="Visible==true">
    <td> <input type="text" class="form-control"  v-model="ContentWrapper.name" ></td>
    <td> <input type="text" class="form-control"  v-model="ContentWrapper.price" ></td>
    <td> <input type="text" class="form-control"  v-model="ContentWrapper.publishMan" ></td>
  </template>

  <template v-if="Visible==false">
    <td> <input type="text" class="form-control"  v-model="ContentWrapper.name" disabled></td>
    <td> <input type="text" class="form-control"  v-model="ContentWrapper.price" disabled></td>
    <td> <input type="text" class="form-control"  v-model="ContentWrapper.publishMan" disabled></td>
  </template>

  <button type="button" class="btn btn-outline-primary" @click="edit">编辑</button>
  <button type="button" class="btn btn-outline-danger" @click="del">删除</button>
  <button type="button" class="btn btn-outline-danger" @click="save">保存</button>
</template>

<style scoped>

</style>