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
                :counter="10"
                label= shortName
                required
            ></v-text-field>
            <v-text-field
                v-model= select.requirements.longName
                :rules="nameRules"
                :counter="10"
                label= longName
                required
            ></v-text-field>
            <v-text-field
                v-model= select.requirements.numberOfAccounts
                :rules="nameRules"
                :counter="10"
                label= numberOfAccounts
                required
            ></v-text-field>
    </v-row>
    <v-row v-if= " select.state=== 'Stream Service'" >
        <v-text-field
                v-model= select.requirements.shortName
                :rules="nameRules"
                :counter="10"
                label= shortName
                required
            ></v-text-field>
            <v-text-field
                v-model= select.requirements.longName
                :rules="nameRules"
                :counter="10"
                label= longName
                required
            ></v-text-field>
            <v-text-field
                v-model= select.requirements.subscriptionPrice
                :rules="nameRules"
                :counter="10"
                label= subscriptionPrice
                required
            ></v-text-field>
    </v-row>
    <v-row v-if= " select.state=== 'Studio'" >
        <v-text-field
                v-model= select.requirements.shortName
                :rules="nameRules"
                :counter="10"
                label= shortName
                required
            ></v-text-field>
            <v-text-field
                v-model= select.requirements.longName
                :rules="nameRules"
                :counter="10"
                label= longName
                required
            ></v-text-field>
    </v-row>
    <v-row v-if= " select.state=== 'Event'" >
        <v-text-field
                v-model= select.requirements.type
                :rules="nameRules"
                :counter="10"
                label= shortName
                required
            ></v-text-field>
            <v-text-field
                v-model= select.requirements.name
                :rules="nameRules"
                :counter="10"
                label= longName
                required
            ></v-text-field>
            <v-text-field
                v-model= select.requirements.yearProduced
                :rules="nameRules"
                :counter="10"
                label= yearProduced
                required
            ></v-text-field>
            <v-text-field
                v-model= select.requirements.duration
                :rules="nameRules"
                :counter="10"
                label= duration
                required
            ></v-text-field>
            <v-text-field
                v-model= select.requirements.licenseFee
                :rules="nameRules"
                :counter="10"
                label= licenseFee
                required
            ></v-text-field>
            <v-text-field
                v-model= select.requirements.studio
                :rules="nameRules"
                :counter="10"
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
    <v-row v-if="response">
        {{ response }}
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
          url: '/api/create_streaming_service',
          requirements: { shortName: '', longName: '', subscriptionPrice: '' }
        },
        {
          state: 'Studio',
          url: '/api/create_studio',
          requirements: { shortName: '', longName: '' }

        },
        {
          state: 'Event',
          url: '/api/create_event',
          requirements: { type: '', name: '', yearProduced: '', duration: '', licenseFee: '', studio: '' }
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
        this.response = res
      })
    }
  }
}
</script>
