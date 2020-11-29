<template>
  <div class="info">
    <p class="title">编辑个人资料</p>
    <hr/>
    <div class="personal">
      <el-form :model="registerForm" class="demo-ruleForm" label-width="80px">
        <el-form-item prop="username" label="用户名">
          <el-input v-model="registerForm.username" placeholder="用户名"></el-input>
        </el-form-item>
        <el-form-item prop="password" label="密码">
          <el-input type="password" placeholder="密码" v-model="registerForm.password"></el-input>
        </el-form-item>
      </el-form>
    <div class="btn">
      <div @click="saveMsg()">保存</div>
      <div @click="goback">取消</div>
    </div>
    </div>
</div>
</template>

<script>
import { mapGetters } from 'vuex'
import { updateUserData, getUserData } from '../api/index'

export default {
  name: 'info',
  data: function () {
    return {
      registerForm: { // 注册
        username: '',
        password: '',
      },
    }
  },
  computed: {
    ...mapGetters([
      'userId'
    ])
  },
  mounted () {
    this.getMsg(this.userId)
  },
  methods: {
    getMsg (id) {
      getUserData(id)
        .then(res => {
          this.registerForm.username = res[0].username
          this.registerForm.password = res[0].password
          this.registerForm.avator = res[0].avator
        })
        .catch(err => {
          console.log(err)
        })
    },
    goback () {
      this.$router.go(-1)
    },
    saveMsg () {
      let params = new URLSearchParams()
      params.append('id', this.userId)
      params.append('username', this.registerForm.username)
      params.append('password', this.registerForm.password)
      updateUserData(params)
        .then(res => {
          if (res.code === 1) {
            this.showError = false
            this.showSuccess = true
            this.$store.commit('setUsername', this.registerForm.username)
            this.$notify.success({
              title: '编辑成功',
              showClose: true
            })
            setTimeout(function () {
              this.$router.go(-1)
            }, 2000)
          } else {
            this.showSuccess = false
            this.showError = true
            this.$notify.error({
              title: '编辑失败',
              showClose: true
            })
          }
        })
        .catch(err => {
          console.log(err)
        })
    }
  }
}
</script>

<style lang="scss" scoped>
@import '../assets/css/info.scss';
</style>
