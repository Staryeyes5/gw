<template>
  <div class="about-page">
    <!-- Page Header -->
    <section class="page-header">
      <div class="container">
        <h1 class="page-title">关于我们</h1>
        <p class="page-subtitle">了解申朴信息的发展历程、技术实力与服务理念</p>
      </div>
    </section>

    <!-- Introduction Section -->
    <section class="intro-section section">
      <div class="container">
        <div class="intro-content">
          <div class="intro-text">
          <h2 class="section-title">企业简介</h2>
          <p class="intro-desc">
            上海申朴信息技术股份有限公司成立于2010年，是国内领先的金融科技与企业数字化转型解决方案服务商。
            公司以「融智于用」为核心理念，围绕“数转智改”核心战略，为银行、保险、证券、互联网等行业客户提供全栈式数字化转型服务。
          </p>
          <div class="concepts-grid">
            <div class="concept-item">
              <span class="concept-icon">🌟</span>
              <h3>品牌理念</h3>
              <p>申信达成，朴心进取</p>
            </div>
            <div class="concept-item">
              <span class="concept-icon">💡</span>
              <h3>核心理念</h3>
              <p>融智于用</p>
            </div>
            <div class="concept-item">
              <span class="concept-icon">❤️</span>
              <h3>服务宗旨</h3>
              <p>用心创造价值，真诚赢得信赖</p>
            </div>
          </div>
        </div>
        <div class="intro-visual">
          <div class="stat-box">
            <div class="stat-number">2010</div>
            <div class="stat-label">创立年份</div>
          </div>
        </div>
      </div>
      </div>
    </section>

    <!-- Vision & Mission Section -->
    <section class="vision-section section bg-gray-50">
      <div class="container">
        <div class="vision-grid">
          <div class="vision-card">
            <div class="vision-icon">🎯</div>
            <h3>企业愿景</h3>
            <p>成为国内领先的数字科技服务商</p>
          </div>
          <div class="vision-card">
            <div class="vision-icon">🚀</div>
            <h3>企业使命</h3>
            <p>用技术赋能企业数字化转型</p>
          </div>
          <div class="vision-card">
            <div class="vision-icon">💎</div>
            <h3>核心价值观</h3>
            <p>诚信、创新、专业、共赢</p>
          </div>
        </div>
      </div>
    </section>

    <!-- Tech Stack Section -->
    <section class="tech-section section">
      <div class="container">
        <div class="section-header">
          <h2 class="section-title">技术与研发体系</h2>
          <p class="section-subtitle">完整技术栈，自主研发能力</p>
        </div>
        <div class="tech-grid">
          <div v-for="tech in techStack" :key="tech.name" class="tech-item">
            <span class="tech-icon">{{ tech.icon }}</span>
            <span class="tech-name">{{ tech.name }}</span>
          </div>
        </div>
        <div class="tech-desc">
          <p>我们拥有AI、大数据、信创、信息安全、云计算、区块链等核心技术栈，具备强大的自主研发能力和技术团队配置。</p>
        </div>
      </div>
    </section>

    <!-- Industries Section -->
    <section class="industries-section section bg-gray-50">
      <div class="container">
        <div class="section-header">
          <h2 class="section-title">服务行业覆盖</h2>
          <p class="section-subtitle">深耕多个行业，深度理解不同行业的业务特点</p>
        </div>
        <div class="industries-grid">
          <div v-for="industry in industries" :key="industry.name" class="industry-card">
            <span class="industry-icon">{{ industry.icon }}</span>
            <span class="industry-name">{{ industry.name }}</span>
          </div>
        </div>
      </div>
    </section>

    <!-- Timeline Section -->
    <section class="timeline-section section">
      <div class="container">
        <div class="section-header">
          <h2 class="section-title">发展历程</h2>
          <p class="section-subtitle">15年砥砺前行，持续创新发展</p>
        </div>
        <div class="timeline">
          <div v-for="(milestone, index) in milestones" :key="index" class="timeline-item">
            <div class="timeline-year">{{ milestone.year }}</div>
            <div class="timeline-content">
              <h3>{{ milestone.title }}</h3>
              <p>{{ milestone.description }}</p>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script setup lang="ts">
import { useHead } from '@vueuse/head'

useHead({
  title: '关于我们 - 申朴信息',
  meta: [
    { name: 'description', content: '了解申朴信息的发展历程、技术实力、服务理念，2010年创立，15年行业深耕。' }
  ]
})

