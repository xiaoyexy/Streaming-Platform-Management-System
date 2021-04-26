<template>
    <div>
        <div>demo</div>
        <div>{{demos}}</div>
    </div>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      demos: []
    }
  },
  created () {
    axios.get('/list_demographic_group').then(
      res => {
        this.demos = res.data
      }
    )
  }
}
</script>
