<template>
    <v-container>
        <v-row align="center">
            <v-col cols="3">
                <v-subheader>
                Select
                </v-subheader>
            </v-col>

        <v-col cols="3">
            <v-select
            v-model="select"
            :items="items"
            item-text="state"
            item-value="abbr"
            label="Select"
            persistent-hint
            return-object
            single-line
            ></v-select>
            </v-col>
        <v-col cols="3">
            <v-text-field
            v-model="title"
            counter="25"
            hint="Optional if view events or offers; Required otherwise"
            label="Short Name"
          ></v-text-field>
        </v-col>
         <v-col cols="2">
             <v-btn @click.prevent="query">Display</v-btn>
         </v-col>
        </v-row>
        <v-row v-if="response" >
             <v-col cols="1">
                <strong>ReSULT </strong>
             </v-col>
             <v-col cols="1">
                <strong>{{ parseStatus(response.status )}} </strong>
             </v-col>
        </v-row >
    </v-container>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      select: { state: 'Demographic Group' },
      items: [
        { state: 'Demographic Group', url: '/api/display_demo' },
        { state: 'Stream Service', url: '/api/display_stream' },
        { state: 'Studio', url: '/api/display_studio' },
        { state: 'All Events (PPV or Movie)', url: '/api/display_events' },
        { state: 'All Offers', url: '/api/display_offers' }
      ],
      title: '',
      response: null
    }
  },
  methods: {
    query () {
      if (this.select.state === 'Demographic Group' ||
        this.select.state === 'Stream Service' || this.select.state === 'Studio') {
        if (this.title === '' || this.title.length === 0) {
          alert('Short Name is required!')
          return
        }
        const data = { shortName: this.title }
        axios.post(this.select.url, data).then(res => {
          this.response = res
        })
      } else {
        axios.get(this.select.url).then(res => {
          this.response = res
        })
      }
    },
    parseStatus (status) {
      if (status !== 200) {
        console.log('Failed')
        return 'Failed'
      } else {
        return 'Success'
      }
    }
  }
}
</script>
