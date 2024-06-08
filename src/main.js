import { createApp } from 'vue'
import App from './App.vue'
import { createRouter, createWebHistory } from 'vue-router'
import 'bootstrap/dist/css/bootstrap.css'
import 'element-plus/dist/index.css'
import ElementPlus from 'element-plus'


import LoginPage from "./pages/LoginPage.vue";
import PostGoodsPage from "./pages/PostGoodsPage.vue";
import MySecond from "./pages/MySecond.vue";
import MarketPage from "./pages/MarketPage.vue";
import CenterPage from "./pages/CenterPage.vue";
import GoodsForm from "./Conponents/GoodsForm.vue";
import BlankPage from "./Utils/ReturnMySeconds.vue";




const routes=[
    {path: '/',component: LoginPage},
    {path:'/PostGoods',component:PostGoodsPage},
    {path: '/MySeconds',component: MySecond},
    {path: '/Market',component: MarketPage},
    {path: '/Center',component: CenterPage},
    {path: '/GoodsForm',component: GoodsForm},
    {path:'/Blank',component: BlankPage}
]

let Route=createRouter({
    history:createWebHistory(),
    routes
})

const app=createApp(App)
app.use(Route)
app.use(ElementPlus)
app.mount('#app')

