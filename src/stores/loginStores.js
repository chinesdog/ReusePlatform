import {reactive} from "vue";

const loginStores=reactive({
    username:'',
    password:'',
    role:'',
    userid:0,
    storeinfo(username,password,role){
        this.role=role
        this.username=username
        this.password=password
    }

})
export {loginStores}
//manager or user