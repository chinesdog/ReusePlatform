import {reactive} from "vue";
//查询wanted表
const ListCartStores=reactive({
    goods:[
        {date:'2024-05-03 16:01',bookid:1, name:'西游记', price:100,tag:'wait',phone:'12'},
        {date:'2024-05-04 14:04',bookid:2, name:'三国演义',price:100,tag:'accept',phone:'12'},
        {date:'2024-05-04 14:04',bookid:3, name:'红楼梦', price:20,tag:'reject',phone:'12'},
        {date:'2024-05-04 14:04',bookid:3, name:'红楼梦', price:20,tag:'offshlef',phone:'12'},
    ]
})
export {ListCartStores}
