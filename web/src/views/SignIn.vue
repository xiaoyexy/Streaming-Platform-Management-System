<template>
<v-container>
  <v-row> Users: </v-row>
  <v-row> Normal User -- Username: user, Password: User, Role: user</v-row>
  <v-row> Admin User  -- Username: admin, Password: admin, Role: admin</v-row>
  <v-row>
    <p>Note: In this case, a normal user can only view the displays while the admin user can
    also edit: create, update, retract, watch and offer </p>
  </v-row>
  <v-container>
  <form>
    <v-text-field
      v-model="form.username"
      :error-messages="usernameErrors"
      label="Name"
      required
      @input="$v.username.$touch()"
      @blur="$v.username.$touch()"
    ></v-text-field>
    <v-text-field
      v-model="form.password"
      :error-messages="passwordErrors"
      label="Password"
      required
      @input="$v.password.$touch()"
      @blur="$v.password.$touch()"
    ></v-text-field>
    <v-btn
      class="mr-4"
      @click="submit"
    >
      Log In
    </v-btn>
    <v-btn @click="clear">
      clear
    </v-btn>
  </form>
  </v-container>
  <v-spacer></v-spacer>
  <v-row></v-row>
  <v-row>
  </v-row>
</v-container>
</template>

<script>
import { mapActions } from 'vuex'
import { validationMixin } from 'vuelidate'
import { required } from 'vuelidate/lib/validators'

// import axios from 'axios'
export default {
  name: 'signin',
  mixins: [validationMixin],
  validations: {
    username: { required },
    password: { required }
  },
  components: {},

  data () {
    return {
      form: {
        username: '',
        password: ''
      }
    }
  },
  methods: {
    ...mapActions({
      signIn: 'auth/signIn'
    }),

    submit () {
      this.signIn(this.form).then(
        () => {
          this.$router.replace({
            name: 'dashboard'
          })
        }).catch(() => {
        console.log('failed')
      })
    },
    // submit () {
    //   this.$v.$touch()
    //   console.log(this.form)
    //   axios.post('/users/authenticate', this.form).then(response => {
    //     console.log(response)
    //   })
    // },
    clear () {
      this.$v.$reset()
      this.form.username = ''
      this.form.password = ''
    }
  },
  computed: {
    usernameErrors () {
      const errors = []
      if (!this.$v.username.$dirty) return errors
      !this.$v.username.required && errors.push('Name is required.')
      return errors
    },
    passwordErrors () {
      const errors = []
      if (!this.$v.password.$dirty) return errors
      !this.$v.password.required && errors.push('Password is required')
      return errors
    }
  }
}
</script>
