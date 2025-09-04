#!/bin/bash
# 启动服务端脚本

echo "🚀 启动Java超市收银管理系统服务端..."

# 设置Java环境
export PATH="/opt/homebrew/opt/openjdk@11/bin:$PATH"

# 检查MySQL服务
echo "📊 检查MySQL服务状态..."
if ! brew services list | grep mysql | grep started > /dev/null; then
    echo "⚠️  MySQL服务未启动，正在启动..."
    brew services start mysql
    sleep 3
fi

# 检查数据库
echo "🗄️  检查数据库连接..."
if ! mysql -u root -e "USE shop; SELECT 1;" > /dev/null 2>&1; then
    echo "❌ 数据库连接失败，请检查MySQL配置"
    exit 1
fi

# 进入服务端目录
cd MyServer

# 启动服务端
echo "🌐 启动服务端 (端口: 8887)..."
java -cp "bin:src/mysql-connector-java-5.1.26-bin.jar" com.Jie.net.Net

echo "✅ 服务端已启动!"
