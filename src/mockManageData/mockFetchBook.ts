import {reactive} from "vue";

const booksStores=reactive({
    goods:[
        {bookid:1, date:'2024-05-03 16:01',photo:'https://git.acwing.com/litterdog/secondhands/-/raw/main/Computer.jpg',name:'计算机组成与原理', price:12,Username:'jack'},
        {bookid:2, date:'2024-05-03 16:01',photo:'https://git.acwing.com/litterdog/secondhands/-/raw/main/English4.jpg',name:'英语四级', price:12,Username:'jack'},
        {bookid:3, date:'2024-05-03 16:01',photo:'',name:'红楼梦',price:122,Username:'jack'},
        {bookid:4, date:'2024-05-03 16:01',photo:'',name:'红楼梦',price:1,  Username:'jack'},
        {bookid:5, date:'2024-05-03 16:01',photo:'',name:'红楼梦',price:17, Username:'jack'},
        {bookid:6, date:'2024-05-03 16:01',photo:'',name:'红楼梦',price:21, Username:'jack'},
        {bookid:7, date:'2024-05-03 16:01',photo:'',name:'红楼梦',price:120,Username:'jack'},
    ]
})
export {booksStores}