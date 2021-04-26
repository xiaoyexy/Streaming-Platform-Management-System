<template>
<div>
    <v-app-bar
      color="deep-purple accent-4"
      dense
      dark
    >
      <template v-if="authenticated">
        <v-app-bar-nav-icon  @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
        <v-toolbar-title>Streaming Wars</v-toolbar-title>
        <v-spacer></v-spacer>
        <!-- <li>
          <router-link :to="{
            name: 'dashboard'
          }"> Dashboard</router-link>
        </li> -->
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <v-btn icon
            v-on:click="signOut"
            v-bind="attrs"
            v-on = "on">
              Sign Out
            </v-btn>
          </template>
          <span>Sign Out</span>
        </v-tooltip>
        <!-- <li>
          <a href="#" @click.prevent="signOut"> Sign out</a>
        </li> -->
      </template>
      <template v-else>
        <v-toolbar-title>Streaming Wars</v-toolbar-title>
        <v-spacer></v-spacer>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <v-btn icon
            :to="{name: 'signin'}"
            v-bind="attrs"
            v-on = "on">
              Sign In
            </v-btn>
          </template>
          <span>Sign In</span>
        </v-tooltip>

      </template>

    </v-app-bar>
    <v-navigation-drawer
        v-model="drawer"
        app
        fixed
        :permanent="drawer"
      >
        <v-list
          dense
        >
          <v-list-item-group
            v-model="group"
            active-class="deep-purple--text text--accent-4"
          >
            <v-list-item link :to="{name: 'dashboard'}">
              <v-list-item-title>Profile</v-list-item-title>
            </v-list-item>

            <v-list-item link :to="{name: 'displays'}">
              <v-list-item-title>Display</v-list-item-title>
            </v-list-item>
            <v-list-group
              :value="true"
              v-if="role === 'admin'"
              no-action
              sub-group
            >
              <template v-slot:activator>
                <v-list-item-content>
                  <v-list-item-title>Edit</v-list-item-title>
                </v-list-item-content>
              </template>

              <v-list-item
                v-for="([title, url], i) in admins"
                :key="i"
                link
                :to="{name: url}"
              >
                <v-list-item-title v-text="title"></v-list-item-title>
              </v-list-item>
          </v-list-group>
            <!-- <v-list-item v-if="role === 'admin'" link :to="{name: 'edit'}">
              <v-list-item-title>Edit</v-list-item-title>
            </v-list-item> -->
          </v-list-item-group>
        </v-list>
      </v-navigation-drawer>
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
export default {
  data: () => ({
    drawer: false,
    group: null,
    admins: [
      ['Create', 'create'],
      ['Update', 'update'],
      ['Watch', 'watch'],
      ['Offer', 'offer']
    ]
  }),

  watch: {
    group () {
      this.drawer = false
    }
  },
  computed: {
    ...mapGetters({
      authenticated: 'auth/authenticated',
      user: 'auth/user',
      role: 'auth/role'
    })
  },

  methods: {
    ...mapActions({
      signOutAction: 'auth/signOut'
    }),
    signOut () {
      this.signOutAction().then(() => {
        this.$router.replace({
          name: 'home'
        })
      })
    }
  }
}
</script>
