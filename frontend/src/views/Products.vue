<template>
  <div class="products-page">
    <!-- Page Header -->
    <section class="page-header">
      <div class="container">
        <h1 class="page-title">产品与解决方案</h1>
        <p class="page-subtitle">自研产品矩阵 + 行业解决方案，全方位赋能企业数字化</p>
      </div>
    </section>

    <!-- Category Tabs -->
    <section class="category-tabs">
      <div class="container">
        <div class="tabs">
          <button 
            v-for="cat in categories" 
            :key="cat.id"
            class="tab-button"
            :class="{ 'tab-active': activeCategory === cat.id }"
            @click="activeCategory = cat.id"
          >
            {{ cat.name }}
          </button>
        </div>
      </div>
    </section>

    <!-- Products Section -->
    <section class="products-section section">
      <div class="container">
        <div class="section-header">
          <h2 class="section-title">自研产品矩阵</h2>
          <p class="section-subtitle">从平台到应用，完整的产品生态体系</p>
        </div>
        <div class="products-grid tech-grid">
          <div 
            v-for="product in filteredProducts" 
            :key="product.id"
            class="product-card card"
          >
            <div class="product-icon-wrapper">
              <span class="product-icon">{{ product.icon }}</span>
            </div>
            <span class="product-badge">{{ product.category }}</span>
            <h3 class="product-name">{{ product.name }}</h3>
            <p class="product-description">{{ product.description }}</p>
            <div class="product-features" v-if="product.features">
              <span v-for="(feature, idx) in product.features" :key="idx" class="feature-tag">
                {{ feature }}
              </span>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- Solutions Section -->
    <section class="solutions-section section bg-gray-50">
      <div class="container">
        <div class="section-header">
          <h2 class="section-title">行业解决方案</h2>
          <p class="section-subtitle">针对不同行业的深度定制化解决方案</p>
        </div>
        <div class="solutions-grid">
          <div v-for="solution in solutions" :key="solution.id" class="solution-card">
            <div class="solution-header">
              <span class="solution-icon">{{ solution.icon }}</span>
              <span class="solution-industry">{{ solution.industry }}</span>
            </div>
            <h3 class="solution-title">{{ solution.title }}</h3>
            <p class="solution-desc">{{ solution.description }}</p>
            <div class="solution-points">
              <div v-for="(point, idx) in solution.points" :key="idx" class="point-item">
                <span class="point-dot"></span>
                <span>{{ point }}</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script setup lang="ts">
import { ref, computed } from 'vue'
import { useHead } from '@vueuse/head'

useHead({
  title: '产品与解决方案 - 申朴信息',
  meta: [
    { name: 'description', content: '申朴信息自研产品矩阵：APM可观测平台、AI辅助编程、领域模型训练、AI智能招投标助手等。' }
  ]
})

const activeCategory = ref('all')

const categories = [
  { id: 'all', name: '全部' },
  { id: 'ai', name: 'AI赋能' },
  { id: 'finance', name: '金融科技' },
  { id: 'security', name: '安全信创' }
]

