# 申朴信息官网 - 静态页面版本

## 快速开始

### 本地预览

**方式一：使用 Python（推荐）**

```bash
# Linux/Mac
./start.sh

# Windows
start.bat
```

**方式二：使用任意 HTTP 服务器**

```bash
# Python 3
python3 -m http.server 5000

# Node.js (http-server)
npx http-server -p 5000

# PHP
php -S localhost:5000
```

然后访问：http://localhost:5000

## 文件说明

| 文件名 | 说明 |
|--------|------|
| `index.html` | 首页 |
| `services.html` | 核心业务 |
| `products.html` | 产品方案 |
| `qualifications.html` | 企业实力 |
| `about.html` | 关于我们 |
| `contact.html` | 联系我们 |
| `start.sh` | Linux/Mac 启动脚本 |
| `start.bat` | Windows 启动脚本 |

## 部署到服务器

详细部署方法请参考根目录下的 `DEPLOY.md` 文件。

### 支持的部署方式

- ✅ Nginx
- ✅ Apache
- ✅ 腾讯云 COS / 阿里云 OSS
- ✅ Vercel / Netlify
- ✅ Docker
- ✅ 其他任何静态文件托管服务

## 技术栈

- **HTML5** - 页面结构
- **Tailwind CSS** - 样式框架（CDN 版本）
- **Vanilla JavaScript** - 交互脚本
- **Google Fonts** - 中文字体（Noto Sans SC）

## 浏览器支持

- Chrome 90+
- Firefox 88+
- Safari 14+
- Edge 90+

## 修改内容

直接编辑对应的 HTML 文件即可，无需构建工具。

## 许可证

© 2024 上海申朴信息技术股份有限公司 版权所有
