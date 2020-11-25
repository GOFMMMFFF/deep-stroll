import Vue from 'vue'
import Router from 'vue-router'
import index from '../controllers/index'
import Article from '../controllers/Article'
import mine from '../controllers/mine'
import drawings from '../controllers/drawings'
import ArticleDetails from "../controllers/ArticleDetails";
import EditInformation from "../controllers/EditInformation";
import Release from "../controllers/Release";

Vue.use(Router)

export default new Router({
  mode: 'history',
  linkActiveClass: 'active',
  routes: [
    {
      path: '/',
      component: index,
      meta: {
        title: '主页',
        keepAlive:false,
      }
    },
    {
      path: '/article',
      component: Article,
      meta: {
        title: '文章',
        requireAuth: true,
        keepAlive:true,
      }
    },
    {
      path: '/articleDetails',
      component: ArticleDetails,
      meta: {
        title: '文章详情',
        requireAuth: true,
        keepAlive:true,
      }
    },
    {
      path: '/drawings',
      component: drawings,
      meta: {
        title: '手绘',
        requireAuth: true,
        keepAlive:true,
      }
    },
    {
      path: '/mine',
      component: mine,
      meta: {
        title: '我的',
        requireAuth: true,
        keepAlive:true,
      }
    },
    {
      path: '/editInformation',
      component: EditInformation,
      meta: {
        title: '信息编辑',
        requireAuth: true,
        keepAlive:true,
      }
    },
    {
      path: '/release',
      component: Release,
      meta: {
        title: '发布',
        requireAuth: true,
        keepAlive:true,
      }
    },
  ]
})