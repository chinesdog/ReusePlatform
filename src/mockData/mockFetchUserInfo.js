import {reactive} from "vue";
//查询user表
const UserStores=reactive({
    UserInfo:{
        userid:1,
        name:'jack',
        username:'jack',
        liveplace:'琴湖',
        dealplace:'琴湖',
        phone:'12345'
    }
})
export {UserStores}