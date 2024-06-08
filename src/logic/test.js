import {goods} from "./GoodsData.js";

function test(){
    let good=goods
    good.sort(function (a,b){
        if(a.price>b.price)return 1;
        return -1;
    })
    console.log(good)
}

export {test}