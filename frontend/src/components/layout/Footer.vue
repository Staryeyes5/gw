<template>
  <footer class="footer">
    <div class="container">
      <div class="footer-grid">
        <div class="footer-col">
          <div class="footer-logo">
            <span class="logo-text">{{ siteStore.companyName }}</span>
            <span class="logo-stock" v-if="siteStore.stockCode">{{ siteStore.stockCode }}</span>
          </div>
          <p class="footer-desc">
            国内领先的金融科技与企业数字化转型解决方案服务商，15年行业深耕经验。
          </p>
        </div>

        <div class="footer-col">
          <h4 class="footer-title">核心业务</h4>
          <ul class="footer-links">
            <li><router-link to="/services">数字化转型</router-link></li>
            <li><router-link to="/services">AI赋能服务</router-link></li>
            <li><router-link to="/services">信息安全</router-link></li>
            <li><router-link to="/services">信创适配</router-link></li>
          </ul>
        </div>

        <div class="footer-col">
          <h4 class="footer-title">产品方案</h4>
          <ul class="footer-links">
            <li><router-link to="/products">APM可观测平台</router-link></li>
            <li><router-link to="/products">AI辅助编程</router-link></li>
            <li><router-link to="/products">金融科技解决方案</router-link></li>
            <li><router-link to="/products">安全与信创产品</router-link></li>
          </ul>
        </div>

        <div class="footer-col">
          <h4 class="footer-title">联系我们</h4>
          <ul class="footer-contact">
            <li class="contact-item">
              <span class="contact-icon">📞</span>
              <span>{{ siteStore.contactPhone }}</span>
            </li>
            <li class="contact-item">
              <span class="contact-icon">✉️</span>
              <span>{{ siteStore.contactEmail }}</span>
            </li>
            <li class="contact-item">
              <span class="contact-icon">📍</span>
              <span>{{ siteStore.companyInfo?.address || '上海市浦东新区' }}</span>
            </li>
          </ul>
        </div>
      </div>

      <div class="footer-bottom">
        <div class="footer-copyright">
          {{ siteStore.companyInfo?.copyright || '© 2024 上海申朴信息技术股份有限公司' }}
        </div>
        <div class="footer-icp">
          {{ siteStore.companyInfo?.icp || '沪ICP备XXXXXXXX号' }}
        </div>
      </div>
    </div>
  </footer>
</template>

<script setup lang="ts">
import { useSiteStore } from '@/stores/site'

const siteStore = useSiteStore()
</script>

<style scoped lang="scss">
.footer {
  background: linear-gradient(135deg, #0c4a6e 0%, #075985 100%);
  color: white;
  padding: 4rem 0 2rem;
  margin-top: auto;
}

.footer-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  gap: 2rem;
  margin-bottom: 3rem;
}

.footer-logo {
  display: flex;
  align-items: center;
  gap: 0.5rem;
  margin-bottom: 1rem;
}

.logo-text {
  font-size: 1.25rem;
  font-weight: 700;
}

.logo-stock {
  font-size: 0.75rem;
  padding: 0.25rem 0.5rem;
  background: #22c55e;
  color: white;
  border-radius: 4px;
}

.footer-desc {
  color: rgba(255, 255, 255, 0.8);
  line-height: 1.7;
}

.footer-title {
  font-size: 1.125rem;
  font-weight: 600;
  margin-bottom: 1.5rem;
}

.footer-links {
  list-style: none;
  padding: 0;
  margin: 0;
}

.footer-links li {
  margin-bottom: 0.75rem;
}

.footer-links a {
  color: rgba(255, 255, 255, 0.8);
  text-decoration: none;
  transition: color 0.3s;
  
  &:hover {
    color: white;
  }
}

.footer-contact {
  list-style: none;
  padding: 0;
  margin: 0;
}

.contact-item {
  display: flex;
  align-items: flex-start;
  gap: 0.75rem;
  margin-bottom: 1rem;
  color: rgba(255, 255, 255, 0.8);
}

.contact-icon {
  font-size: 1.25rem;
  margin-top: 2px;
}

.footer-bottom {
  padding-top: 2rem;
  border-top: 1px solid rgba(255, 255, 255, 0.1);
  display: flex;
  justify-content: space-between;
  align-items: center;
  flex-wrap: wrap;
  gap: 1rem;
}

.footer-copyright,
.footer-icp {
  color: rgba(255, 255, 255, 0.6);
  font-size: 0.875rem;
}

@media (max-width: 768px) {
  .footer-grid {
    grid-template-columns: 1fr;
  }
  
  .footer-bottom {
    flex-direction: column;
    text-align: center;
  }
}
</style>
