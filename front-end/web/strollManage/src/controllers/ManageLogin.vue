<template>
  <el-card class="loginBox">
    <el-form ref="form" :model="form" :rules="rules" label-width="40px">
      <div>
        <el-form-item label="账号">
          <el-input v-model="form.account" placeholder="请输入账号"></el-input>
        </el-form-item>
      </div>
      <div>
        <el-form-item label="密码">
          <el-input type="password" v-model="form.password" placeholder="请输入密码"></el-input>
        </el-form-item>
      </div>
    </el-form>
    <div style="display: flex;justify-content: center;">
      <el-button class="loginbtn" type="primary" @click="onSubmit" @keyup.enter.native="onSubmit">
        <i class="el-icon-loading" v-if="loading"></i>
        登录</el-button>
    </div>
  </el-card>
</template>

<script>
export default {
  data(){
    return{
      form:{
        password:'',
        account:''
      },
      loading: false,
      rules:{},
      routes:[],
    }
  },
  methods:{
    onSubmit(){
      let _this = this
      this.$http.post('/api/admin/login',{
        password:this.form.password,
        account:this.form.account
      }).then(res => {
        if (res.result.code === 1){
          console.log(res)
          _this.routes = res.data.menu
          sessionStorage.setItem('managetoken',res.data.token)
          _this.setroute()
          _this.$message.success('登录成功')
        }
      }).catch(err =>{})
    },
    setroute(){
      // let route=[
      //   {
      //     id:0,
      //     path:'/ManageRights',
      //     name:'权限管理'
      //   },
      //   {
      //     id:1,
      //     path:'/ManageUsers',
      //     name:'用户管理'
      //   },
      //   {
      //     id:2,
      //     path:'/ManageWork',
      //     name:'作品管理',
      //     sonMenu:[
      //       {
      //         path:'/ManageArticles',
      //         name:'文章管理',
      //       },
      //       {
      //         path:'/ManageDrawings',
      //         name:'手绘管理',
      //       },
      //       {
      //         path:'/ManageClassifys',
      //         name:'分类管理',
      //       },
      //       {
      //         path:'/ManageLabels',
      //         name:'标签管理',
      //       },
      //     ]
      //   },
      //   {
      //     id:3,
      //     path:'/Managethemes',
      //     name:'主题管理'
      //   },
      //   {
      //     id:4,
      //     path:'/ManageFunctions',
      //     name:'功能管理'
      //   },
      //   {
      //     id:5,
      //     path:'/ManageLogs',
      //     name:'查看日志'
      //   },
      // ]
      this.$emit('onSetRoute', this.routes);
    }
  }
}
</script>

<style scoped>
  .loginBox{
    width:400px;
    height:180px;
    margin: 100px auto;
  }


  .loginbtn {
    width: 200px;
    background-color: #01419b;
    border-color: #01419b;
  }

  .disf {
    display: flex;
    flex-flow: row nowrap;
    justify-content: center;

  }
</style>
