<template>
<v-container>
    <h1>Retract Movie</h1>
    <v-row >
        <v-text-field
                v-model= form.streamShortName
                :rules="nameRules"
                :counter="10"
                label= "streaming service"
                required
            ></v-text-field>
            <v-text-field
                v-model= form.eventYear
                :rules="nameRules"
                :counter="10"
                label= "movie year"
                required
            ></v-text-field>
            <v-text-field
                v-model= form.eventName
                :rules="nameRules"
                :counter="10"
                label= "movie name"
                required
            ></v-text-field>
    </v-row>
    <v-row>
        <v-btn
      class="mr-4"
      @click="submit"
    >
      submit
    </v-btn>
    </v-row>
     <v-row v-if="response">
        {{ response }}
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
      streamShortName: '',
      eventYear: '',
      eventName: ''
    }
  }),

  methods: {
    submit () {
      console.log(this.form)
      const url = '/api/retract_movie'
      axios.post(url, this.form).then(
        res => {
          this.response = res.config.data + 'retracted'
        }
      ).catch(function (e) {
        console.log(e)
        alert('Failed')
      })
    }
  }
}
</script>
