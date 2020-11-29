<template>
<div class="signUp-page">
  <loginLogo/>
  <div class="signUp">
    <div class="signUp-head">
      <span>用户注册</span>
    </div>
    <el-form :model="registerForm" status-icon :rules="rules" ref="registerForm" label-width="70px" class="demo-ruleForm">
      <el-form-item prop="username" label="用户名">
        <el-input v-model="registerForm.username" placeholder="用户名"></el-input>
      </el-form-item>
      <el-form-item prop="password" label="密码">
        <el-input type="password" placeholder="密码" v-model="registerForm.password"></el-input>
      </el-form-item>
      <div class="login-btn">
        <el-button @click="goback(-1)">取消</el-button>
        <el-button type="primary" @click="SignUp">确定</el-button>
      </div>
    </el-form>
  </div>
</div>
</template>

<script>
import loginLogo from '../components/LoginLogo'
import { rules } from '@/assets/data/form'
import { register } from '../api/index'

export default {
  name: 'SignUp-page',
  components: {
    loginLogo
  },
  data () {
    return {
      registerForm: { // 注册
        username: '',
        password: '',
      },
      rules: {},
    }
  },
  created () {
    this.rules = rules
  },
  methods: {
    SignUp () {
      let _this = this
      let params = new URLSearchParams()
      params.append('username', this.registerForm.username)
      params.append('password', this.registerForm.password)
      params.append('avator', '/img/user.jpg')
      register(params)
        .then(res => {
          console.log(res)
          if (res.code === 0) {
            _this.notify('注册成功', 'success')
            setTimeout(function () {
              _this.$router.push({path: '/'})
            }, 2000)
          } else {
            _this.notify('注册失败', 'error')
          }
        })
        .catch(err => {
          console.log(err)
        })
    },
    goback (index) {
      this.$router.go(index)
    }
  }
}
</script>

<style lang="scss" scoped>
@import '../assets/css/sign-up.scss';
</style>
