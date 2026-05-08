#!/bin/bash
# 申朴信息官网 - 打包脚本

VERSION="1.0.0"
PACKAGE_NAME="cisetech-website-v${VERSION}"

echo "==================================="
echo "  申朴信息官网 - 打包脚本"
echo "==================================="
echo ""

# 检查是否在项目根目录
if [ ! -f "DEPLOY.md" ]; then
    echo "❌ 错误：请在项目根目录运行此脚本"
    exit 1
fi

echo "📦 版本: ${VERSION}"
echo "📁 打包目录: deploy/"
echo ""

# 创建打包目录
mkdir -p dist

# 复制文件到临时目录
echo "📋 复制文件..."
cp -r deploy/ ${PACKAGE_NAME}/

# 打包成 ZIP
echo "📦 正在打包..."
zip -r dist/${PACKAGE_NAME}.zip ${PACKAGE_NAME}/

# 清理临时目录
rm -rf ${PACKAGE_NAME}/

echo ""
echo "✅ 打包完成！"
echo "📦 打包文件: dist/${PACKAGE_NAME}.zip"
echo ""
echo "文件大小: $(ls -lh dist/${PACKAGE_NAME}.zip | awk '{print $5}')"
echo ""
echo "==================================="
