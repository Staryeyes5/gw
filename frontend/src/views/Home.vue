<template>
  <div class="home">
    <!-- Hero Section -->
    <section class="hero">
      <div class="container">
        <div class="hero-content">
          <div class="hero-text animate-fade-in">
            <div class="hero-badge">
              <span class="badge-icon">🏆</span>
              <span>15年行业深耕</span>
            </div>
            <h1 class="hero-title">
              <span class="gradient-text">融智于用</span>
              <br>
              国内领先金融科技解决方案专家
            </h1>
            <p class="hero-description">
              申朴信息专注于为银行、保险、证券、互联网等行业客户提供全栈式数字化转型服务，拥有完整的AI、大数据、信创、信息安全技术体系。
            </p>
            <div class="hero-actions">
              <router-link to="/services" class="btn btn-primary btn-lg">
                了解核心业务
              </router-link>
              <router-link to="/contact" class="btn btn-outline btn-lg">
                联系我们
              </router-link>
            </div>
          </div>
          <div class="hero-image">
            <div class="tech-decoration">
              <div class="tech-circle circle-1"></div>
              <div class="tech-circle circle-2"></div>
              <div class="tech-circle circle-3"></div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- Stats Section -->
    <section class="stats">
      <div class="container">
        <div class="stats-grid">
          <div class="stat-item animate-slide-up">
            <div class="stat-number">15+</div>
            <div class="stat-label">年行业经验</div>
          </div>
          <div class="stat-item animate-slide-up" style="animation-delay: 0.1s;">
            <div class="stat-number">25+</div>
            <div class="stat-label">城市服务覆盖</div>
          </div>
          <div class="stat-item animate-slide-up" style="animation-delay: 0.2s;">
            <div class="stat-number">500+</div>
            <div class="stat-label">专业团队</div>
          </div>
          <div class="stat-item animate-slide-up" style="animation-delay: 0.3s;">
            <div class="stat-number">数百家</div>
            <div class="stat-label">合作客户</div>
          </div>
        </div>
      </div>
    </section>

    <!-- Services Preview Section -->
    <section class="services-preview section">
      <div class="container">
        <div class="section-header">
          <h2 class="section-title">核心业务体系</h2>
          <p class="section-subtitle">五大核心业务，全方位赋能企业数字化转型</p>
        </div>
        <div class="services-grid tech-grid">
          <div 
            v-for="(service, index) in services" 
            :key="service.id"
            class="service-card card"
            :style="{ animationDelay: `${index * 0.1}s` }"
          >
            <div class="service-icon">{{ service.icon }}</div>
            <h3 class="service-title">{{ service.title }}</h3>
            <p class="service-desc">{{ service.description }}</p>
            <router-link :to="`/services`" class="service-link">
              了解更多 →
            </router-link>
          </div>
        </div>
      </div>
    </section>

    <!-- Technology Section -->
    <section class="technology section bg-gray-50">
      <div class="container">
        <div class="tech-content">
          <div class="tech-text">
            <h2 class="section-title">技术底座</h2>
            <h3 class="tech-subtitle">AI + 大数据双轮驱动</h3>
            <p class="tech-description">
              我们以人工智能和大数据技术为核心，构建完整的企业数字生态服务能力，
              为客户提供从咨询规划到落地实施的全周期数字化转型服务。
            </p>
            <div class="tech-tags">
              <span v-for="tag in techTags" :key="tag" class="tech-tag">
                {{ tag }}
              </span>
            </div>
          </div>
          <div class="tech-visual">
            <div class="tech-grid-visual">
              <div class="tech-node" v-for="(node, index) in techNodes" :key="index">
                {{ node }}
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- Products Preview -->
    <section class="products-preview section">
      <div class="container">
        <div class="section-header">
          <h2 class="section-title">自研产品矩阵</h2>
          <p class="section-subtitle">从平台到应用，完整的产品生态体系</p>
        </div>
        <div class="products-grid tech-grid">
          <div 
            v-for="(product, index) in products" 
            :key="product.id"
            class="product-card card"
            :style="{ animationDelay: `${index * 0.1}s` }"
          >
            <div class="product-header">
              <span class="product-icon">{{ product.icon }}</span>
              <span class="product-category">{{ product.category }}</span>
            </div>
            <h3 class="product-name">{{ product.name }}</h3>
            <p class="product-desc">{{ product.description }}</p>
          </div>
        </div>
        <div class="section-cta">
          <router-link to="/products" class="btn btn-outline">
            查看全部产品
          </router-link>
        </div>
      </div>
    </section>

    <!-- CTA Section -->
    <section class="cta section">
      <div class="container">
        <div class="cta-content">
          <h2 class="cta-title">准备好开始您的数字化转型之旅了吗？</h2>
          <p class="cta-description">
            专业团队为您提供定制化解决方案，助力企业实现业务增长与创新
          </p>
          <router-link to="/contact" class="btn btn-primary btn-lg">
            立即咨询
          </router-link>
        </div>
      </div>
    </section>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { useHead } from '@vueuse/head'

