<template>
    <div>
        {{ appid }} is serving
    </div>
</template>

<script>
import Configuration from '@/utils/configuration'
const APPID = Configuration.value('appid')
console.log(APPID)
export default {
  data () {
    return {
      appid: APPID
    }
  }
}
</script>
