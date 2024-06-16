<script setup>

import GoodCard from "../Conponents/GoodCard.vue";
import {marketStore} from "../mockData/mockMarket.js";
import {onMounted} from "vue";
import axios from "axios";

onMounted(()=>{
  axios({
    method:'get',
    url:'http://localhost:8080/getbooks'

  }).then((res)=>{

    marketStore.goods=res.data
  })
})

</script>

<template>
  <div class="row" v-for="row in 3">
    <div class="col" v-for="col in 4">
      <template v-if="(row-1)*4+col-1<marketStore.goods.length">
        <GoodCard :goods="marketStore.goods[(row-1)*4+col-1]"></GoodCard>
      </template>
    </div>
  </div>
</template>

<style scoped>

</style>