useHead({
  title: '申朴信息 - 国内领先金融科技解决方案专家',
  meta: [
    { name: 'description', content: '申朴信息是国内领先的金融科技与企业数字化转型解决方案服务商，15年行业深耕经验。' }
  ]
})

const services = ref([
  {
    id: 1,
    title: '数字化转型服务',
    description: '企业全周期数字化转型定制方案，业务场景-技术应用全链条升级服务',
    icon: '🔄'
  },
  {
    id: 2,
    title: 'AI赋能服务',
    description: '自有核心AI技术场景化定制，企业智能体系搭建，AI驱动业务升级服务',
    icon: '🤖'
  },
  {
    id: 3,
    title: '信息安全服务',
    description: '网络安全监测、数据加密、安全风险排查、企业信息资产安全保障服务',
    icon: '🛡️'
  },
  {
    id: 4,
    title: '信创适配服务',
    description: '数据库信创全流程服务，含规划咨询、系统选型适配、应用开发迁移',
    icon: '🖥️'
  },
  {
    id: 5,
    title: 'ITO/BPO外包服务',
    description: '项目外包、人力外包、业务流程外包等多元化外包服务',
    icon: '📊'
  }
])

const products = ref([
  {
    id: 1,
    name: 'APM可观测平台',
    description: '全链路应用性能监控与可观测性解决方案',
    icon: '📈',
    category: 'AI赋能'
  },
  {
    id: 2,
    name: 'AI辅助编程',
    description: '智能化代码生成与编程辅助工具',
    icon: '💻',
    category: 'AI赋能'
  },
  {
    id: 3,
    name: 'SME中小微产业金融系统',
    description: '中小微企业金融服务数字化解决方案',
    icon: '🏦',
    category: '金融科技'
  }
])

const techTags = ref([
  '人工智能', '大数据', '信创', '信息安全', '云计算', '区块链'
])

const techNodes = ref(['AI', '大数据', '安全', '信创', '云', '区块链'])

onMounted(() => {
})
</script>

