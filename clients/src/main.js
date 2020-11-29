import Vue from 'vue'
import App from './App.vue'
import Router from 'vue-router'
import router from "@/router";
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

Vue.use(Router)
 Vue.use(ElementUI)
// Vue.use(Vuex)

Vue.config.productionTip = false

new Vue({
    router: new Router(router),
    render: h => h(App),
}).$mount('#app')
