import Vue from 'vue'
import App from './App.vue'
import Router from 'vue-router'
import ElementUI from 'element-ui'


Vue.use(Router)
Vue.use(ElementUI)


Vue.config.productionTip = false

new Vue({
  render: h => h(App),
}).$mount('#app')