const techStack = [
  { name: 'AI人工智能', icon: '🤖' },
  { name: '大数据', icon: '📊' },
  { name: '信创', icon: '🖥️' },
  { name: '信息安全', icon: '🛡️' },
  { name: '云计算', icon: '☁️' },
  { name: '区块链', icon: '⛓️' }
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

const milestones = [
  {
    year: '2010',
    title: '公司创立',
    description: '上海申朴信息技术有限公司正式成立，开始金融科技领域。'
  },
  {
    year: '2015',
    title: '业务拓展',
    description: '拓展金融行业服务客户，建立行业经验积累。'
  },
  {
    year: '2018',
    title: '技术升级',
    description: '开始AI与大数据技术布局，自主研发产品。'
  },
  {
    year: '2020',
    title: '新三板挂牌',
    description: '成功挂牌新三板，开启资本市场新篇章。'
  },
  {
    year: '2023',
    title: '全面发展',
    description: '全国25+城市服务网络，500+专业团队。'
  }
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

.intro-section {
  padding: 80px 0;
}

.intro-content {
  display: grid;
  grid-template-columns: 2fr 1fr;
  gap: 4rem;
  align-items: center;
}

.intro-desc {
  font-size: 1.125rem;
  line-height: 1.8;
  color: #475569;
  margin-bottom: 2rem;
}

.concepts-grid {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 1.5rem;
  margin-top: 2rem;
}

.concept-item {
  text-align: center;
  padding: 1.5rem;
  background: #f8fafc;
  border-radius: 1rem;
}

.concept-icon {
  font-size: 2rem;
  margin-bottom: 0.75rem;
}

.concept-item h3 {
  font-size: 1.125rem;
  font-weight: 700;
  color: #0c4a6e;
  margin-bottom: 0.5rem;
}

.concept-item p {
  color: #64748b;
}

.intro-visual {
  display: flex;
  justify-content: center;
}

.stat-box {
  padding: 3rem;
  background: linear-gradient(135deg, #0ea5e9, #22c55e);
  border-radius: 1.5rem;
  text-align: center;
  color: white;
}

.stat-number {
  font-size: 4rem;
  font-weight: 800;
  margin-bottom: 0.5rem;
}

.stat-label {
  font-size: 1.25rem;
  opacity: 0.9;
}

.vision-section {
  background: #f8fafc;
  padding: 80px 0;
}

.vision-grid {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 2rem;
}

.vision-card {
  padding: 2.5rem;
  background: white;
  border-radius: 1.5rem;
  text-align: center;
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.08);
}

.vision-icon {
  font-size: 3rem;
  margin-bottom: 1rem;
}

.vision-card h3 {
  font-size: 1.5rem;
  font-weight: 700;
  color: #0c4a6e;
  margin-bottom: 0.75rem;
}

.vision-card p {
  color: #64748b;
  font-size: 1.125rem;
}

.tech-section {
  padding: 80px 0;
}

.tech-grid {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 1.5rem;
  margin-bottom: 2rem;
}

.tech-item {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 2rem;
  background: white;
  border-radius: 1rem;
  border: 1px solid #e2e8f0;
  text-align: center;
}

.tech-icon {
  font-size: 2.5rem;
  margin-bottom: 1rem;
}

.tech-name {
  font-weight: 600;
  color: #0c4a6e;
}

.tech-desc {
  text-align: center;
  max-width: 800px;
  margin: 0 auto;
}

.tech-desc p {
  font-size: 1.125rem;
  color: #64748b;
  line-height: 1.8;
}

.industries-section {
  background: #f8fafc;
  padding: 80px 0;
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

.timeline-section {
  padding: 80px 0;
}

.timeline {
  max-width: 800px;
  margin: 0 auto;
}

.timeline-item {
  display: flex;
  gap: 2rem;
  margin-bottom: 2rem;
  position: relative;

  &::before {
    content: '';
    position: absolute;
    left: 59px;
  top: 40px;
    bottom: -2rem;
    width: 2px;
    background: #e2e8f0;
  }

  &:last-child::before {
    display: none;
  }
}

.timeline-year {
  flex-shrink: 0;
  width: 80px;
  height: 80px;
  background: linear-gradient(135deg, #0ea5e9, #22c55e);
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  color: white;
  font-size: 1.25rem;
  font-weight: 700;
}

.timeline-content {
  flex: 1;
  padding: 1.5rem;
  background: white;
  border-radius: 1rem;
  border: 1px solid #e2e8f0;
}

.timeline-content h3 {
  font-size: 1.25rem;
  font-weight: 700;
  color: #0c4a6e;
  margin-bottom: 0.5rem;
}

.timeline-content p {
  color: #64748b;
}

@media (max-width: 1024px) {
  .intro-content {
    grid-template-columns: 1fr;
  }

  .concepts-grid {
    grid-template-columns: 1fr;
  }

  .vision-grid {
    grid-template-columns: 1fr;
  }

  .tech-grid {
    grid-template-columns: repeat(2, 1fr);
  }

  .industries-grid {
    grid-template-columns: repeat(2, 1fr);
  }
}

@media (max-width: 768px) {
  .page-title {
    font-size: 2rem;
  }

  .tech-grid {
    grid-template-columns: 1fr;
  }

  .industries-grid {
    grid-template-columns: repeat(2, 1fr);
  }

  .timeline-item {
    flex-direction: column;
    text-align: center;

    &::before {
      display: none;
    }
  }
}
</style>
