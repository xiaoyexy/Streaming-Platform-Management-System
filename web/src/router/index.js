// import Vue from 'vue'
// import VueRouter from 'vue-router'
// import Home from '../views/Home.vue'

// Vue.use(VueRouter)

// const routes = [
//   {
//     path: '/',
//     name: 'Home',
//     component: Home
//   }
// ]

// const router = new VueRouter({
//   mode: 'history',
//   base: process.env.BASE_URL,
//   routes
// })

// export default router

import Vue from 'vue'
import Router from 'vue-router'

// import { authenticationService } from '@/_services'
// import { Role } from '@/_helpers'
import HomePage from '@/views/Homepage'
// import AdminPage from '@/views/admin/AdminPage'
import SignIn from '../views/SignIn.vue'

// import LoginPage from '@/views/login/LoginPage'
import Dashboard from '../views/Dashboard.vue'
import Watch from '../views/Watch.vue'
import Offer from '@/views/Offer'
import store from '@/store'
import Display from '@/views/Display'
import Create from '@/views/Create'
import Update from '@/views/Update'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      component: HomePage,
      meta: { authorize: [] }
    },
    {
      path: '/home',
      name: 'home',
      component: HomePage
    },
    {
      path: '/displays',
      name: 'displays',
      component: Display,
      beforeEnter: (to, from, next) => {
        if (!store.getters['auth/authenticated']) {
          return next({
            name: 'signin'
          })
        }

        next()
      }
    },
    {
      path: '/create',
      name: 'create',
      component: Create
    },
    {
      path: '/update',
      name: 'update',
      component: Update
    },
    {
      path: '/signin',
      name: 'signin',
      component: SignIn
      // meta: { authorize: [Role.Admin] }
    },
    {
      path: '/dashboard',
      name: 'dashboard',
      component: Dashboard,
      beforeEnter: (to, from, next) => {
        if (!store.getters['auth/authenticated']) {
          return next({
            name: 'signin'
          })
        }

        next()
      }
    },
    {
      path: '/watch',
      name: 'watch',
      component: Watch
    },
    {
      path: '/offer',
      name: 'offer',
      component: Offer
    },

    // otherwise redirect to home
    { path: '*', redirect: '/' }
  ]
})

// router.beforeEach((to, from, next) => {
//   // redirect to login page if not logged in and trying to access a restricted page
//   const { authorize } = to.meta
//   const currentUser = authenticationService.currentUserValue

//   if (authorize) {
//     if (!currentUser) {
//       // not logged in so redirect to login page with the return url
//       return next({ path: '/signin', query: { returnUrl: to.path } })
//     }

//     // check if route is restricted by role
//     if (authorize.length && !authorize.includes(currentUser.role)) {
//       // role not authorised so redirect to home page
//       return next({ path: '/' })
//     }
//   }

//   next()
// })

export default router
