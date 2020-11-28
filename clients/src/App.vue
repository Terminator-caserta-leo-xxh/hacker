<template>
  <div id="app">
<!--    <the-header></the-header>-->
<!--    <home></home>-->
    <router-view></router-view>
  </div>
</template>

<script>
// import TheHeader from './components/TheHeader'
// import LoginIn from "@/pages/LoginIn";
// import SignUpPage from "@/pages/SignUp";

// import TheHeader from "@/components/TheHeader";
// import Home from "@/pages/Home";

export default {
  name: 'App',
  components: {
    // Home,
    // TheHeader

  }
}
</script>

<style lang="scss" scoped>
@import "./assets/css/app.scss";
</style>
