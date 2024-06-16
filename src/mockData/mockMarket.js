import {reactive} from "vue";
//查询book表
const marketStore=reactive({
    goods:[

        {bookid:7, photo:'',name:'红楼梦',price:120,dealplace:'琴湖8栋',username:'jack',phone:'12'}

    ]
})
export {marketStore}