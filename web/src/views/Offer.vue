<template>
    <v-container>
        <v-row>
    <v-col cols="6">
        <v-subheader>
          Select the type
        </v-subheader>
      </v-col>

      <v-col cols="6">
        <v-select
          v-model="select"
          :hint="`${select.state}`"
          :items="items"
          item-text="state"
          item-value="abbr"
          label="Select"
          persistent-hint
          return-object
          single-line
        ></v-select>
      </v-col>
    </v-row>
     <v-row v-if= " select.state=== 'Movie'" >
        <v-text-field
                v-model= select.requirements.streamShortName
                :rules="nameRules"
                :counter="20"
                label= streamShortName
                required
            ></v-text-field>
            <v-text-field
                v-model= select.requirements.eventName
                :rules="nameRules"
                :counter="20"
                label= eventName
                required
            ></v-text-field>
            <v-text-field
                v-model= select.requirements.eventYear
                :rules="nameRules"
                :counter="20"
                label= eventYear
                required
            ></v-text-field>
    </v-row>
    <v-row v-if= " select.state=== 'Pay Per View'" >
        <v-text-field
                v-model= select.requirements.streamShortName
                :rules="nameRules"
                :counter="20"
                label= streamShortName
                required
            ></v-text-field>
            <v-text-field
                v-model= select.requirements.eventName
                :rules="nameRules"
                :counter="20"
                label= eventName
                required
            ></v-text-field>
            <v-text-field
                v-model= select.requirements.eventYear
                :rules="nameRules"
                :counter="20"
                label= eventYear
                required
            ></v-text-field>
            <v-text-field
                v-model= select.requirements.viewingPrice
                :rules="nameRules"
                :counter="20"
                label= viewingPrice
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
        {{ response.data }}
    </v-row>
    </v-container>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      response: '',
      nameRules: [
        v => !!v || 'Required'
      ],
      select: {
        state: 'Movie',
        url: '/api/offer_movie',
        requirements: { streamShortName: '', eventName: '', eventYear: '' }
      },
      items: [
        {
          state: 'Movie',
          url: '/api/offer_movie',
          requirements: { streamShortName: '', eventName: '', eventYear: '' }
        },
        {
          state: 'Pay Per View',
          url: '/api/offer_ppv',
          requirements: { streamShortName: '', eventName: '', eventYear: '', viewingPrice: '' }
        }
      ]
    }
  },
  methods: {
    submit () {
      console.log(this.select)
      const payload = this.select.requirements
      const url = this.select.url
      axios.post(url, payload).then(res => {
        this.response = { data: res.config.data + 'created' }
      }).catch(
        function (e) {
          console.log(e)
          alert('Failed')
        }
      )
    }
  }
}
</script>
