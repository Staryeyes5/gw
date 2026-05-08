<template>
  <div class="qualifications-page">
    <!-- Page Header -->
    <section class="page-header">
      <div class="container">
        <h1 class="page-title">企业实力与资质荣誉</h1>
        <p class="page-subtitle">权威资质认证，行业荣誉认可，彰显企业实力</p>
      </div>
    </section>

    <!-- Qualifications Section -->
    <section class="qualifications-section section">
      <div class="container">
        <div class="section-header">
          <h2 class="section-title">权威资质认证</h2>
          <p class="section-subtitle">技术实力与服务能力获得官方与行业权威认可</p>
        </div>
        <div class="qualifications-grid">
          <div v-for="(qual, index) in qualifications" :key="index" class="qual-card">
            <div class="qual-icon-wrapper">
              <span class="qual-icon">{{ qual.icon }}</span>
            </div>
            <h3 class="qual-name">{{ qual.name }}</h3>
            <p class="qual-authority" v-if="qual.authority">{{ qual.authority }}</p>
            <p class="qual-desc">{{ qual.description }}</p>
          </div>
        </div>
      </div>
    </section>

    <!-- Awards Section -->
    <section class="awards-section section bg-gray-50">
      <div class="container">
        <div class="section-header">
          <h2 class="section-title">荣誉奖项</h2>
          <p class="section-subtitle">行业认可与资本市场荣誉，印证企业成长性</p>
        </div>
        <div class="awards-grid">
          <div v-for="(award, index) in awards" :key="index" class="award-card">
            <div class="award-year">{{ award.year }}</div>
            <div class="award-content">
              <h3 class="award-name">{{ award.name }}</h3>
              <p class="award-organization">{{ award.organization }}</p>
              <p class="award-desc">{{ award.description }}</p>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- Strengths Section -->
    <section class="strengths-section section">
      <div class="container">
        <div class="section-header">
          <h2 class="section-title">核心优势</h2>
          <p class="section-subtitle">15年行业深耕，铸就核心竞争力</p>
        </div>
        <div class="strengths-grid">
          <div v-for="(strength, index) in strengths" :key="index" class="strength-item">
            <div class="strength-number">{{ index + 1 }}</div>
            <div class="strength-content">
              <h3 class="strength-title">{{ strength.title }}</h3>
              <p class="strength-desc">{{ strength.description }}</p>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- Stats Section -->
    <section class="stats-section section">
      <div class="container">
        <div class="stats-grid">
          <div v-for="stat in stats" :key="stat.label" class="stat-card">
            <div class="stat-value">{{ stat.value }}</div>
            <div class="stat-label">{{ stat.label }}</div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script setup lang="ts">
import { useHead } from '@vueuse/head'

useHead({
  title: '企业实力与资质荣誉 - 申朴信息',
  meta: [
    { name: 'description', content: '申朴信息拥有高新技术企业、软件企业认定、专精特新中小企业等权威资质认证。' }
  ]
})

const qualifications = [
  {
    name: '高新技术企业',
    authority: '国家科学技术部',
    description: '国家认定的高新技术企业，具备持续的技术创新能力',
    icon: '🏆'
  },
  {
    name: '软件企业认定',
    authority: '软件行业协会',
    description: '专业软件企业资质，具备成熟的软件研发与服务能力',
    icon: '💻'
  },
  {
    name: '专精特新中小企业',
    authority: '国家工信部',
    description: '专业化、精细化、特色化、创新型中小企业认定',
    icon: '⭐'
  },
  {
    name: 'ISO9001质量管理体系认证',
    authority: '国际认证机构',
    description: '国际标准质量管理体系认证，确保服务质量稳定可靠',
    icon: '✅'
  },
  {
    name: 'ISO27001信息安全管理体系认证',
    authority: '国际认证机构',
    description: '国际信息安全管理体系认证，保障客户信息安全',
    icon: '🛡️'
  },
  {
    name: '华为生态服务商资质',
    authority: '华为技术有限公司',
    description: '华为云、华为鲲鹏生态合作伙伴，深度技术合作',
    icon: '🤝'
  },
  {
    name: '人力资源服务许可证',
    authority: '人力资源和社会保障局',
    description: '具备合法的人力资源服务与劳务派遣经营资质',
    icon: '👥'
  },
  {
    name: '劳务派遣经营许可证',
    authority: '人力资源和社会保障局',
    description: '正规劳务派遣经营资质，合规开展外包服务',
    icon: '📋'
  }
]

const awards = [
  {
    name: '中国创新创业大赛优胜奖',
    organization: '中国创新创业大赛组委会',
    year: 2023,
    description: '在全国性创新创业赛事中获得优异成绩'
  },
  {
    name: '北交所&新三板年度风云榜',
    organization: '全国中小企业股份转让系统',
    year: 2023,
    description: '新三板挂牌企业年度成长性荣誉'
  },
  {
    name: '上海市人工智能行业协会会员单位',
    organization: '上海市人工智能行业协会',
    year: 2023,
    description: 'AI行业协会会员，深度参与行业交流与合作'
  },
  {
    name: '金融科技创新奖',
    organization: '金融科技行业协会',
    year: 2022,
    description: '在金融科技创新领域获得的重要荣誉'
  }
]

