<template>
  <div>
    <!--菜品展示-->
    <swiper :swiperList="swiperList"/>
  </div>
</template>

<script>
import Swiper from "@/components/Swiper";
import {swiperList} from '@/assets/data/swiper';

export default {
name: "Home",
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

</style>
