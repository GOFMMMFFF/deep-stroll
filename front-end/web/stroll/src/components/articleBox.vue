<template>
  <ul id="articleUl">
    <li class="articleBox" @click="focus(item)" v-for="(item,index) in articleList.slice(0,len)" :key="index">
      <img :src = "item.cover" class = "articleCover"/>
      <h3 class="articleTitle">{{item.title}}</h3>
      <div class="articleMsg">
        <div class="msgLeft">
          <img :src = "item.avatar" class="authorAvatar"/>
          <span class="authorName">{{item.nickname}}</span>
          <span class="articleTime">{{item.dateTime}}</span>
        </div>
      </div>
      <div class="msgRight">
        <span>{{item.likeNum}}</span>
        <img src = "../assets/icon/notLike.png" class="icon"/>
        <span>{{item.comment}}</span>
        <img src = "../assets/icon/comment.png" class="icon"/>
      </div>
    </li>
  </ul>
</template>

<script>
  export default {
    name: "articleBox",
    data () {
      return {
        len: 10,
        deleteID:0,
      }
    },
    // 拿到从父组件传来的值，动态更新子组件的信息，重复利用
    props:[
      'articleList',
      // 传值来的父组件，articleDetails返回跳转时用
      'page'
    ],
    methods: {
      focus:function (item) {
        // console.log("item.id: "+item.id);
        // console.log(this.page);
        this.$router.push({
          path:'/articleDetails',
          query: {
            id:item.id,
            backpage:this.page
          },
          // query:{
          //   articleMsg:JSON.stringify(item),
          //   backpage:this.page
          // }
        })
      },
    },
    created() {
      // this.$set(this.articleList);
      // console.log("zujian : "+this.articleList[0].id)
    },
    watch:{
      articleList: {
        handler(newval, old) {
        },
        immediate: true,
        deep: true,
      }
    }
  }
</script>

<style scoped>
  ul{
    padding-left: 0;
  }
  .articleBox{
    height: 100px;
    width:95%;
    position: relative;
    /*background: #fff;*/
    background-color: #ffffffa8;
    box-shadow: 1px 3px 10px #65626285;
    cursor: pointer;
    list-style-type: none;
    margin: 45px auto;
    -webkit-transition-duration: 1s;
  }
  .articleBox:hover{
    height: 120px;
  }
  .articleCover{
    height: 100%;
    /*margin-left: 5px;*/
  }
  .articleTitle{
    display: inline-block;
    position: absolute;
    top: 10%;
    width: 80%;
    height: 29%;
    overflow: hidden;
    margin: 0;
    margin-left: 10px;
  }
  .articleMsg{
    width: 75%;
    height: 30%;
    display: inline-block;
    position: absolute;
    bottom: 5%;
    margin-left: 10px;
  }
  .msgLeft{
    float: left;
  }
  .authorAvatar{
    width: 25px;
    height: 25px;
    border-radius: 100%;
  }
  .articleTime{
    margin-left: 10px;
  }
  .msgRight{
    position:absolute;
    right:10px;
    bottom:10px;
  }
  .icon{
    width: 17px;
    height: 17px;
    margin-bottom: -3px;
  }
</style>