const strengths = [
  {
    title: '15年行业深耕经验',
    description: '2010年创立以来，持续专注金融科技与企业数字化转型服务，积累了丰富的行业经验与客户案例。'
  },
  {
    title: '完整技术体系',
    description: '拥有AI、大数据、信创、信息安全、云计算、区块链等完整的技术栈，具备全栈技术服务能力。'
  },
  {
    title: '自研产品矩阵',
    description: '从APM可观测平台到金融科技解决方案，构建了完整的自研产品生态，具备强大的产品化能力。'
  },
  {
    title: '规模化服务能力',
    description: '全国25+城市服务网络，500+专业团队，服务数百家行业头部客户，具备规模化交付能力。'
  },
  {
    title: '多行业服务经验',
    description: '深度服务银行、保险、证券、互联网、新型制造等多个行业，深刻理解不同行业的业务特点与需求。'
  },
  {
    title: '规范化管理体系',
    description: '通过多项ISO体系认证，建立了规范化的项目管理与质量控制体系，确保服务质量稳定可靠。'
  }
]

const stats = [
  { value: '15+', label: '年行业经验' },
  { value: '25+', label: '城市覆盖' },
  { value: '500+', label: '专业团队' },
  { value: '数百家', label: '合作客户' }
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

.qualifications-section {
  padding: 80px 0;
}

.qualifications-grid {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 1.5rem;
}

.qual-card {
  padding: 2rem;
  background: white;
  border-radius: 1rem;
  text-align: center;
  border: 1px solid #e2e8f0;
  transition: all 0.3s;

  &:hover {
    transform: translateY(-4px);
    box-shadow: 0 8px 25px rgba(0, 0, 0, 0.1);
  }
}

.qual-icon-wrapper {
  display: inline-flex;
  padding: 1.25rem;
  background: linear-gradient(135deg, #dbeafe, #dcfce7);
  border-radius: 1rem;
  margin-bottom: 1rem;
}

.qual-icon {
  font-size: 2.5rem;
}

.qual-name {
  font-size: 1.125rem;
  font-weight: 700;
  color: #0c4a6e;
  margin-bottom: 0.5rem;
}

.qual-authority {
  font-size: 0.875rem;
  color: #64748b;
  margin-bottom: 0.5rem;
}

.qual-desc {
  font-size: 0.875rem;
  color: #64748b;
  line-height: 1.6;
}

.awards-section {
  background: #f8fafc;
  padding: 80px 0;
}

.awards-grid {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 1.5rem;
}

.award-card {
  display: flex;
  gap: 1.5rem;
  padding: 2rem;
  background: white;
  border-radius: 1rem;
  border: 1px solid #e2e8f0;
  transition: all 0.3s;

  &:hover {
    transform: translateY(-4px);
    box-shadow: 0 8px 25px rgba(0, 0, 0, 0.1);
  }
}

.award-year {
  flex-shrink: 0;
  width: 80px;
  height: 80px;
  background: linear-gradient(135deg, #0ea5e9, #22c55e);
  border-radius: 1rem;
  display: flex;
  align-items: center;
  justify-content: center;
  color: white;
  font-size: 1.5rem;
  font-weight: 800;
}

.award-content {
  flex: 1;
}

.award-name {
  font-size: 1.25rem;
  font-weight: 700;
  color: #0c4a6e;
  margin-bottom: 0.5rem;
}

.award-organization {
  font-size: 0.875rem;
  color: #64748b;
  margin-bottom: 0.5rem;
}

.award-desc {
  font-size: 0.875rem;
  color: #64748b;
  line-height: 1.6;
}

.strengths-section {
  padding: 80px 0;
}

.strengths-grid {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 2rem;
}

.strength-item {
  display: flex;
  gap: 1.5rem;
  padding: 2rem;
  background: white;
  border-radius: 1rem;
  border: 1px solid #e2e8f0;
}

.strength-number {
  flex-shrink: 0;
  width: 60px;
  height: 60px;
  background: linear-gradient(135deg, #0ea5e9, #22c55e);
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  color: white;
  font-size: 1.5rem;
  font-weight: 800;
}

.strength-content {
  flex: 1;
}

.strength-title {
  font-size: 1.25rem;
  font-weight: 700;
  color: #0c4a6e;
  margin-bottom: 0.75rem;
}

.strength-desc {
  color: #64748b;
  line-height: 1.7;
}

.stats-section {
  padding: 60px 0;
  background: linear-gradient(135deg, #0c4a6e 0%, #075985 100%);
}

.stats-grid {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 2rem;
}

.stat-card {
  text-align: center;
  color: white;
}

.stat-value {
  font-size: 3rem;
  font-weight: 800;
  margin-bottom: 0.5rem;
}

.stat-label {
  font-size: 1.125rem;
  opacity: 0.9;
}

@media (max-width: 1024px) {
  .qualifications-grid {
    grid-template-columns: repeat(2, 1fr);
  }
  
  .awards-grid {
    grid-template-columns: 1fr;
  }
  
  .strengths-grid {
    grid-template-columns: 1fr;
  }
  
  .stats-grid {
    grid-template-columns: repeat(2, 1fr);
  }
}

@media (max-width: 768px) {
  .page-title {
    font-size: 2rem;
  }
  
  .qualifications-grid {
    grid-template-columns: 1fr;
  }
  
  .award-card {
    flex-direction: column;
    text-align: center;
  }
  
  .strength-item {
    flex-direction: column;
    text-align: center;
  }
  
  .stats-grid {
    grid-template-columns: 1fr;
  }
}
</style>
