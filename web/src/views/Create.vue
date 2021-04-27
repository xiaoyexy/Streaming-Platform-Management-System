<template>
<v-container>
    <v-row>
    <v-col cols="6">
        <v-subheader>
          Select to create
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
    <v-row v-if= " select.state=== 'Demographic Group'" >
        <v-text-field
                v-model= select.requirements.shortName
                :rules="nameRules"
                :counter="100"
                label= shortName
                required
            ></v-text-field>
            <v-text-field
                v-model= select.requirements.longName
                :rules="nameRules"
                :counter="100"
                label= longName
                required
            ></v-text-field>
            <v-text-field
                v-model= select.requirements.numberOfAccounts
                :rules="nameRules"
                :counter="100"
                label= numberOfAccounts
                required
            ></v-text-field>
    </v-row>
    <v-row v-if= " select.state=== 'Stream Service'" >
        <v-text-field
                v-model= select.requirements.shortName
                :rules="nameRules"
                :counter="100"
                label= shortName
                required
            ></v-text-field>
            <v-text-field
                v-model= select.requirements.longName
                :rules="nameRules"
                :counter="100"
                label= longName
                required
            ></v-text-field>
            <v-text-field
                v-model= select.requirements.subscribePrice
                :rules="nameRules"
                :counter="100"
                label= subscribePrice
                required
            ></v-text-field>
    </v-row>
    <v-row v-if= " select.state=== 'Studio'" >
        <v-text-field
                v-model= select.requirements.shortName
                :rules="nameRules"
                :counter="100"
                label= shortName
                required
            ></v-text-field>
            <v-text-field
                v-model= select.requirements.longName
                :rules="nameRules"
                :counter="100"
                label= longName
                required
            ></v-text-field>
    </v-row>
    <v-row v-if= " select.state=== 'Event'" >
        <v-text-field
                v-model= select.requirements.eventType
                :rules="nameRules"
                :counter="100"
                label= "Type: movie or ppv"
                required
            ></v-text-field>
            <v-text-field
                v-model= select.requirements.eventName
                :rules="nameRules"
                :counter="100"
                label= "Event Name"
                required
            ></v-text-field>
            <v-text-field
                v-model= select.requirements.eventYear
                :rules="nameRules"
                :counter="100"
                label= "year Produced"
                required
            ></v-text-field>
            <v-text-field
                v-model= select.requirements.eventDuration
                :rules="nameRules"
                :counter="100"
                label= duration
                required
            ></v-text-field>
            <v-text-field
                v-model= select.requirements.licenseFee
                :rules="nameRules"
                :counter="100"
                label= licenseFee
                required
            ></v-text-field>
            <v-text-field
                v-model= select.requirements.eventStudio
                :rules="nameRules"
                :counter="100"
                label= studio
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
    <v-row v-if="response.data">
        {{ response.data }}
    </v-row>
</v-container>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      response: { data: null },
      nameRules: [
        v => !!v || 'Required'
      ],
      select: {
        state: 'Demographic Group',
        url: '/api/create_demo',
        requirements: { shortName: '', longName: '', numberOfAccounts: '' }
      },
      items: [
        {
          state: 'Demographic Group',
          url: '/api/create_demo',
          requirements: { shortName: '', longName: '', numberOfAccounts: '' }
        },
        {
          state: 'Stream Service',
          url: '/api/create_stream',
          requirements: { shortName: '', longName: '', subscribePrice: '' }
        },
        {
          state: 'Studio',
          url: '/api/create_studio',
          requirements: { shortName: '', longName: '' }

        },
        {
          state: 'Event',
          url: '/api/create_event',
          requirements: { eventType: '', eventName: '', eventYear: '', eventDuration: '', licenseFee: '', eventStudio: '' }
        }
      ]
    }
  },
  methods: {
    submit () {
      // this.$v.$touch()
      console.log(this.select)
      const payload = this.select.requirements
      const url = this.select.url
      axios.post(url, payload).then(res => {
        if (res.status === 200) {
          this.response = { data: res.config.data + 'created' }
        } else {
          this.response = { data: 'failed' }
        }
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
