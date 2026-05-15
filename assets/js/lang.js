// ===== 全局语言切换功能 =====
// 支持所有页面的中英文切换

// 翻译字典 - 包含所有页面的文本
const translations = {
    zh: {
        // 导航菜单
        'nav.home': '首页',
        'nav.products': '核心产品',
        'nav.qualifications': '企业实力',
        'nav.joins': '招贤纳士',
        'nav.about': '关于我们',
        'nav.contact': '咨询合作',
        'nav.about-us': '关于申朴',
        'nav.news': '申朴资讯',
        
        // 首页 Banner
        'banner.title1': 'Cisetech',
        'banner.slogan1': '申朴AI・智创无限',
        'banner.desc1': 'AI 聚力数转智改，创领智能新生态',
        'banner.title2': '数字化转型',
        'banner.slogan2': '全栈式解决方案',
        'banner.desc2': '从咨询规划到落地实施，助力企业实现数字化升级',
        'banner.title3': '技术创新',
        'banner.slogan3': '前沿技术 · 无限可能',
        'banner.desc3': '深耕AI、大数据、云计算，打造企业核心竞争力',
        
        // 核心业务
        'section.core-business.title': '核心业务',
        'section.core-business.subtitle': '全栈AI能力，赋能企业智能化转型',
        'section.ai-consulting': '战略规划',
        'section.ai-infra': '解决方案',
        'section.ai-solutions': '产品',
        'section.talent': '人力资源配置与服务',
        
        // 关于我们
        'about.title': '关于申朴',
        'about.subtitle': '专注金融科技与企业数字化转型',
        'about.intro': '申朴信息技术（上海）股份有限公司',
        'about.mission': '我们的使命',
        'about.vision': '我们的愿景',
        'about.values': '核心价值观',
        'about.history': '发展历程',
        
        // 企业实力
        'qualifications.title': '企业实力',
        'qualifications.subtitle': '专业资质，值得信赖',
        'qualifications.certifications': '资质认证',
        'qualifications.honors': '荣誉奖项',
        
        // 核心产品
        'products.title': '核心产品',
        'products.subtitle': '创新产品，赋能业务',
        'products.simple-insight': 'Simple Insight',
        'products.muxi-gpu': '沐曦国产通用GPU',
        'products.oceanbase': 'OceanBase数据库',
        'products.ai-recruit': 'AI招聘助手',
        'products.ai-bidding': 'AI招投标助手',
        'products.ai-health': '职场健康加油站',
        
        // 招贤纳士
        'joins.title': '招贤纳士',
        'joins.subtitle': '加入我们，共创未来',
        'joins.positions': '热招职位',
        'joins.benefits': '员工福利',
        
        // 联系我们
        'contact.title': '联系我们',
        'contact.subtitle': '期待与您合作',
        'contact.info': '联系方式',
        'contact.address': '公司地址',
        'contact.phone': '联系电话',
        'contact.email': '电子邮箱',
        
        // 申朴资讯
        'news.title': '申朴资讯',
        'news.subtitle': '最新动态，了解申朴',
        'news.latest': '最新资讯',
        'news.more': '查看更多'
    },
    en: {
        // Navigation Menu
        'nav.home': 'Home',
        'nav.products': 'Core Products',
        'nav.qualifications': 'Qualifications',
        'nav.joins': 'Careers',
        'nav.about': 'About',
        'nav.contact': 'Contact',
        'nav.about-us': 'About Cisetech',
        'nav.news': 'News',
        
        // Home Banner
        'banner.title1': 'Cisetech',
        'banner.slogan1': 'AI Empowered, Infinite Innovation',
        'banner.desc1': 'AI driven digital transformation, creating intelligent ecosystem',
        'banner.title2': 'Digital Transformation',
        'banner.slogan2': 'Full-Stack Solutions',
        'banner.desc2': 'From consulting to implementation, enabling enterprise digital upgrade',
        'banner.title3': 'Technology Innovation',
        'banner.slogan3': 'Frontier Technology, Infinite Possibilities',
        'banner.desc3': 'Deep expertise in AI, Big Data, Cloud Computing, building core competitiveness',
        
        // Core Business
        'section.core-business.title': 'Core Business',
        'section.core-business.subtitle': 'Full-stack AI capabilities, empowering enterprise intelligent transformation',
        'section.ai-consulting': 'AI Consulting',
        'section.ai-infra': 'AI Infrastructure Services',
        'section.ai-solutions': 'AI Agent Development & Implementation',
        'section.talent': 'Talent Services',
        
        // About Us
        'about.title': 'About Cisetech',
        'about.subtitle': 'Focusing on Fintech and Enterprise Digital Transformation',
        'about.intro': 'Cisetech (Shanghai) Co., Ltd.',
        'about.mission': 'Our Mission',
        'about.vision': 'Our Vision',
        'about.values': 'Core Values',
        'about.history': 'Company History',
        
        // Qualifications
        'qualifications.title': 'Qualifications',
        'qualifications.subtitle': 'Professional Qualifications, Trustworthy',
        'qualifications.certifications': 'Certifications',
        'qualifications.honors': 'Honors & Awards',
        
        // Products
        'products.title': 'Core Products',
        'products.subtitle': 'Innovative Products, Empowering Business',
        'products.simple-insight': 'Simple Insight',
        'products.muxi-gpu': 'Maxxiri GPU',
        'products.oceanbase': 'OceanBase Database',
        'products.ai-recruit': 'AI Recruitment Assistant',
        'products.ai-bidding': 'AI Bidding Assistant',
        'products.ai-health': 'Workplace Health Station',
        
        // Careers
        'joins.title': 'Careers',
        'joins.subtitle': 'Join Us, Create the Future',
        'joins.positions': 'Open Positions',
        'joins.benefits': 'Employee Benefits',
        
        // Contact
        'contact.title': 'Contact Us',
        'contact.subtitle': 'Looking Forward to Working with You',
        'contact.info': 'Contact Information',
        'contact.address': 'Company Address',
        'contact.phone': 'Phone Number',
        'contact.email': 'Email Address',
        
        // News
        'news.title': 'News',
        'news.subtitle': 'Latest Updates, Learn About Cisetech',
        'news.latest': 'Latest News',
        'news.more': 'View More'
    }
};

