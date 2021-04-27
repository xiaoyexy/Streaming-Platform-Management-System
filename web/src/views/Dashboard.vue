<template>
    <!-- <div>Dashboard </div> -->
    <div>
    <Dashboard></Dashboard>
    <DisplayTime></DisplayTime>
    </div>
</template>

<script>
import Dashboard from '@/components/Dashboard'
import DisplayTime from '@/components/DisplayTime'
import store from '@/store'
export default {
  name: 'dashboard',
  components: {
    Dashboard,
    DisplayTime
  },
  created () {
    store.dispatch('time/setTime')
  }
}
</script>
