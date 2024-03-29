import Vue from 'vue'
import Vuex from 'vuex'
import App from './App.vue'
import './registerServiceWorker'
import router from './router'
import store from '@/store/index'

Vue.config.productionTip = false;
Vue.use(Vuex);

new Vue({
  router,
  store: store,
  render: h => h(App)
}).$mount('#app')
