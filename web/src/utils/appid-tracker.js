import Configuration from '@/utils/configuration'

export default class AppIdTracker {
  appId () {
    return Configuration.value('appid')
  }
}
