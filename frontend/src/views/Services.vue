<template>
  <div class="services-page">
    <!-- Page Header -->
    <section class="page-header">
      <div class="container">
        <h1 class="page-title">核心业务体系</h1>
        <p class="page-subtitle">五大核心业务，全方位赋能企业数字化转型</p>
      </div>
    </section>

    <!-- Services List -->
    <section class="services-list section">
      <div class="container">
        <div class="services-grid">
          <div 
            v-for="(service, index) in services" 
            :key="service.id"
            class="service-item"
            :class="{ 'service-item-alt': index % 2 === 1 }"
          >
            <div class="service-content">
              <div class="service-icon-wrapper">
                <span class="service-icon-large">{{ service.icon }}</span>
              </div>
              <h2 class="service-title">{{ service.title }}</h2>
              <p class="service-description">{{ service.description }}</p>
              <div class="service-features" v-if="service.features">
                <div v-for="(feature, idx) in service.features" :key="idx" class="feature-item">
                  <span class="feature-icon">✓</span>
                  <span class="feature-text">{{ feature }}</span>
                </div>
              </div>
            </div>
            <div class="service-visual">
              <div class="service-gradient"></div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- Industries Section -->
    <section class="industries section bg-gray-50">
      <div class="container">
        <div class="section-header">
          <h2 class="section-title">服务行业</h2>
          <p class="section-subtitle">深耕多个行业，为不同领域客户提供专业服务</p>
        </div>
        <div class="industries-grid">
          <div v-for="(industry, index) in industries" :key="index" class="industry-card">
            <span class="industry-icon">{{ industry.icon }}</span>
            <span class="industry-name">{{ industry.name }}</span>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script setup lang="ts">
import { useHead from '@vueuse/head'

useHead({
  title: '核心业务体系 - 申朴信息',
  meta: [
    { name: 'description', content: '申朴信息提供数字化转型、AI赋能、信息安全、信创适配、ITO/BPO外包等五大核心业务服务。' }
  ]
})

const services = [
  {
    id: 1,
    title: '数字化转型服务',
    description: '企业全周期数字化转型定制方案，业务场景-技术应用全链条升级服务。我们帮助企业从战略规划到技术落地，实现全方位数字化转型。',
    icon: '🔄',
    features: [
      '数字化战略咨询与规划',
      '业务流程数字化重构',
      '技术架构升级与迁移',
      '数据中台建设',
      '全周期实施与运维'
    ]
  },
  {
    id: 2,
    title: 'AI赋能服务',
    description: '自有核心AI技术场景化定制，企业智能体系搭建，AI驱动业务升级服务。基于先进的人工智能技术，为企业提供智能化解决方案。',
    icon: '🤖',
    features: [
      'AI技术场景化定制',
      '企业智能体系搭建',
      'AI模型训练与优化',
      '智能决策支持系统',
      'AI应用落地实施'
    ]
  },
  {
    id: 3,
    title: '信息安全服务',
    description: '网络安全监测、数据加密、安全风险排查、企业信息资产安全保障服务。全方位保障企业信息资产安全。',
    icon: '🛡️',
    features: [
      '网络安全监测与防护',
      '数据加密与保护',
      '安全风险评估与排查',
      '安全体系建设与优化',
      '应急响应与处理'
    ]
  },
  {
    id: 4,
    title: '信创适配服务',
    description: '数据库信创全流程服务，含规划咨询、系统选型适配、应用开发迁移、自主可控信息技术体系搭建。',
    icon: '🖥️',
    features: [
      '信创规划咨询',
      '系统选型与适配',
      '应用开发与迁移',
      '信创体系建设',
      '信创人才培养'
    ]
  },
  {
    id: 5,
    title: 'ITO/BPO外包服务',
    description: '项目外包、人力外包、业务流程外包等多元化外包服务。灵活的外包模式，满足企业不同需求。',
    icon: '📊',
    features: [
      '项目外包服务',
      '人力资源外包',
      '业务流程外包',
      '定制化外包方案',
      '外包团队管理'
    ]
  }
]

const industries = [
  { name: '银行', icon: '🏦' },
  { name: '保险', icon: '🛡️' },
  { name: '证券基金', icon: '📈' },
  { name: '金融科技', icon: '💰' },
  { name: '互联网', icon: '🌐' },
  { name: '新型制造', icon: '🏭' },
  { name: '大数据', icon: '💾' },
  { name: '更多行业', icon: '📊' }
]
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

.services-list {
  padding: 80px 0;
}

.service-item {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 4rem;
  align-items: center;
  margin-bottom: 4rem;
  padding: 3rem;
  background: white;
  border-radius: 1.5rem;
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.08);
}

.service-item-alt {
  .service-content {
    order: 2;
  }
  .service-visual {
    order: 1;
  }
}

.service-icon-wrapper {
  display: inline-flex;
  padding: 1.5rem;
  background: linear-gradient(135deg, #0ea5e9, #22c55e);
  border-radius: 1rem;
  margin-bottom: 1.5rem;
}

.service-icon-large {
  font-size: 3rem;
}

.service-title {
  font-size: 2rem;
  font-weight: 800;
  color: #0c4a6e;
  margin-bottom: 1rem;
}

.service-description {
  font-size: 1.125rem;
  line-height: 1.8;
  color: #475569;
  margin-bottom: 1.5rem;
}

.service-features {
  display: flex;
  flex-direction: column;
  gap: 0.75rem;
}

.feature-item {
  display: flex;
  align-items: center;
  gap: 0.75rem;
}

.feature-icon {
  color: #22c55e;
  font-weight: 700;
}

.feature-text {
  color: #475569;
}

.service-visual {
  height: 300px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.service-gradient {
  width: 100%;
  height: 200px;
  background: linear-gradient(135deg, #0ea5e9 0%, #22c55e 100%);
  border-radius: 1rem;
  opacity: 0.1;

}

.industries {
  background: #f8fafc;
}

.industries-grid {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 1.5rem;
}

.industry-card {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 2rem;
  background: white;
  border-radius: 1rem;
  text-align: center;
  transition: all 0.3s;
  border: 1px solid #e2e8f0;

  &:hover {
    transform: translateY(-4px);
    box-shadow: 0 8px 25px rgba(0, 0, 0, 0.1);
  }
}

.industry-icon {
  font-size: 2.5rem;
  margin-bottom: 1rem;
}

.industry-name {
  font-weight: 600;
  color: #0c4a6e;
}

@media (max-width: 1024px) {
  .service-item {
    grid-template-columns: 1fr;
    
    .service-content,
    .service-visual {
      order: initial;
    }
  }
  
  .industries-grid {
    grid-template-columns: repeat(2, 1fr);
  }
}

@media (max-width: 768px) {
  .page-title {
    font-size: 2rem;
  }
  
  .service-title {
    font-size: 1.5rem;
  }
  
  .industries-grid {
    grid-template-columns: repeat(2, 1fr);
  }
}
</style>
