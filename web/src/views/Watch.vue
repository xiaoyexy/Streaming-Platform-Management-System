<template>
<v-container>
  <form>
    <v-text-field
      v-model="form.demographicGroup"
      label="Demographic Group"
       :rules="nameRules"
      required
    ></v-text-field>
    <v-text-field
      v-model="form.percentage"
      label="Percentage of Group Watched the Event"
      :rules="nameRules"
      required
    ></v-text-field>
    <v-text-field
      v-model="form.streamingService"
      label="streaming Service"
      :rules="nameRules"
      required
    ></v-text-field>
    <v-text-field
      v-model="form.yearProduced"
      label="Year Event Produced"
      :rules="nameRules"
      required
    ></v-text-field>
    <v-text-field
      v-model="form.eventName"
      label="Event Name"
      :rules="nameRules"
      required
    ></v-text-field>

    <v-btn
      class="mr-4"
      @click="submit"
    >
      submit
    </v-btn>
    <v-btn @click="clear">
      clear
    </v-btn>
  </form>
  <v-row v-if="response">
      {{response}}
  </v-row>
</v-container>
</template>

<script>
import axios from 'axios'
export default {
  data: () => ({
    response: '',
    nameRules: [
      v => !!v || 'Required'
    ],
    form: {
      demographicGroup: '',
      percentage: '',
      streamingService: '',
      yearProduced: '',
      eventName: ''
    }
  }),

  methods: {
    submit () {
      console.log(this.form)
      const url = '/api/watch_event'
      axios.post(url, this.form).then(
        res => {
          this.response = res
        }
      )
    },
    clear () {
      this.name = ''
      this.email = ''
      this.select = null
      this.checkbox = false
    }
  }
}
</script>
