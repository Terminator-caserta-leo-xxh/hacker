<template>
  <div class="home">
    <!--菜品展示-->
    <swiper :swiperList="swiperList"/>
    <div>
      测试
    </div>
  </div>
</template>

<script>
import Swiper from '@/components/Swiper';
import {swiperList} from '@/assets/data/swiper';

export default {
name: "home",
  components: {Swiper},
  data (){
    return{
        swiperList: [],
    }
  },
  created() {
    this.swiperList = swiperList
  },

}
</script>

<style scoped>
@import "../assets/css/home.scss";
</style>
