#!/bin/bash
# 申朴信息官网 - 本地测试启动脚本

echo "==================================="
echo "  申朴信息官网 - 本地测试"
echo "==================================="
echo ""

# 检查 Python 是否安装
if ! command -v python3 &> /dev/null; then
    echo "❌ 错误：未找到 Python3，请先安装 Python"
    exit 1
fi

echo "✅ 检查 Python：OK"
echo ""
echo "🚀 启动本地服务器..."
echo "📱 访问地址：http://localhost:5000"
echo ""
echo "按 Ctrl+C 停止服务器"
echo "==================================="
echo ""

# 启动 HTTP 服务器
python3 -m http.server 5000 --bind 0.0.0.0
