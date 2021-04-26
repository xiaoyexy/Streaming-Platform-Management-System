<template>
<v-stepper
    v-model="e6"
    vertical
  >
    <v-stepper-step
      :complete="e6 > 1"
      step="1"
    >
      Select
      <small>(required)</small>
    </v-stepper-step>
    <v-stepper-content steep="1">
      <v-card fluid>
        <v-row align="center">
            <v-col cols="2">
              <v-subheader>
                Display
              </v-subheader>
            </v-col>
            <v-col cols ="2">
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
            <v-col cols ="2">
              <v-btn @click.prevent="display_btn()">Go</v-btn>
            </v-col>
        </v-row>
      </v-card>
    <v-btn
        color="primary"
        @click="e6 = 2"
      >
        Continue
      </v-btn>
      <v-btn text>
        Cancel
      </v-btn>
    </v-stepper-content>
</v-stepper>
</template>

<script>
// import axios from 'axios'
export default {
  data () {
    return {
      // e6: 1
      select: { state: 'Demographic group' },
      items: [
        { state: 'Demographic group' },
        { state: 'Stream Service' },
        { state: 'Studio' },
        { state: 'All Events (PPV or Movie)' },
        { state: 'All Offers' }
      ]
    }
  },
  methods: {
    display_btn () {
      console.log(this.select.state)
      // if this.select.state
    }
  }
}
</script>
