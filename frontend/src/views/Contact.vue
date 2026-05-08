<template>
  <div class="contact-page">
    <!-- Page Header -->
    <section class="page-header">
      <div class="container">
        <h1 class="page-title">联系我们</h1>
        <p class="page-subtitle">全国25+城市服务网络，专业团队为您提供咨询服务</p>
      </div>
    </section>

    <!-- Contact Info Section -->
    <section class="contact-info-section section">
      <div class="container">
        <div class="contact-grid">
          <div class="contact-info">
            <h2 class="section-title">联系我们</h2>
            <div class="info-items">
              <div class="info-item">
                <div class="info-icon">📞</div>
                <div class="info-content">
                  <h3>咨询热线</h3>
                  <p>{{ siteStore.contactPhone }}</p>
                </div>
              </div>
              <div class="info-item">
                <div class="info-icon">✉️</div>
                <div class="info-content">
                  <h3>电子邮箱</h3>
                  <p>{{ siteStore.contactEmail }}</p>
                </div>
              </div>
              <div class="info-item">
                <div class="info-icon">📍</div>
                <div class="info-content">
                  <h3>总部地址</h3>
                  <p>{{ siteStore.companyInfo?.address || '上海市浦东新区张江高科技园区' }}</p>
                </div>
              </div>
            </div>
          </div>

          <div class="contact-form-wrapper">
            <h2 class="section-title">在线咨询</h2>
            <form class="contact-form" @submit.prevent="handleSubmit">
              <div class="form-group">
                <label for="name">姓名 *</label>
                <input 
                  type="text" 
                  id="name" 
                  v-model="formData.name" 
                  placeholder="请输入您的姓名"
                  required
                />
              </div>
              <div class="form-group">
                <label for="phone">联系电话 *</label>
                <input 
                  type="tel" 
                  id="phone" 
                  v-model="formData.phone" 
                  placeholder="请输入您的联系电话"
                  required
                />
              </div>
              <div class="form-group">
                <label for="email">电子邮箱</label>
                <input 
                  type="email" 
                  id="email" 
                  v-model="formData.email" 
                  placeholder="请输入您的电子邮箱"
                />
              </div>
              <div class="form-group">
                <label for="company">公司名称</label>
                <input 
                  type="text" 
                  id="company" 
                  v-model="formData.company" 
                  placeholder="请输入您的公司名称"
                />
              </div>
              <div class="form-group">
                <label for="service">咨询业务</label>
                <select id="service" v-model="formData.service">
                  <option value="">请选择咨询业务</option>
                  <option value="digital">数字化转型服务</option>
                  <option value="ai">AI赋能服务</option>
                  <option value="security">信息安全服务</option>
                  <option value="xinchuang">信创适配服务</option>
                  <option value="outsourcing">ITO/BPO外包服务</option>
                  <option value="other">其他</option>
                </select>
              </div>
              <div class="form-group">
                <label for="message">留言内容 *</label>
                <textarea 
                  id="message" 
                  v-model="formData.message" 
                  placeholder="请详细描述您的需求..."
                  rows="5"
                  required
                ></textarea>
              </div>
              <button type="submit" class="btn btn-primary btn-lg btn-full" :disabled="isSubmitting">
                {{ isSubmitting ? '提交中...' : '提交咨询' }}
              </button>
            </form>
          </div>
        </div>
      </div>
    </section>

    <!-- Service Network Section -->
    <section class="network-section section bg-gray-50">
      <div class="container">
        <div class="section-header">
          <h2 class="section-title">服务网络</h2>
          <p class="section-subtitle">全国25+城市服务网络，总部上海，辐射全国</p>
        </div>
        <div class="network-grid">
          <div 
            v-for="(city, index) in serviceCities" 
            :key="index"
            class="network-card"
            :class="{ 'network-headquarters': city.isHeadquarters }"
          >
            <div class="network-icon">{{ city.icon }}</div>
            <h3 class="network-city">{{ city.name }}</h3>
            <p v-if="city.isHeadquarters" class="network-badge">总部</p>
            <p class="network-region">{{ city.region }}</p>
          </div>
        </div>
      </div>
    </section>

    <!-- CTA Section -->
    <section class="cta-section section">
      <div class="container">
        <div class="cta-content">
          <h2 class="cta-title">准备好开始合作了吗？</h2>
          <p class="cta-desc">我们的专业团队随时准备为您提供服务</p>
          <div class="cta-actions">
            <a :href="`tel:${siteStore.contactPhone}`" class="btn btn-primary btn-lg">
              📞 立即致电
            </a>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script setup lang="ts">
import { ref, reactive } from 'vue'
import { useHead } from '@vueuse/head'
import { useSiteStore } from '@/stores/site'

useHead({
  title: '联系我们 - 申朴信息',
  meta: [
    { name: 'description', content: '联系申朴信息，全国25+城市服务网络，专业团队为您提供咨询服务。' }
  ]
})

const siteStore = useSiteStore()

const isSubmitting = ref(false)

const formData = reactive({
  name: '',
  phone: '',
  email: '',
  company: '',
  service: '',
  message: ''
})

