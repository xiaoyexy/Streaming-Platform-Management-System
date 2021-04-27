<template>
<v-container>
  <form>
    <v-text-field
      v-model="form.groupShortName"
      label="Demographic Group"
       :rules="nameRules"
      required
    ></v-text-field>
    <v-text-field
      v-model="form.watchPercentage"
      label="Percentage of Group Watched the Event"
      :rules="nameRules"
      required
    ></v-text-field>
    <v-text-field
      v-model="form.streamShortName"
      label="streaming Service"
      :rules="nameRules"
      required
    ></v-text-field>
    <v-text-field
      v-model="form.eventYear"
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
  <v-row></v-row>
  <v-row></v-row>
  <v-row v-if="response">
      {{response.data }}
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
      groupShortName: '',
      watchPercentage: '',
      streamShortName: '',
      eventYear: '',
      eventName: ''
    }
  }),

  methods: {
    submit () {
      console.log(this.form)
      const url = '/api/watch_event'
      axios.post(url, this.form).then(
        res => {
          this.response = { data: res.config.data + 'submitted' }
        }
      ).catch(function (e) {
        console.log(e)
        alert('Failed')
      })
    }
  }
}
</script>
