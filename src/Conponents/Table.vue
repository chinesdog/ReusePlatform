<script setup>
import {onMounted, ref} from "vue";
import TableItem from "./GoodsItem.vue";

const props= defineProps(['goods','colname'])
const goods=props.goods
const colname=props.colname
</script>

<template>

  <table class="table">
    <thead>
    <tr scope="col">
      <th scope="row">#</th>
      <th v-for="item in colname">{{item}}</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="(items,index) in goods">
      <TableItem :items="items" :index="index"></TableItem>
    </tr>
    </tbody>
  </table>
</template>

<style scoped>

</style>