import { createRouter, createWebHistory } from 'vue-router'
import type { RouteRecordRaw } from 'vue-router'

const routes: RouteRecordRaw[] = [
  {
    path: '/',
    name: 'Home',
    component: () => import('@/views/Home.vue'),
    meta: {
      title: '申朴信息 - 国内领先金融科技解决方案专家',
      description: '申朴信息是国内领先的金融科技与企业数字化转型解决方案服务商，15年行业深耕经验。'
    }
  },
  {
    path: '/services',
    name: 'Services',
    component: () => import('@/views/Services.vue'),
    meta: {
      title: '核心业务体系 - 申朴信息',
      description: '申朴信息提供数字化转型、AI赋能、信息安全、信创适配、ITO/BPO外包等五大核心业务服务。'
    }
  },
  {
    path: '/products',
    name: 'Products',
    component: () => import('@/views/Products.vue'),
    meta: {
      title: '产品与解决方案 - 申朴信息',
      description: '申朴信息自研产品矩阵：APM可观测平台、AI辅助编程、领域模型训练、AI智能招投标助手等。'
    }
  },
  {
    path: '/qualifications',
    name: 'Qualifications',
    component: () => import('@/views/Qualifications.vue'),
    meta: {
      title: '企业实力与资质荣誉 - 申朴信息',
      description: '申朴信息拥有高新技术企业、软件企业认定、专精特新中小企业等权威资质认证。'
    }
  },
  {
    path: '/about',
    name: 'About',
    component: () => import('@/views/About.vue'),
    meta: {
      title: '关于我们 - 申朴信息',
      description: '了解申朴信息的发展历程、技术实力、服务理念，2010年创立，15年行业深耕。'
    }
  },
  {
    path: '/contact',
    name: 'Contact',
    component: () => import('@/views/Contact.vue'),
    meta: {
      title: '联系我们 - 申朴信息',
      description: '联系申朴信息，全国25+城市服务网络，专业团队为您提供咨询服务。'
    }
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
  scrollBehavior(to, from, savedPosition) {
    if (savedPosition) {
      return savedPosition
    } else {
      return { top: 0 }
    }
  }
})

router.beforeEach((to, from, next) => {
  document.title = to.meta.title as string || '申朴信息'
  
  const metaDescription = document.querySelector('meta[name="description"]')
  if (metaDescription && to.meta.description) {
    metaDescription.setAttribute('content', to.meta.description as string)
  }
  
  next()
})

export default router
