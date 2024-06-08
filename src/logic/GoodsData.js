import {reactive} from "vue";

const GoodStores=reactive({
    goods : [
        {name:'三体',price:25,publishMan:'Jack'},
        {name:'平凡的世界',price:100,publishMan:'Mary'},
        {name:'西游记',price:2,publishMan:'Tang'},
        {name:'三国演义',price:225,publishMan:'Jack'},
        {name:'红楼梦',price:25,publishMan:'Tang'},
    ],
    addGoods(item){
        // this.push(item)
        this.goods.push(item)
    },
    delGoods(index){

        let total=this.goods.length
        for(let i=index;i<total;i++){
            this.goods[i]=this.goods[i+1]
        }
        this.goods.pop()


    },
    modifyGoods(item,index){
        this.goods[index]=item;
    }
})


// 设计一些修改数据的方法
// 添加元素到末尾

// 根据位置删除元素



const goodsColname=["name","price","publishMan","edit"]
const FormGoodsName=["name","price","publishMan"]
export {goodsColname,FormGoodsName,GoodStores}