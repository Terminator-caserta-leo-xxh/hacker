<template>
  <div class="header">
    <!-- 折叠按钮 -->
    <div class="collapse-btn" @click="collapseChange">
      <i class="el-icon-s-unfold"></i>
    </div>
    <div class="logo">食堂预约系统</div>
    <div class="header-right">
      <div class="header-user-con">
        <!-- 用户名下拉菜单 -->
        <el-dropdown class="user-name" trigger="click" @command="handleCommand">
          <span class="el-dropdown-link">
            {{username}}
            <i class="el-icon-caret-bottom"></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item command="logout">退出登录</el-dropdown-item>
            <el-dropdown-item command="modifyPwd">修改密码</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <!--弹出修改密码框-->
        <el-dialog title="修改密码" :visible.sync="editPwd" width="400px">
          <el-form ref="ruleForm" :model="ruleForm" label-width="60px">
            <el-form-item label="原密码" size="small">
              <el-input v-model="ruleForm.oldPassword"></el-input>
            </el-form-item>
            <el-form-item label="新密码" size="small">
              <el-input v-model="ruleForm.newPassword"></el-input>
            </el-form-item>
          </el-form>
          <span slot="footer" class="dialog-footer">
        <el-button size="mini" @click="editPwd = false">取 消</el-button>
        <el-button type="primary" size="mini" @click="saveEdit">确 定</el-button>
      </span>
        </el-dialog>
      </div>
    </div>
    <ul class="navbar" ref="change">
      <li :class="{active: item.name === activeName}" v-for="item in navMsg" :key="item.path" @click="goPage(item.path, item.name)">
        {{item.name}}
      </li>
      <li>
        <div class="header-search">
          <input type="text" placeholder="搜索店铺" @keyup.enter="goSearch()" v-model="keywords">
          <div class="search-btn"  @click="goSearch()" >
            <svg class="icon" aria-hidden="true">
              <use xlink:href="#icon-sousuo"></use>
            </svg>
          </div>
        </div>
      </li>
      <li v-show="!loginIn" :class="{active: item.name === activeName}" v-for="item in loginMsg" :key="item.type" @click="goPage(item.path, item.name)">{{item.name}}</li>
    </ul>
  </div>
</template>

<script>
import _ctrEvent from '../assets/js/ctr-event'
import {modifyAdminPwd} from "@/api";
export default {
  name: "TheHeader",
  data (){
    return{
      ruleForm: {
        oldPassword: '',
        newPassword: ''
      },
      rules: {
        oldPassword: [
          { required: true, trigger: 'blur' }
        ],
        newPassword: [
          { required: true, trigger: 'blur' }
        ]
      },
      collapse: true,
      fullscreen: false,
      username: 'admin',
      editPwd:false
    }
  },
  mounted() {
    if (document.body.clientWidth < 1500){
      this.collapseChange()
    }
  },
  methods: {
    handleCommand (command) {
      if(command === 'logout') {
        this.$router.push('/')
      }
      if (command === 'modifyPwd') {
        this.editPwd = true
      }
    },
    //侧边栏折叠
    collapseChange () {
      this.collapse = !this.collapse
      _ctrEvent.$emit('collapse',this.collapse)
    },
    saveEdit() {
      let params = new URLSearchParams()
      params.append("password",this.newPassword)
      modifyAdminPwd(params).then(res => {
        if (res.code === 0) {
          this.getData()
          this.notify('修改成功', 'success')
        } else {
          this.notify('修改失败', 'error')
        }
      }).catch(err => {
        console.log(err)
      })
      this.editVisible = false
    }
  }
}
</script>

<style scoped>
.header {
  position: absolute;
  z-index: 100;
  box-sizing: border-box;
  width: 100%;
  height: 70px;
  font-size: 22px;
  color: #B0B3B2;
  background: #1A1B1C;
  box-shadow: 0 0 8px 2px rgba(0, 0, 0, 0.3);
}
.collapse-btn {
  float: left;
  padding: 0 21px;
  cursor: pointer;
  line-height: 70px;
}
.header .logo {
  float: left;
  width: 250px;
  line-height: 70px;
}
.header-right {
  float: right;
  padding-right: 50px;
}
.header-user-con {
  display: flex;
  height: 70px;
  align-items: center;
}
.user-name {
  margin-left: 10px;
}
.user-avator {
  margin-left: 20px;
}
.user-avator img {
  display: block;
  width: 40px;
  height: 40px;
  border-radius: 50%;
}
.el-dropdown-link {
  color: #B0B3B2;
  cursor: pointer;
}
.el-dropdown-menu__item {
  text-align: center;
}
</style>
