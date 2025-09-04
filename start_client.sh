#!/bin/bash
# 启动客户端脚本

echo "🖥️  启动Java超市收银管理系统客户端..."

# 设置Java环境
export PATH="/opt/homebrew/opt/openjdk@11/bin:$PATH"

# 检查服务端是否运行
echo "🔍 检查服务端连接..."
if ! lsof -i :8887 > /dev/null 2>&1; then
    echo "⚠️  服务端未启动，请先运行 ./start_server.sh"
    echo "💡 提示: 在新终端窗口中运行服务端，然后再运行客户端"
    exit 1
fi

# 进入客户端目录
cd MyClient

# 启动客户端GUI
echo "🎨 启动图形界面..."
java -cp bin com.Jie.view.DoMain

echo "✅ 客户端已关闭!"
