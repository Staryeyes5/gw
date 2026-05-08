@echo off
chcp 65001 >nul
echo ===================================
echo   申朴信息官网 - 本地测试
echo ===================================
echo.

REM 检查 Python 是否安装
python --version >nul 2>&1
if errorlevel 1 (
    echo ❌ 错误：未找到 Python，请先安装 Python
    pause
    exit /b 1
)

echo ✅ 检查 Python：OK
echo.
echo 🚀 启动本地服务器...
echo 📱 访问地址：http://localhost:5000
echo.
echo 按 Ctrl+C 停止服务器
echo ===================================
echo.

REM 启动 HTTP 服务器
python -m http.server 5000 --bind 0.0.0.0

pause
