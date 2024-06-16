import { createApp } from 'vue'
import App from './App.vue'
import { createRouter, createWebHistory } from 'vue-router'
import 'bootstrap/dist/css/bootstrap.css'
import 'element-plus/dist/index.css'
import ElementPlus from 'element-plus'


import LoginPage from "./pages/LoginPage.vue";
import PostGoodsPage from "./pages/PostedPage.vue";
import MySecond from "./pages/MySecond.vue";
import MarketPage from "./pages/MarketPage.vue";
import CenterPage from "./pages/CenterPage.vue";
import GoodsForm from "./Conponents/GoodsForm.vue";
import PostedPage from "./pages/PostedPage.vue";
import WantedSeconds from "./pages/WantedSeconds.vue";
import NoticePage from "./pages/NoticePage.vue";
import RegisterPage from "./pages/RegisterPage.vue";
import UserManagerPage from "./pageForManager/UserManagerPage.vue";
import IssueItemPage from "./pageForManager/IssueItemPage.vue";
import GoodsManagerPage from "./pageForManager/GoodsManagerPage.vue";


const routes=[
    {path: '/',component:LoginPage},
    {path:'/PostGoods',component:PostedPage},
    {path: '/MySeconds',component: MySecond},
    {path: '/Market',component: MarketPage},
    {path: '/Center',component: CenterPage},
    {path: '/GoodsForm',component: GoodsForm},
    {path: '/WantedSeconds',component: WantedSeconds},
    {path: '/Notice',component: NoticePage},
    {path: '/Register',component: RegisterPage},
    {path: '/UserManage',component:UserManagerPage },
    {path: '/IssueItem',component:IssueItemPage },
    {path: '/GoodsManage',component:GoodsManagerPage }
]

let Route=createRouter({
    history:createWebHistory(),
    routes
})

const app=createApp(App)
app.use(Route)
app.use(ElementPlus)
app.mount('#app')

