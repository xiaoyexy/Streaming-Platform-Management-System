import Vue from 'vue'
import Vuex from 'vuex'
import auth from './auth'
import time from './time'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
  },
  mutations: {
  },
  actions: {
  },
  modules: {
    auth,
    time
  }
})
