# 申朴信息官网 (cisetech.com)

申朴信息技术股份有限公司官方网站项目，采用现代化技术栈构建的企业级官网应用。

## 项目简介

本项目是上海申朴信息技术股份有限公司（新三板股票代码870221）的官方网站，核心定位为国内领先的金融科技与企业数字化转型解决方案服务商官网。

## 技术栈

### 后端
- **框架**: Spring Boot 3.2
- **语言**: Java 17
- **数据库**: MySQL 8.0 / H2 (开发环境)
- **ORM**: Spring Data JPA
- **API文档**: Swagger / OpenAPI 3.0

### 前端
- **框架**: Vue 3
- **构建工具**: Vite 5
- **状态管理**: Pinia
- **路由**: Vue Router 4
- **样式**: Tailwind CSS 3 + SCSS
- **SEO**: @vueuse/head

## 项目结构

```
.
├── backend/                 # 后端项目
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/cisetech/
│   │   │   │   ├── config/        # 配置类
│   │   │   │   ├── controller/    # 控制器
│   │   │   │   ├── entity/        # 实体类
│   │   │   │   ├── repository/    # 数据访问层
│   │   │   │   ├── service/       # 业务逻辑层
│   │   │   │   └── CisetechApplication.java
│   │   │   └── resources/
│   │   │       ├── application.yml
│   │   │       └── schema.sql
│   │   └── pom.xml
│   └── ...
├── frontend/                # 前端项目
│   ├── src/
│   │   ├── components/       # 组件
│   │   ├── router/          # 路由配置
│   │   ├── stores/          # 状态管理
│   │   ├── styles/          # 样式文件
│   │   ├── views/           # 页面视图
│   │   ├── App.vue
│   │   └── main.ts
│   ├── index.html
│   ├── package.json
│   ├── vite.config.ts
│   ├── tailwind.config.js
│   └── ...
├── .coze                    # 项目配置文件
└── README.md
```

## 功能特性

### 网站栏目
1. **首页** - 品牌主视觉页、核心战略概览
2. **核心业务体系** - 五大核心业务展示
3. **产品与解决方案中心** - 自研产品矩阵、行业解决方案
4. **企业实力与资质荣誉** - 权威资质、荣誉奖项
5. **关于我们** - 企业简介、发展历程、技术实力
6. **联系我们** - 合作咨询、服务网络

### 核心功能
- ✅ 响应式设计，适配多种设备
- ✅ SEO优化，支持搜索引擎检索
- ✅ 动态内容管理，支持后台配置
- ✅ 科技风视觉设计，专业严谨
- ✅ 完整的API接口体系
- ✅ 数据库持久化存储

## 快速开始

### 环境要求
- Node.js 18+
- Java 17+
- MySQL 8.0+ (可选，H2用于开发)

### 后端启动

```bash
cd backend

# 使用Maven构建
./mvnw clean package -DskipTests

# 运行项目
./mvnw spring-boot:run
```

后端服务将在 `http://localhost:8080` 启动

### 前端启动

```bash
cd frontend

# 安装依赖
pnpm install

# 启动开发服务器
pnpm run dev

# 构建生产版本
pnpm run build
```

前端服务将在 `http://localhost:5173` 启动

## 数据库配置

### 开发环境 (H2)
默认使用H2内存数据库，无需额外配置，启动后可访问 `http://localhost:8080/api/h2-console`

### 生产环境 (MySQL)

修改 `backend/src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/cisetech
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: your_username
    password: your_password
  jpa:
    hibernate:
      ddl-auto: update
    database-platform: org.hibernate.dialect.MySQLDialect
```

## API文档

启动后端服务后，访问以下地址查看API文档:
- Swagger UI: `http://localhost:8080/api/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8080/api/v3/api-docs`

## 部署说明

### 使用项目配置

项目已包含 `.coze` 配置文件，支持一键部署:

```bash
# 构建
cd backend && ./mvnw clean package -DskipTests
cd ../frontend && pnpm install && pnpm run build

# 运行
cd backend && java -jar target/cisetech-backend.jar
```

### Docker部署 (可选)

创建 `Dockerfile`:

```dockerfile
# 后端Dockerfile
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/cisetech-backend.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

## 网站配置

### 参数配置
网站支持通过数据库动态配置以下内容:
- 网站标题、关键词、描述
- 企业基本信息
- 联系方式
- 页脚版权信息

访问后台管理接口进行配置 (需实现管理界面)。

## 开发规范

### 分支管理
- `main` - 生产环境分支
- `develop` - 开发环境分支
- `feature/*` - 功能分支

### 代码风格
- 后端: 遵循 Alibaba Java Coding Guidelines
- 前端: 遵循 Vue 3 Style Guide
- 提交信息: Conventional Commits

## 联系方式

- 官方网站: https://www.cisetech.com
- 咨询电话: 400-888-8888
- 邮箱: contact@cisetech.com

## 许可证

Copyright © 2024 上海申朴信息技术股份有限公司 版权所有
