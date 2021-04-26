<template>
    <v-app id="app">
      <Navigator/>
     <v-main>
      <v-container fluid fill-height>
        <!--align-center-->
        <v-layout justify-center>
          <v-flex text-xs-center>
            <router-view />
          </v-flex>
        </v-layout>
      </v-container>
    </v-main>
    </v-app>
</template>

<script>
import Navigator from './components/Navigator.vue'
export default {
  components: {
    Navigator
  }
}
</script>
