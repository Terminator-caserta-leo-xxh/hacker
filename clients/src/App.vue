<template>
  <div id="app">
    <Home/>
  </div>
</template>

<script>
import Home from "@/pages/Home";

export default {
  name: 'App',
  components: {
    Home,
    //HelloWorld
  }
}
</script>

<style lang="scss" scoped>
@import "./assets/css/app.scss";
</style>