const products = ref([
  {
    id: 1,
    name: 'APM可观测平台',
    description: '全链路应用性能监控与可观测性解决方案，帮助企业实时掌握系统运行状态。',
    icon: '📈',
    category: 'AI赋能',
    categoryId: 'ai',
    features: ['性能监控', '链路追踪', '日志分析', '告警管理']
  },
  {
    id: 2,
    name: 'AI辅助编程',
    description: '智能化代码生成与编程辅助工具，大幅提升开发效率。',
    icon: '💻',
    category: 'AI赋能',
    categoryId: 'ai',
    features: ['代码生成', '代码补全', '代码审查', '智能提示']
  },
  {
    id: 3,
    name: '领域模型训练',
    description: '垂直领域大模型训练与定制服务，打造企业专属AI能力。',
    icon: '🧠',
    category: 'AI赋能',
    categoryId: 'ai',
    features: ['模型训练', '微调优化', '部署服务', '持续迭代']
  },
  {
    id: 4,
    name: 'AI智能招投标助手',
    description: '基于AI的招投标文件智能生成与分析工具。',
    icon: '📋',
    category: 'AI赋能',
    categoryId: 'ai',
    features: ['智能撰写', '文件分析', '方案推荐', '风险预警']
  },
  {
    id: 5,
    name: 'SHS健康小站平台',
    description: '智慧健康管理平台，提供全方位健康监测与服务。',
    icon: '🏥',
    category: 'AI赋能',
    categoryId: 'ai',
    features: ['健康监测', '数据分析', '智能预警', '健康报告']
  },
  {
    id: 6,
    name: 'SME中小微产业金融系统',
    description: '中小微企业金融服务数字化解决方案，助力普惠金融发展。',
    icon: '🏦',
    category: '金融科技',
    categoryId: 'finance',
    features: ['信贷管理', '风险评估', '客户画像', '流程自动化']
  },
  {
    id: 7,
    name: '业财一体化BI数据平台',
    description: '企业业务与财务数据一体化分析与决策支持平台。',
    icon: '📊',
    category: '金融科技',
    categoryId: 'finance',
    features: ['数据整合', '智能分析', '可视化报表', '预测洞察']
  },
  {
    id: 8,
    name: '数据资产治理与建模',
    description: '企业数据资产全生命周期管理与价值挖掘解决方案。',
    icon: '💾',
    category: '金融科技',
    categoryId: 'finance',
    features: ['数据治理', '数据建模', '数据质量', '数据安全']
  },
  {
    id: 9,
    name: '人力资源管理SaaS平台',
    description: '智能化人力资源管理云平台，提升HR管理效率。',
    icon: '👥',
    category: '金融科技',
    categoryId: 'finance',
    features: ['招聘管理', '绩效考核', '薪酬福利', '培训发展']
  },
  {
    id: 10,
    name: '移动安全SaaS服务平台',
    description: '企业移动应用全生命周期安全管理云服务平台。',
    icon: '📱',
    category: '安全信创',
    categoryId: 'security',
    features: ['安全检测', '漏洞扫描', '安全加固', '合规评估']
  },
  {
    id: 11,
    name: '移动安全检测平台',
    description: '专业的移动应用安全检测与分析平台。',
    icon: '🔍',
    category: '安全信创',
    categoryId: 'security',
    features: ['静态检测', '动态检测', '隐私分析', '安全报告']
  },
  {
    id: 12,
    name: 'SQL代码智能审核',
    description: '基于AI的数据库SQL代码智能审核与优化工具。',
    icon: '🗄️',
    category: '安全信创',
    categoryId: 'security',
    features: ['语法检查', '性能优化', '安全审计', '规范校验']
  },
  {
    id: 13,
    name: '数据迁移与双向同步工具',
    description: '高效可靠的数据库迁移与数据同步解决方案。',
    icon: '🔄',
    category: '安全信创',
    categoryId: 'security',
    features: ['数据迁移', '双向同步', '增量同步', '数据校验']
  },
  {
    id: 14,
    name: '数据资产管理平台',
    description: '企业数据资产统一管理与价值释放平台。',
    icon: '📊',
    category: '安全信创',
    categoryId: 'security',
    features: ['资产盘点', '元数据管理', '血缘分析', '数据目录']
  }
])

const solutions = ref([
  {
    id: 1,
    title: 'SME中小微产业金融解决方案',
    description: '为中小微企业提供全方位金融服务数字化解决方案',
    icon: '🏦',
    industry: '金融',
    points: [
      '智能风控体系',
      '全流程数字化',
      '多维度客户画像',
      '灵活产品配置'
    ]
  },
  {
    id: 2,
    title: '业财一体化数据解决方案',
    description: '打破业务与财务数据壁垒，实现数据驱动决策',
    icon: '📊',
    industry: '通用',
    points: [
      '数据统一接入',
      '实时数据处理',
      '智能分析引擎',
      '可视化决策支持'
    ]
  },
  {
    id: 3,
    title: '数据资产治理解决方案',
    description: '构建企业数据资产治理体系，释放数据价值',
    icon: '💾',
    industry: '通用',
    points: [
      '数据标准体系',
      '数据质量管理',
      '数据安全管控',
      '数据价值评估'
    ]
  },
  {
    id: 4,
    title: '信创全流程适配解决方案',
    description: '助力企业完成信息技术应用创新转型',
    icon: '🖥️',
    industry: '信创',
    points: [
      '信创规划咨询',
      '系统迁移适配',
      '应用兼容改造',
      '信创人才培养'
    ]
  }
])

