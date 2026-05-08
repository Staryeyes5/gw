<template>
  <header class="header" :class="{ 'header-scrolled': isScrolled }">
    <div class="container">
      <nav class="nav">
        <router-link to="/" class="logo">
          <span class="logo-text">{{ siteStore.companyName }}</span>
          <span class="logo-stock" v-if="siteStore.stockCode">{{ siteStore.stockCode }}</span>
        </router-link>

        <div class="nav-menu" :class="{ 'nav-menu-open': isMenuOpen }">
          <router-link 
            v-for="item in navItems" 
            :key="item.path"
            :to="item.path" 
            class="nav-link"
            :class="{ 'nav-link-active': $route.path === item.path }"
            @click="isMenuOpen = false"
          >
            {{ item.label }}
          </router-link>
          
          <router-link to="/contact" class="btn btn-primary ml-4" @click="isMenuOpen = false">
            联系我们
          </router-link>
        </div>

        <button class="menu-toggle" @click="isMenuOpen = !isMenuOpen">
          <span class="hamburger" :class="{ 'hamburger-open': isMenuOpen }"></span>
        </button>
      </nav>
    </div>
  </header>
</template>

<script setup lang="ts">
import { ref, onMounted, onUnmounted } from 'vue'
import { useSiteStore } from '@/stores/site'

const siteStore = useSiteStore()
const isScrolled = ref(false)
const isMenuOpen = ref(false)

const navItems = [
  { path: '/', label: '首页' },
  { path: '/services', label: '核心业务' },
  { path: '/products', label: '产品方案' },
  { path: '/qualifications', label: '企业实力' },
  { path: '/about', label: '关于我们' }
]

const handleScroll = () => {
  isScrolled.value = window.scrollY > 50
}

onMounted(() => {
  window.addEventListener('scroll', handleScroll)
})

onUnmounted(() => {
  window.removeEventListener('scroll', handleScroll)
})
</script>

<style scoped lang="scss">
.header {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  z-index: 1000;
  background: rgba(255, 255, 255, 0.95);
  backdrop-filter: blur(10px);
  transition: all 0.3s ease;
  border-bottom: 1px solid transparent;
}

.header-scrolled {
  box-shadow: 0 2px 20px rgba(0, 0, 0, 0.1);
  border-bottom-color: var(--border-color);
}

.nav {
  display: flex;
  align-items: center;
  justify-content: space-between;
  height: 70px;
}

.logo {
  display: flex;
  align-items: center;
  gap: 0.5rem;
  font-weight: 700;
  font-size: 1.25rem;
  color: var(--text-color);
  text-decoration: none;
  
  &:hover {
    color: var(--primary-color);
  }
}

.logo-text {
  color: #0c4a6e;
}

.logo-stock {
  font-size: 0.75rem;
  padding: 0.25rem 0.5rem;
  background: #22c55e;
  color: white;
  border-radius: 4px;
}

.nav-menu {
  display: flex;
  align-items: center;
  gap: 2rem;
}

.nav-link {
  color: var(--text-color);
  text-decoration: none;
  font-weight: 500;
  transition: color 0.3s;
  position: relative;
  
  &:hover {
    color: var(--primary-color);
  }
  
  &::after {
    content: '';
    position: absolute;
    bottom: -4px;
    left: 0;
    width: 0;
    height: 2px;
    background: var(--primary-color);
    transition: width 0.3s;
  }
  
  &:hover::after,
  &.nav-link-active::after {
    width: 100%;
  }
}

.nav-link-active {
  color: var(--primary-color);
}

.menu-toggle {
  display: none;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 40px;
  height: 40px;
  background: none;
  border: none;
  cursor: pointer;
  padding: 0;
}

.hamburger {
  width: 24px;
  height: 2px;
  background: var(--text-color);
  position: relative;
  transition: all 0.3s;
  
  &::before,
  &::after {
    content: '';
    position: absolute;
    width: 24px;
    height: 2px;
    background: var(--text-color);
    transition: all 0.3s;
  }
  
  &::before {
    top: -6px;
  }
  
  &::after {
    top: 6px;
  }
}

.hamburger-open {
  background: transparent;
  
  &::before {
    transform: rotate(45deg);
    top: 0;
  }
  
  &::after {
    transform: rotate(-45deg);
    top: 0;
  }
}

@media (max-width: 768px) {
  .nav-menu {
    position: fixed;
    top: 70px;
    left: 0;
    right: 0;
    background: white;
    flex-direction: column;
    padding: 2rem;
    gap: 1.5rem;
    transform: translateY(-100%);
    opacity: 0;
    visibility: hidden;
    transition: all 0.3s;
    box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
  }
  
  .nav-menu-open {
    transform: translateY(0);
    opacity: 1;
    visibility: visible;
  }
  
  .menu-toggle {
    display: flex;
  }
}
</style>
