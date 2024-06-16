import {reactive} from "vue";

const GoodStores=reactive({
    goods : [
        {date:'2024-05-03 16:01',phone:'123',bookid:11,name:'三体',price:25,photo:'https://git.acwing.com/litterdog/secondhands/-/raw/main/English4.jpg'},
        {date:'2024-05-03 16:01',phone:'123',bookid:2,name:'平凡的世界',price:100,photo:"https://git.acwing.com/litterdog/secondhands/-/raw/main/Database.jpg"},
        {date:'2024-05-03 16:01',phone:'123',bookid:3,name:'西游记',price:2,photo: ''},
        {date:'2024-05-03 16:01',phone:'123',bookid:4,name:'三国演义',price:225,photo: ''},
        {date:'2024-05-03 16:01',phone:'123',bookid:5,name:'红楼梦',price:25,photo: ''},
    ],

    // addGoods(item){
    //     // this.push(item)
    //     this.goods.push(item)
    // },
    // delGoods(index){
    //
    //     let total=this.goods.length
    //     for(let i=index;i<total;i++){
    //         this.goods[i]=this.goods[i+1]
    //     }
    //     this.goods.pop()
    //
    //
    // },
    // modifyGoods(item,index){
    //     this.goods[index]=item;
    // }
})


// 设计一些修改数据的方法
// 添加元素到末尾

// 根据位置删除元素

// let goodsInterface={
//     bookid:'',
//     name:'',
//     price:'',
//     photo:''
//
// }
const goodsInterface=reactive({
    bookid:'',
    name:'',
    price:'',
    photo:''
})
// const goodsColname=["photo", "bookid","name","price","edit"]
const FormGoodsName=["name","price","publishMan"]
export {GoodStores,goodsInterface}