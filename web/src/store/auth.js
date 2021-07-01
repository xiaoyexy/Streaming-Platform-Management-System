/* eslint-disable prefer-const */
// import axios from 'axios'

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
      // let response = await axios.post('/users/authenticate', credentials)
      let response = { data: null }
      console.log(credentials)
      if (credentials.username === 'user' && credentials.password === 'user') {
        response = { data: [{ id: 1, username: 'user', password: 'user', firstname: 'Normal', lastname: 'User', role: 'user' }] }
      } else if (credentials.username === 'admin' && credentials.password === 'admin') {
        response = { data: [{ id: 2, username: 'admin', password: 'admin', firstname: 'Admin', lastname: 'Super', role: 'admin' }] }
      }

      if (response.data !== null || response.data.length === 1) {
        localStorage.setItem('currentUser', JSON.stringify(response.data[0]))
      }
      return dispatch('attempt', response.data)
    },
    async attempt ({ commit }, signin) {
      commit('SET_SIGNIN', signin)
    },

    async signOut ({ commit }) {
      commit('SET_SIGNIN', null)
      localStorage.removeItem('currentUser')
    }
  }
}
