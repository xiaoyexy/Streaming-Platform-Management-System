/* eslint-disable prefer-const */
import axios from 'axios'

export default {
  namespaced: true,
  state: {
    issignedIn: false,
    user: null,
    role: null
  },

  getters: {
    authenticated (state) {
      return state.issignedIn
    },
    user (state) {
      return state.user
    },
    role (state) {
      return state.role
    }
  },

  mutations: {
    SET_SIGNIN (state, signin) {
      if (signin === null || signin.length === 0) {
        state.issignedIn = false
        state.user = null
        state.role = null
      } else {
        if (signin[0] === null) {
          state.issignedIn = false
          state.user = null
          state.role = null
        } else {
          state.issignedIn = true
          state.user = signin[0]
          state.role = state.user.role
        }
      }
    }
  },
  actions: {
    async signIn ({ dispatch }, credentials) {
      let response = await axios.post('/users/authenticate', credentials)
      //   console.log(response)
      // console.log(response.data)
      if (response.data !== null || response.data.length === 1) {
        // console.log(typeof (response.data[0]))
        // console.log(response.data[0])
        localStorage.setItem('currentUser', JSON.stringify(response.data[0]))
      }
      return dispatch('attempt', response.data)
    },
    async attempt ({ commit }, signin) {
      commit('SET_SIGNIN', signin)
    },

    signOut ({ commit }) {
      commit('SET_SIGNIN', null)
      localStorage.removeItem('currentUser')
    }
  }
}
