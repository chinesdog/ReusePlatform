import {reactive} from "vue";

const allUserStores=reactive({
    users:[
        {userid:1,name:'123',username:'jack',liveplace:'琴湖', dealplace:'琴湖'},
        {userid:2,name:'123',username:'mary',liveplace:'琴湖', dealplace:'琴湖'},
        {userid:3,name:'123',username:'zhuli',liveplace:'琴湖', dealplace:'琴湖'},
        {userid:4,name:'123',username:'hah',liveplace:'琴湖', dealplace:'琴湖'}
    ]
})
export {allUserStores}