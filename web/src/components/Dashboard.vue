<template>
  <v-card
    class="mx-auto"
    max-width="344"
    outlined
  >
    <v-list-item three-line>
      <v-list-item-content>
        <div class="overline mb-4">
          Hello
        </div>
        <v-list-item-title class="headline mb-1">
          {{user.username}}
        </v-list-item-title>
        <v-list-item-subtitle>Your role is {{ role }}</v-list-item-subtitle>
      </v-list-item-content>

    </v-list-item>

    <v-card-actions>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <v-btn
                outlined
                rounded
                text
                v-bind="attrs"
                v-on = "on">
                Display
            </v-btn>
          </template>
          <span>Allowed to</span>
        </v-tooltip>
         <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <v-btn
                v-if ="role === 'admin'"
                outlined
                rounded
                text
                v-bind="attrs"
                v-on = "on">
                Edit
            </v-btn>
          </template>
          <span>Allowed to</span>
        </v-tooltip>
    </v-card-actions>
  </v-card>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  computed: {
    ...mapGetters({
      authenticated: 'auth/authenticated',
      user: 'auth/user',
      role: 'auth/role'
    })
  }
}
</script>
