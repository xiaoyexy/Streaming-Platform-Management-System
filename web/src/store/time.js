import axios from 'axios'

export default {
  namespaced: true,
  state: {
    year: null,
    month: null
  },

  getters: {
    year (state) {
      return state.year
    },
    month (state) {
      return state.month
    }
  },

  mutations: {
    SET_TIME (state, dataList) {
      if (dataList.length < 3) {
        state.year = null
        state.month = null
      } else {
        state.year = dataList[2]
        state.month = dataList[1]
      }
    }
  },
  actions: {
    async setTime ({ commit }) {
      const response = await axios.post('/api/display_time', {})
      commit('SET_TIME', response.data.split(','))
    },

    async nextMonth ({ dispatch }) {
      await axios.post('/api/next_month', {})
      dispatch('setTime')
    }
  }
}