// 页面选择器映射 - 每个页面的需要翻译的元素选择器
const pageSelectors = {
    // 首页
    'index.html': {
        'nav.home': 'a[href="index.html"].nav-link',
        'nav.products': '.nav-dropdown a[href="services.html#products"]',
        'nav.qualifications': 'a[href="qualifications.html"].nav-link',
        'nav.joins': 'a[href="joins.html"].nav-link',
        'nav.contact': 'a[href="contact.html"]',
        'nav.about-us': '.nav-dropdown-menu a[href="about.html"]',
        'nav.news': '.nav-dropdown-menu a[href="news.html"]',
        'section.core-business.title': '[data-section="services"] h2',
        'section.core-business.subtitle': '[data-section="services"] .text-slate-400'
    },
    // 关于我们
    'about.html': {
        'nav.home': 'a[href="index.html"].nav-link',
        'nav.products': '.nav-dropdown a[href="services.html#products"]',
        'nav.qualifications': 'a[href="qualifications.html"].nav-link',
        'nav.joins': 'a[href="joins.html"].nav-link',
        'nav.contact': 'a[href="contact.html"]',
        'nav.about-us': '.nav-dropdown a[href="about.html"]',
        'nav.news': '.nav-dropdown-menu a[href="news.html"]',
        'about.title': '.page-header h1',
        'about.history': '.section-title'
    },
    // 企业实力
    'qualifications.html': {
        'nav.home': 'a[href="index.html"].nav-link',
        'nav.products': '.nav-dropdown a[href="services.html#products"]',
        'nav.qualifications': 'a[href="qualifications.html"].nav-link',
        'nav.joins': 'a[href="joins.html"].nav-link',
        'nav.contact': 'a[href="contact.html"]',
        'nav.about-us': '.nav-dropdown a[href="about.html"]',
        'nav.news': '.nav-dropdown-menu a[href="news.html"]',
        'qualifications.title': '.page-header h1',
        'qualifications.subtitle': '.section-subtitle'
    },
    // 核心产品
    'services.html': {
        'nav.home': 'a[href="index.html"].nav-link',
        'nav.products': '.nav-dropdown a[href="services.html#products"]',
        'nav.qualifications': 'a[href="qualifications.html"].nav-link',
        'nav.joins': 'a[href="joins.html"].nav-link',
        'nav.contact': 'a[href="contact.html"]',
        'nav.about-us': '.nav-dropdown a[href="about.html"]',
        'nav.news': '.nav-dropdown-menu a[href="news.html"]',
        'products.title': '.hero-text-slide h1',
        'products.subtitle': '.section-subtitle'
    },
    // 招贤纳士
    'joins.html': {
        'nav.home': 'a[href="index.html"].nav-link',
        'nav.products': '.nav-dropdown a[href="services.html#products"]',
        'nav.qualifications': 'a[href="qualifications.html"].nav-link',
        'nav.joins': 'a[href="joins.html"].nav-link',
        'nav.contact': 'a[href="contact.html"]',
        'nav.about-us': '.nav-dropdown a[href="about.html"]',
        'nav.news': '.nav-dropdown-menu a[href="news.html"]',
        'joins.title': '.page-header h1',
        'joins.subtitle': '.section-subtitle'
    },
    // 联系我们
    'contact.html': {
        'nav.home': 'a[href="index.html"].nav-link',
        'nav.products': '.nav-dropdown a[href="services.html#products"]',
        'nav.qualifications': 'a[href="qualifications.html"].nav-link',
        'nav.joins': 'a[href="joins.html"].nav-link',
        'nav.contact': 'a[href="contact.html"]',
        'nav.about-us': '.nav-dropdown a[href="about.html"]',
        'nav.news': '.nav-dropdown-menu a[href="news.html"]',
        'contact.title': '.page-header h1',
        'contact.subtitle': '.section-subtitle'
    },
    // 申朴资讯
    'news.html': {
        'nav.home': 'a[href="index.html"].nav-link',
        'nav.products': '.nav-dropdown a[href="services.html#products"]',
        'nav.qualifications': 'a[href="qualifications.html"].nav-link',
        'nav.joins': 'a[href="joins.html"].nav-link',
        'nav.contact': 'a[href="contact.html"]',
        'nav.about-us': '.nav-dropdown a[href="about.html"]',
        'nav.news': '.nav-dropdown a[href="news.html"]',
        'news.title': 'h1',
        'news.subtitle': '.section-subtitle'
    },
    // 业务详情
    'business-detail.html': {
        'nav.home': 'a[href="index.html"].nav-link',
        'nav.products': '.nav-dropdown a[href="services.html#products"]',
        'nav.qualifications': 'a[href="qualifications.html"].nav-link',
        'nav.joins': 'a[href="joins.html"].nav-link',
        'nav.contact': 'a[href="contact.html"]',
        'nav.about-us': '.nav-dropdown a[href="about.html"]',
        'nav.news': '.nav-dropdown-menu a[href="news.html"]'
    }
};

