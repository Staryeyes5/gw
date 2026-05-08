# 申朴信息官网 - 静态页面部署指南

## 项目概述

这是申朴信息（上海申朴信息技术股份有限公司）官方网站的静态页面版本，无需后台服务器支持，可以直接部署到任何静态文件托管服务。

## 文件结构

```
deploy/
├── index.html          # 首页
├── services.html       # 核心业务页面
├── products.html       # 产品方案页面
├── qualifications.html # 企业实力页面
├── about.html          # 关于我们页面
└── contact.html        # 联系我们页面
```

## 技术特点

- **纯静态HTML**：无需后端服务器
- **CDN资源**：使用 Tailwind CSS CDN，无需本地构建
- **响应式设计**：支持各种屏幕尺寸
- **跨浏览器兼容**：支持主流现代浏览器
- **SEO友好**：包含完整的meta标签

## 部署方法

### 方法一：Nginx 部署（推荐）

#### 1. 安装 Nginx

```bash
# Ubuntu/Debian
sudo apt update
sudo apt install nginx

# CentOS/RHEL
sudo yum install nginx
```

#### 2. 上传文件

将 `deploy/` 目录下的所有文件上传到服务器：

```bash
# 创建网站目录
sudo mkdir -p /var/www/cisetech

# 上传文件（从本地执行）
scp deploy/* user@your-server:/var/www/cisetech/
```

#### 3. 配置 Nginx

创建配置文件：

```bash
sudo nano /etc/nginx/sites-available/cisetech
```

添加以下内容：

```nginx
server {
    listen 80;
    server_name your-domain.com www.your-domain.com;
    
    root /var/www/cisetech;
    index index.html;
    
    location / {
        try_files $uri $uri/ =404;
    }
    
    # 启用 Gzip 压缩
    gzip on;
    gzip_vary on;
    gzip_min_length 1024;
    gzip_types text/plain text/css text/xml text/javascript 
               application/x-javascript application/xml+rss 
               application/json application/javascript;
}
```

#### 4. 启用配置

```bash
# 创建软链接
sudo ln -s /etc/nginx/sites-available/cisetech /etc/nginx/sites-enabled/

# 测试配置
sudo nginx -t

# 重启 Nginx
sudo systemctl restart nginx
```

#### 5. 配置 HTTPS（推荐）

使用 Let's Encrypt 免费证书：

```bash
# 安装 Certbot
sudo apt install certbot python3-certbot-nginx

# 获取证书并自动配置
sudo certbot --nginx -d your-domain.com -d www.your-domain.com
```

---

### 方法二：Apache 部署

#### 1. 安装 Apache

```bash
# Ubuntu/Debian
sudo apt install apache2

# CentOS/RHEL
sudo yum install httpd
```

#### 2. 上传文件

```bash
sudo mkdir -p /var/www/cisetech
scp deploy/* user@your-server:/var/www/cisetech/
```

#### 3. 配置虚拟主机

```bash
sudo nano /etc/apache2/sites-available/cisetech.conf
```

添加内容：

```apache
<VirtualHost *:80>
    ServerName your-domain.com
    ServerAlias www.your-domain.com
    DocumentRoot /var/www/cisetech
    
    <Directory /var/www/cisetech>
        Options -Indexes +FollowSymLinks
        AllowOverride All
        Require all granted
    </Directory>
    
    ErrorLog ${APACHE_LOG_DIR}/cisetech-error.log
    CustomLog ${APACHE_LOG_DIR}/cisetech-access.log combined
</VirtualHost>
```

#### 4. 启用配置

```bash
sudo a2ensite cisetech.conf
sudo systemctl restart apache2
```

---

### 方法三：云服务部署

#### 腾讯云 COS / 阿里云 OSS

1. 登录云存储控制台
2. 创建存储桶（Bucket）
3. 上传 `deploy/` 目录下的所有文件
4. 设置静态网站托管
5. 配置自定义域名（可选）
6. 配置 CDN 加速（推荐）

#### Vercel / Netlify 部署

**Vercel:**
```bash
# 安装 Vercel CLI
npm i -g vercel

# 进入 deploy 目录
cd deploy

# 部署
vercel
```

**Netlify:**
1. 访问 https://app.netlify.com
2. 拖拽 `deploy` 文件夹到上传区域
3. 等待部署完成
4. 配置自定义域名

---

### 方法四：Docker 部署

创建 `Dockerfile`：

```dockerfile
FROM nginx:alpine
COPY . /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
```

构建并运行：

```bash
# 构建镜像
docker build -t cisetech-website .

# 运行容器
docker run -d -p 80:80 --name cisetech cisetech-website
```

---

## 域名配置

### DNS 解析

1. 登录域名服务商控制台
2. 添加 A 记录：
   - 主机记录：`@`
   - 记录值：服务器 IP 地址
3. 添加 CNAME 记录（可选）：
   - 主机记录：`www`
   - 记录值：`your-domain.com`

---

## 验证部署

部署完成后，访问以下地址验证：

```bash
# 检查 HTTP 状态
curl -I http://your-domain.com

# 应该返回：HTTP/1.1 200 OK
```

---

## 维护与更新

### 更新网站内容

1. 修改本地 HTML 文件
2. 重新上传到服务器：
   ```bash
   scp deploy/*.html user@your-server:/var/www/cisetech/
   ```
3. 清除浏览器缓存查看更新

---

## 常见问题

### Q: 如何修改网站内容？

A: 直接编辑对应的 HTML 文件即可，无需重新构建。

### Q: 图片资源如何处理？

A: 将图片上传到服务器或使用 CDN 图床，修改 HTML 中的图片链接。

### Q: 网站加载慢怎么办？

A: 
1. 启用 CDN 加速
2. 优化图片大小
3. 启用 Gzip 压缩
4. 使用浏览器缓存

### Q: 如何统计网站访问量？

A: 在 HTML 中添加 Google Analytics 或百度统计代码。

---

## 技术支持

如有问题，请检查：
1. Nginx/Apache 错误日志
2. 文件权限是否正确
3. 防火墙是否开放 80/443 端口

---

## 许可证

© 2024 上海申朴信息技术股份有限公司 版权所有
