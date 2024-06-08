<script setup>

import GoodsForm from "../Conponents/GoodsForm.vue";
import TableCon from "../Conponents/Table.vue";
import {goodsColname} from "../logic/GoodsData.js";
import {useRouter} from "vue-router";
import {GoodStores} from "../logic/GoodsData.js";
const route=useRouter()
function add(){
  route.push('/GoodsForm')
}
</script>

<template>
  <button class="btn btn-success" @click="add">添加</button>
  <TableCon :goods="GoodStores.goods" :colname="goodsColname"></TableCon>
</template>

<style scoped>

</style>