// 获取当前语言，默认为中文
let currentLang = localStorage.getItem('siteLanguage') || 'zh';

// 切换语言函数
function switchLanguage(lang) {
    currentLang = lang;
    localStorage.setItem('siteLanguage', lang);
    
    // 更新语言切换按钮的激活状态
    document.querySelectorAll('.lang-switch').forEach(btn => {
        if (btn.dataset.lang === lang) {
            btn.classList.add('active', 'text-cyan-400');
            btn.classList.remove('text-slate-300');
        } else {
            btn.classList.remove('active', 'text-cyan-400');
            btn.classList.add('text-slate-300');
        }
    });
    
    // 更新页面上的文本
    updatePageText();
}

// 更新页面文本
function updatePageText() {
    try {
        // 获取当前页面文件名
        const currentPage = window.location.pathname.split('/').pop() || 'index.html';

        // 获取当前页面的选择器
        const selectors = pageSelectors[currentPage] || pageSelectors['index.html'];

        // 更新导航菜单（通用）
        updateNavigation();

        // 更新所有带有 data-i18n 属性的元素
        document.querySelectorAll('[data-i18n]').forEach(element => {
            const key = element.getAttribute('data-i18n');
            if (translations[currentLang][key]) {
                element.textContent = translations[currentLang][key];
            }
        });

        // 更新页面特定内容（不包括data-i18n已经处理的）
        for (const [key, selector] of Object.entries(selectors)) {
            if (translations[currentLang][key]) {
                try {
                    const elements = document.querySelectorAll(selector);
                    elements.forEach(element => {
                        // 确保元素不在header导航栏内且不是logo元素，并且没有data-i18n属性
                        if (!element.closest('header') &&
                            !element.classList.contains('site-logo-text') &&
                            !element.hasAttribute('data-i18n')) {
                            element.textContent = translations[currentLang][key];
                        }
                    });
                } catch (e) {
                    console.warn(`Failed to update element with selector "${selector}":`, e);
                }
            }
        }

        // 更新 Banner（仅首页）
        if (currentPage === 'index.html') {
            updateBanner();
        }
    } catch (error) {
        console.error('Error updating page text:', error);
    }
}