const filteredProducts = computed(() => {
  if (activeCategory.value === 'all') {
    return products.value
  }
  return products.value.filter(p => p.categoryId === activeCategory.value)
})
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

.category-tabs {
  background: white;
  padding: 2rem 0;
  border-bottom: 1px solid #e2e8f0;
  position: sticky;
  top: 70px;
  z-index: 100;
}

.tabs {
  display: flex;
  justify-content: center;
  gap: 1rem;
  flex-wrap: wrap;
}

.tab-button {
  padding: 0.75rem 1.5rem;
  background: #f1f5f9;
  border: none;
  border-radius: 50px;
  font-weight: 500;
  color: #475569;
  cursor: pointer;
  transition: all 0.3s;

  &:hover {
    background: #e2e8f0;
  }
}

.tab-active {
  background: linear-gradient(135deg, #0ea5e9, #22c55e);
  color: white;
}

.products-section {
  padding: 80px 0;
}

.product-card {
  padding: 2rem;
  text-align: center;
  transition: all 0.3s;

  &:hover {
    transform: translateY(-8px);
  }
}

.product-icon-wrapper {
  display: inline-flex;
  padding: 1.5rem;
  background: linear-gradient(135deg, #dbeafe, #dcfce7);
  border-radius: 1rem;
  margin-bottom: 1rem;
}

.product-icon {
  font-size: 3rem;
}

.product-badge {
  display: inline-block;
  padding: 0.25rem 0.75rem;
  background: #dbeafe;
  color: #0369a1;
  border-radius: 50px;
  font-size: 0.75rem;
  font-weight: 600;
  margin-bottom: 1rem;
}

.product-name {
  font-size: 1.25rem;
  font-weight: 700;
  color: #0c4a6e;
  margin-bottom: 0.75rem;
}

.product-description {
  color: #64748b;
  line-height: 1.7;
  margin-bottom: 1rem;
}

.product-features {
  display: flex;
  flex-wrap: wrap;
  gap: 0.5rem;
  justify-content: center;
}

.feature-tag {
  padding: 0.25rem 0.75rem;
  background: #f1f5f9;
  color: #475569;
  border-radius: 50px;
  font-size: 0.75rem;
}

.solutions-section {
  background: #f8fafc;
  padding: 80px 0;
}

.solutions-grid {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 2rem;
}

.solution-card {
  padding: 2.5rem;
  background: white;
  border-radius: 1.5rem;
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.08);
  transition: all 0.3s;

  &:hover {
    transform: translateY(-4px);
  }
}

.solution-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 1.5rem;
}

.solution-icon {
  font-size: 2.5rem;
}

.solution-industry {
  padding: 0.25rem 0.75rem;
  background: #dcfce7;
  color: #15803d;
  border-radius: 50px;
  font-size: 0.75rem;
  font-weight: 600;
}

.solution-title {
  font-size: 1.5rem;
  font-weight: 700;
  color: #0c4a6e;
  margin-bottom: 1rem;
}

.solution-desc {
  color: #64748b;
  line-height: 1.7;
  margin-bottom: 1.5rem;
}

.solution-points {
  display: flex;
  flex-direction: column;
  gap: 0.75rem;
}

.point-item {
  display: flex;
  align-items: center;
  gap: 0.75rem;
  color: #475569;
}

.point-dot {
  width: 8px;
  height: 8px;
  background: linear-gradient(135deg, #0ea5e9, #22c55e);
  border-radius: 50%;
}

@media (max-width: 1024px) {
  .solutions-grid {
    grid-template-columns: 1fr;
  }
}

@media (max-width: 768px) {
  .page-title {
    font-size: 2rem;
  }
  
  .tabs {
    gap: 0.5rem;
  }
  
  .tab-button {
    padding: 0.5rem 1rem;
    font-size: 0.875rem;
  }
}
</style>
