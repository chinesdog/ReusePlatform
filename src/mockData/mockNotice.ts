import {reactive} from "vue";

const NoticeStores=reactive({
    goods:[
        {date:'2024-05-02 16:01',bookid:123,name:'西游记',  phone:'123'},
        {date:'2024-05-03 16:01',bookid:111,name:'红楼梦',  phone:'234'},
        {date:'2024-05-04 16:01',bookid:2,name:'平凡的世界', phone:'234'},
    ]
})
export {NoticeStores}