// 更新导航菜单（所有页面通用）
function updateNavigation() {
    try {
        // 桌面端导航 - 使用更精确的选择器
        const navLinks = {
            'nav.home': 'a[href="index.html"].nav-link',
            'nav.products': '.nav-dropdown a[href="services.html#products"]',
            'nav.qualifications': 'a[href="qualifications.html"].nav-link',
            'nav.joins': 'a[href="joins.html"].nav-link',
            'nav.about': '.nav-dropdown a[href="about.html"]',
            'nav.contact': 'a[href="contact.html"]'
        };
        
        // 下拉菜单
        const dropdownLinks = {
            'nav.about-us': '.nav-dropdown-menu a[href="about.html"]',
            'nav.news': '.nav-dropdown-menu a[href="news.html"]'
        };
        
        // 移动端导航
        const mobileNavLinks = {
            'nav.home': '#mobileNav > a[href="index.html"]',
            'nav.products': '#mobileSubmenuTrigger span',
            'nav.qualifications': '#mobileNav > a[href="qualifications.html"]',
            'nav.joins': '#mobileNav > a[href="joins.html"]',
            'nav.contact': '#mobileNav a[href="contact.html"]',
            'nav.about-us': '#mobileAboutSubmenuTrigger span',
            'nav.news': '#mobileAboutSubmenuItems a[href="news.html"]'
        };
        
        // 更新桌面端导航链接
        for (const [key, selector] of Object.entries(navLinks)) {
            if (translations[currentLang][key]) {
                try {
                    const element = document.querySelector(selector);
                    if (element) {
                        element.textContent = translations[currentLang][key];
                    }
                } catch (e) {
                    console.warn(`Failed to update nav link with selector "${selector}":`, e);
                }
            }
        }
        
        // 更新下拉菜单链接
        for (const [key, selector] of Object.entries(dropdownLinks)) {
            if (translations[currentLang][key]) {
                try {
                    const element = document.querySelector(selector);
                    if (element) {
                        element.textContent = translations[currentLang][key];
                    }
                } catch (e) {
                    console.warn(`Failed to update dropdown link with selector "${selector}":`, e);
                }
            }
        }
        
        // 更新移动端导航链接
        for (const [key, selector] of Object.entries(mobileNavLinks)) {
            if (translations[currentLang][key]) {
                try {
                    const element = document.querySelector(selector);
                    if (element) {
                        element.textContent = translations[currentLang][key];
                    }
                } catch (e) {
                    console.warn(`Failed to update mobile nav link with selector "${selector}":`, e);
                }
            }
        }
    } catch (error) {
        console.error('Error updating navigation:', error);
    }
}

// 更新 Banner（仅首页）
function updateBanner() {
    try {
        const slides = [0, 1, 2];
        const keys = ['title', 'slogan', 'desc'];
        
        slides.forEach(slideIndex => {
            const slide = document.querySelector(`.banner-slide[data-slide="${slideIndex}"]`);
            if (slide) {
                const title = slide.querySelector('.hero-title');
                const slogan = slide.querySelector('.ai-glow');
                const desc = slide.querySelector('.banner-content .text-slate-200:not(.ai-glow)');
                
                if (title) title.textContent = translations[currentLang][`banner.title${slideIndex + 1}`];
                if (slogan) slogan.textContent = translations[currentLang][`banner.slogan${slideIndex + 1}`];
                if (desc) desc.textContent = translations[currentLang][`banner.desc${slideIndex + 1}`];
            }
        });
    } catch (error) {
        console.error('Error updating banner:', error);
    }
}

// 初始化语言
function initLanguage() {
    // 设置语言切换按钮的激活状态
    document.querySelectorAll('.lang-switch').forEach(btn => {
        if (btn.dataset.lang === currentLang) {
            btn.classList.add('active', 'text-cyan-400');
            btn.classList.remove('text-slate-300');
        } else {
            btn.classList.remove('active', 'text-cyan-400');
            btn.classList.add('text-slate-300');
        }
    });
    
    // 更新页面文本
    updatePageText();
}

// 绑定语言切换事件
function bindLanguageEvents() {
    document.querySelectorAll('.lang-switch').forEach(btn => {
        btn.addEventListener('click', (e) => {
            e.preventDefault();
            const lang = btn.dataset.lang;
            switchLanguage(lang);
        });
    });
}

// 等待DOM加载完成
if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', function() {
        bindLanguageEvents();
        initLanguage();
    });
} else {
    // DOM已经加载完成
    bindLanguageEvents();
    // 延迟一点执行，确保所有元素都已渲染
    setTimeout(initLanguage, 100);
}