const serviceCities = [
  { name: '上海', region: '华东', icon: '🏙️', isHeadquarters: true },
  { name: '北京', region: '华北', icon: '🏛️', isHeadquarters: false },
  { name: '深圳', region: '华南', icon: '🌆', isHeadquarters: false },
  { name: '杭州', region: '华东', icon: '🏞️', isHeadquarters: false },
  { name: '香港', region: '港澳台', icon: '🌃', isHeadquarters: false },
  { name: '广州', region: '华南', icon: '🌇', isHeadquarters: false },
  { name: '成都', region: '西南', icon: '🏔️', isHeadquarters: false },
  { name: '武汉', region: '华中', icon: '🌉', isHeadquarters: false }
]

const handleSubmit = async () => {
  isSubmitting.value = true
  
  try {
    alert('感谢您的咨询！我们的专业团队将尽快与您联系。')
    
    formData.name = ''
    formData.phone = ''
    formData.email = ''
    formData.company = ''
    formData.service = ''
    formData.message = ''
  } catch (error) {
    console.error('Form submission error:', error)
    alert('提交失败，请稍后重试。')
  } finally {
    isSubmitting.value = false
  }
}
</script>

<style scoped lang="scss">
.page-header {
  padding: 160px 0 80px;
  background: linear-gradient(135deg, #0c4a6e 0%, #075985 100%);
  color: white;
  text-align: center;
}

.page-title {
  font-size: 3rem;
  font-weight: 800;
  margin-bottom: 1rem;
}

.page-subtitle {
  font-size: 1.25rem;
  opacity: 0.9;
}

.contact-info-section {
  padding: 80px 0;
}

.contact-grid {
  display: grid;
  grid-template-columns: 1fr 1.5fr;
  gap: 4rem;
}

.contact-info {
  padding: 2rem;
}

.info-items {
  display: flex;
  flex-direction: column;
  gap: 2rem;
}

.info-item {
  display: flex;
  gap: 1.5rem;
  align-items: flex-start;
}

.info-icon {
  font-size: 2.5rem;
  flex-shrink: 0;
}

.info-content h3 {
  font-size: 1.125rem;
  font-weight: 700;
  color: #0c4a6e;
  margin-bottom: 0.5rem;
}

.info-content p {
  color: #64748b;
  font-size: 1.125rem;
}

.contact-form-wrapper {
  padding: 2.5rem;
  background: white;
  border-radius: 1.5rem;
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.08);
}

.contact-form {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
}

.form-group {
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
}

.form-group label {
  font-weight: 600;
  color: #475569;
}

.form-group input,
.form-group select,
.form-group textarea {
  padding: 0.875rem 1rem;
  border: 1px solid #e2e8f0;
  border-radius: 0.5rem;
  font-size: 1rem;
  transition: border-color 0.3s;
  font-family: inherit;
}

.form-group input:focus,
.form-group select:focus,
.form-group textarea:focus {
  outline: none;
  border-color: #0ea5e9;
  box-shadow: 0 0 0 3px rgba(14, 165, 233, 0.1);
}

.btn-full {
  width: 100%;
}

.network-section {
  background: #f8fafc;
  padding: 80px 0;
}

.network-grid {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 1.5rem;
}

.network-card {
  padding: 2rem;
  background: white;
  border-radius: 1rem;
  text-align: center;
  border: 2px solid transparent;
  transition: all 0.3s;

  &:hover {
    transform: translateY(-4px);
    box-shadow: 0 8px 25px rgba(0, 0, 0, 0.1);
  }
}

.network-headquarters {
  border-color: #0ea5e9;
  background: linear-gradient(135deg, #dbeafe, #eff6ff);
}

.network-icon {
  font-size: 2.5rem;
  margin-bottom: 1rem;
}

.network-city {
  font-size: 1.25rem;
  font-weight: 700;
  color: #0c4a6e;
  margin-bottom: 0.5rem;
}

.network-badge {
  display: inline-block;
  padding: 0.25rem 0.75rem;
  background: #0ea5e9;
  color: white;
  border-radius: 50px;
  font-size: 0.75rem;
  font-weight: 600;
  margin-bottom: 0.5rem;
}

.network-region {
  color: #64748b;
}

.cta-section {
  padding: 80px 0;
  background: linear-gradient(135deg, #0c4a6e 0%, #075985 100%);
  color: white;
}

.cta-content {
  text-align: center;
}

.cta-title {
  font-size: 2.5rem;
  font-weight: 800;
  margin-bottom: 1rem;
}

.cta-desc {
  font-size: 1.25rem;
  opacity: 0.9;
  margin-bottom: 2rem;
}

.cta-actions {
  display: flex;
  justify-content: center;
  gap: 1rem;
}

@media (max-width: 1024px) {
  .contact-grid {
    grid-template-columns: 1fr;
  }
  
  .network-grid {
    grid-template-columns: repeat(2, 1fr);
  }
}

@media (max-width: 768px) {
  .page-title {
    font-size: 2rem;
  }
  
  .network-grid {
    grid-template-columns: repeat(2, 1fr);
  }
  
  .cta-title {
    font-size: 1.875rem;
  }
}
</style>
