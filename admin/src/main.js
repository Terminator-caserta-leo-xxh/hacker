import Vue from 'vue'
import App from './App.vue'
import Router from 'vue-router'
import ElementUI from 'element-ui'
import router from './router'
import 'element-ui/lib/theme-chalk/index.css'
import './assets/css/main.css'


Vue.use(Router)
Vue.use(ElementUI)


/* eslint-disable no-new */
new Vue({
  el: '#app',
  router: new Router(router),
  render: h => h(App)
})
