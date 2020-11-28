import Vue from 'vue'
import App from './App.vue'
import Router from 'vue-router'
import Vuex from 'vuex'
import ElementUI from 'element-ui'

Vue.config.productionTip = false

Vue.use(Router)
Vue.use(Vuex)
Vue.use(ElementUI)

new Vue({
  render: h => h(App),
}).$mount('#app')
