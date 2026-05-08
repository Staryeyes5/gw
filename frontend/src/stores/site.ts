import { defineStore } from 'pinia'
import { ref, computed } from 'vue'
import api from '@/services/api'

export const useSiteStore = defineStore('site', () => {
  const companyInfo = ref<any>(null)
  const configs = ref<any[]>([])
  const loading = ref(false)

  const companyName = computed(() => companyInfo.value?.companyName || '申朴信息')
  const stockCode = computed(() => companyInfo.value?.stockCode || '870221')
  const contactPhone = computed(() => companyInfo.value?.contactPhone || '400-888-8888')
  const contactEmail = computed(() => companyInfo.value?.contactEmail || 'contact@cisetech.com')

  async function fetchCompanyInfo() {
    loading.value = true
    try {
      const response = await api.get('/company')
      companyInfo.value = response.data
    } catch (error) {
      console.error('Failed to fetch company info:', error)
    } finally {
      loading.value = false
    }
  }

  async function fetchConfigs() {
    try {
      const response = await api.get('/configs')
      configs.value = response.data
    } catch (error) {
      console.error('Failed to fetch configs:', error)
    }
  }

  function getConfig(key: string) {
    const config = configs.value.find(c => c.configKey === key)
    return config?.configValue
  }

  return {
    companyInfo,
    configs,
    loading,
    companyName,
    stockCode,
    contactPhone,
    contactEmail,
    fetchCompanyInfo,
    fetchConfigs,
    getConfig
  }
})