<style scoped lang="scss">
.hero {
  padding: 160px 0 80px;
  background: linear-gradient(135deg, #f0f9ff 0%, #e0f2fe 100%);
  position: relative;
  overflow: hidden;
}

.hero-content {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 4rem;
  align-items: center;
}

.hero-text {
  animation: fadeIn 0.8s ease-out;
}

.hero-badge {
  display: inline-flex;
  align-items: center;
  gap: 0.5rem;
  padding: 0.5rem 1rem;
  background: white;
  border-radius: 50px;
  font-size: 0.875rem;
  color: #0369a1;
  margin-bottom: 1.5rem;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

.hero-title {
  font-size: 3rem;
  font-weight: 800;
  line-height: 1.2;
  margin-bottom: 1.5rem;
  color: #0c4a6e;
}

.hero-description {
  font-size: 1.125rem;
  line-height: 1.8;
  color: #475569;
  margin-bottom: 2rem;
}

.hero-actions {
  display: flex;
  gap: 1rem;
  flex-wrap: wrap;
}

.btn-lg {
  padding: 0.875rem 2rem;
  font-size: 1.125rem;
}

.hero-image {
  position: relative;
  height: 400px;
}

.tech-decoration {
  position: absolute;
  inset: 0;
}

.tech-circle {
  position: absolute;
  border-radius: 50%;
  opacity: 0.3;
}

.circle-1 {
  width: 200px;
  height: 200px;
  background: linear-gradient(135deg, #0ea5e9, #22c55e);
  top: 10%;
  right: 10%;
  animation: float 6s ease-in-out infinite;
}

.circle-2 {
  width: 150px;
  height: 150px;
  background: linear-gradient(135deg, #22c55e, #0ea5e9);
  bottom: 20%;
  left: 20%;
  animation: float 6s ease-in-out infinite 1s;
}

.circle-3 {
  width: 100px;
  height: 100px;
  background: linear-gradient(135deg, #0ea5e9, #0284c7);
  top: 40%;
  left: 40%;
  animation: float 6s ease-in-out infinite 2s;
}

@keyframes float {
  0%, 100% { transform: translateY(0) rotate(0deg); }
  50% { transform: translateY(-20px) rotate(5deg); }
}

.stats {
  padding: 60px 0;
  background: white;
}

.stats-grid {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 2rem;
}

.stat-item {
  text-align: center;
  padding: 2rem;
}

.stat-number {
  font-size: 3rem;
  font-weight: 800;
  background: linear-gradient(135deg, #0ea5e9, #22c55e);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
  margin-bottom: 0.5rem;
}

.stat-label {
  color: #64748b;
  font-size: 1.125rem;
}

.section-header {
  text-align: center;
  margin-bottom: 4rem;
}

.section-title {
  font-size: 2.5rem;
  font-weight: 800;
  color: #0c4a6e;
  margin-bottom: 1rem;
}

.section-subtitle {
  font-size: 1.125rem;
  color: #64748b;
}

.service-card,
.product-card {
  padding: 2rem;
  transition: all 0.3s ease;
  animation: slideUp 0.6s ease-out both;
}

.service-card:hover,
.product-card:hover {
  transform: translateY(-8px);
}

.service-icon {
  font-size: 3rem;
  margin-bottom: 1rem;
}

.service-title,
.product-name {
  font-size: 1.25rem;
  font-weight: 700;
  color: #0c4a6e;
  margin-bottom: 0.75rem;
}

.service-desc,
.product-desc {
  color: #64748b;
  line-height: 1.7;
  margin-bottom: 1rem;
}

.service-link {
  color: #0ea5e9;
  text-decoration: none;
  font-weight: 600;
  display: inline-flex;
  align-items: center;
  transition: color 0.3s;
  
  &:hover {
    color: #0284c7;
  }
}

.technology {
  background: #f8fafc;
}

.tech-content {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 4rem;
  align-items: center;
}

.tech-subtitle {
  font-size: 1.5rem;
  font-weight: 700;
  color: #0ea5e9;
  margin-bottom: 1rem;
}

.tech-description {
  font-size: 1.125rem;
  line-height: 1.8;
  color: #475569;
  margin-bottom: 2rem;
}

.tech-tags {
  display: flex;
  flex-wrap: wrap;
  gap: 0.75rem;
}

.tech-tag {
  padding: 0.5rem 1rem;
  background: white;
  border: 1px solid #e2e8f0;
  border-radius: 50px;
  font-weight: 500;
  color: #0369a1;
}

.tech-grid-visual {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 1rem;
}

.tech-node {
  aspect-ratio: 1;
  background: linear-gradient(135deg, #0ea5e9, #22c55e);
  border-radius: 1rem;
  display: flex;
  align-items: center;
  justify-content: center;
  color: white;
  font-weight: 700;
  font-size: 1.125rem;
  transition: transform 0.3s;
  
  &:hover {
    transform: scale(1.05);
  }
}

.product-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 1rem;
}

.product-icon {
  font-size: 2.5rem;
}

.product-category {
  padding: 0.25rem 0.75rem;
  background: #dbeafe;
  color: #0369a1;
  border-radius: 50px;
  font-size: 0.75rem;
  font-weight: 600;
}

.section-cta {
  text-align: center;
  margin-top: 3rem;
}

.cta {
  background: linear-gradient(135deg, #0c4a6e 0%, #075985 100%);
  color: white;
  text-align: center;
}

.cta-title {
  font-size: 2.5rem;
  font-weight: 800;
  margin-bottom: 1rem;
}

.cta-description {
  font-size: 1.25rem;
  color: rgba(255, 255, 255, 0.8);
  margin-bottom: 2rem;
  max-width: 600px;
  margin-left: auto;
  margin-right: auto;
}

@media (max-width: 1024px) {
  .hero-content,
  .tech-content {
    grid-template-columns: 1fr;
  }
  
  .hero-image {
    order: -1;
    height: 300px;
  }
  
  .stats-grid {
    grid-template-columns: repeat(2, 1fr);
  }
}

@media (max-width: 768px) {
  .hero {
    padding: 120px 0 60px;
  }
  
  .hero-title {
    font-size: 2rem;
  }
  
  .section-title {
    font-size: 1.875rem;
  }
  
  .cta-title {
    font-size: 1.875rem;
  }
  
  .stats-grid {
    grid-template-columns: 1fr;
  }
  
  .tech-grid-visual {
    grid-template-columns: repeat(2, 1fr);
  }
}

@keyframes fadeIn {
  from { opacity: 0; transform: translateY(20px); }
  to { opacity: 1; transform: translateY(0); }
}

@keyframes slideUp {
  from { opacity: 0; transform: translateY(30px); }
  to { opacity: 1; transform: translateY(0); }
}

.animate-fade-in {
  animation: fadeIn 0.8s ease-out;
}

.animate-slide-up {
  animation: slideUp 0.6s ease-out both;
}
</style>
