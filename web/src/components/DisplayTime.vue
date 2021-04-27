<template>
    <v-card
    class="mx-auto"
    max-width="344"
    outlined
  >
    <v-list-item three-line>
      <v-list-item-content>
        <v-list-item-title class="headline mb-1">
          {{month}}
        </v-list-item-title>
        <v-list-item-subtitle>{{year}}</v-list-item-subtitle>
      </v-list-item-content>

    </v-list-item>

    <v-card-actions>
      <v-btn
        outlined
        rounded
        text
        @click.prevent = "nextMonthConfirm"
      >
        Next Month
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
// import axios from 'axios'
import { mapActions, mapGetters } from 'vuex'
export default {
//   data () {
//     return {
//       time: {
//         month: '',
//         year: ''
//       }
//     }
//   },
  computed: {
    ...mapGetters({
      year: 'time/year',
      month: 'time/month'
    })
  },
  //   mounted () {
  //     axios.post('/api/display_time', {}).then(
  //       res => {
  //         const resString = res.data
  //         const resList = resString.split(',')
  //         this.time.month = resList[1]
  //         this.time.year = resList[2]
  //       }
  //     )
  //   },
  methods: {
    ...mapActions({
      nextMonth: 'time/nextMonth'
    }),

    nextMonthConfirm () {
      this.nextMonth()
    }
    // nextMonth () {
    //   axios.post('/api/next_month', {}).then(
    //     () => {
    //       axios.post('/api/display_time', {}).then(
    //         res => {
    //           const resString = res.data
    //           const resList = resString.split(',')
    //           this.time.month = resList[1]
    //           this.time.year = resList[2]
    //         }
    //       )
    //     }
    //   )
    // }
  }
}
</script>
