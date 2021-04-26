import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
import Vuelidate from 'vuelidate'
import axios from 'axios'
import '@/utils/configuration'
import VueIframe from 'vue-iframes'

axios.defaults.baseURL = 'http://localhost:8080'
Vue.config.productionTip = false

store.dispatch('auth/attempt', [JSON.parse(localStorage.getItem('currentUser'))])

Vue.use(Vuelidate)
Vue.use(VueIframe)
new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
