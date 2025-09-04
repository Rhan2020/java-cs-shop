# 🛒 Java 超市收银管理系统

一个基于 **CS 架构**、**Socket 通信**、**多线程**技术，使用 **Java Swing** 开发的超市收银管理系统。

[![Java](https://img.shields.io/badge/Java-8+-blue.svg)](https://www.oracle.com/java/)
[![MySQL](https://img.shields.io/badge/MySQL-5.7+-orange.svg)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/License-Free-green.svg)](#📄-授权及版权说明)

## 📋 目录

- [功能特性](#🚀-功能特性)
- [系统架构](#🏗️-系统架构)
- [技术栈](#💻-技术栈)
- [快速开始](#⚡-快速开始)
- [部署指南](#📦-部署指南)
- [项目结构](#📁-项目结构)
- [运行截图](#📸-运行截图)
- [常见问题](#❓-常见问题)
- [授权说明](#📄-授权及版权说明)

## 🚀 功能特性

### 🔐 用户管理
- **登录认证**：支持多角色用户登录
- **用户注册**：新用户账号注册
- **权限控制**：收银员、仓库管理员、系统管理员三级权限
- **用户 CRUD**：用户信息的增加、删除、修改、查询

### 💰 收银功能
- **商品扫描**：通过商品 ID 快速查找商品信息
- **购物车管理**：支持多商品添加，实时显示商品列表
- **价格计算**：自动计算商品总价
- **小票打印**：生成购物小票
- **找零计算**：智能找零功能

### 📦 商品管理
- **商品 CRUD**：商品信息的增加、删除、修改、查询
- **库存管理**：实时库存数量显示和更新
- **价格管理**：商品价格设置和调整

## 🏗️ 系统架构

```
┌─────────────────┐    Socket通信    ┌─────────────────┐
│   客户端 (GUI)   │ ◄─────────────► │   服务端        │
│                │                 │                │
│ • 登录界面      │                 │ • 网络监听      │
│ • 收银界面      │                 │ • 业务逻辑      │
│ • 管理界面      │                 │ • 数据访问      │
└─────────────────┘                 └─────────────────┘
                                           │
                                           ▼
                                    ┌─────────────────┐
                                    │   MySQL 数据库   │
                                    │                │
                                    │ • 用户表        │
                                    │ • 商品表        │
                                    └─────────────────┘
```

* ![modelPNG](https://github.com/JieDreambuilder/java-cs-shop/blob/master/readmeImg/model.png)
* ![model2PNG](https://github.com/JieDreambuilder/java-cs-shop/blob/master/readmeImg/model2.png)

## 💻 技术栈

| 技术 | 版本 | 用途 |
|------|------|------|
| **Java** | 8+ | 核心开发语言 |
| **Swing** | - | GUI 界面开发 |
| **Socket** | - | 客户端-服务端通信 |
| **MySQL** | 5.7+ | 数据存储 |
| **JDBC** | - | 数据库连接 |
| **多线程** | - | 并发处理 |

## ⚡ 快速开始

### ⚠️ 重要说明

**如果项目有问题或者跑不起来，请切换到 `backup` 分支：**

```bash
# 切换到原始版本（修复前）
git checkout backup

# 查看当前分支
git branch
```

**分支说明：**
- **`backup` 分支**：原始版本，包含修复前的代码
- **`master` 分支**：基于 `backup` 分支，由 AI 修复部分功能并补充 SQL 的增强版本

### 📋 环境要求

- **Java JDK 8** 或更高版本
- **MySQL 5.7** 或更高版本
- **IDE**：Eclipse、IntelliJ IDEA 或其他 Java IDE

### 🗄️ 数据库配置

1. **创建数据库**
   ```bash
   mysql -u root -p
   ```

2. **导入数据库结构**
   ```bash
   mysql -u root -p < database.sql
   ```

3. **修改数据库配置**
   
   编辑 `MyServer/src/config.properties`：
   ```properties
   # 数据库配置
   db.url=jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=utf8
   db.username=your_username
   db.password=your_password
   db.driver=com.mysql.jdbc.Driver
   
   # 服务器端口
   server.port=8887
   ```

### 🚀 启动应用

1. **启动服务端**
   ```bash
   # 进入服务端目录
   cd MyServer/src
   
   # 编译并运行服务端
   javac com/Jie/net/Net.java
   java com.Jie.net.Net
   ```

2. **启动客户端**
   ```bash
   # 进入客户端目录
   cd MyClient/src
   
   # 编译并运行客户端
   javac com/Jie/view/DoMain.java
   java com.Jie.view.DoMain
   ```

### 👤 默认用户账号

| 用户名 | 密码 | 角色 | 说明 |
|--------|------|------|------|
| `admin` | `admin123` | 系统管理员 | 具有所有权限 |
| `cashier1` | `cashier123` | 收银员 | 收银操作权限 |
| `warehouse1` | `warehouse123` | 仓库管理员 | 商品管理权限 |

## 📦 部署指南

### 🔧 开发环境部署

1. **导入 IDE**
   - 使用 Eclipse 或 IntelliJ IDEA 导入项目
   - 确保项目编码为 UTF-8

2. **配置依赖**
   - 添加 MySQL JDBC 驱动到项目 classpath
   - 下载地址：[MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)

3. **运行配置**
   - 服务端主类：`com.Jie.net.Net`
   - 客户端主类：`com.Jie.view.DoMain`

### 🏭 生产环境部署

1. **编译打包**
   ```bash
   # 编译服务端
   javac -cp ".:mysql-connector-java.jar" MyServer/src/com/Jie/net/Net.java
   
   # 编译客户端
   javac MyClient/src/com/Jie/view/DoMain.java
   ```

2. **创建启动脚本**
   
   **服务端启动脚本 (start_server.sh)**：
   ```bash
   #!/bin/bash
   java -cp ".:mysql-connector-java.jar" com.Jie.net.Net
   ```
   
   **客户端启动脚本 (start_client.sh)**：
   ```bash
   #!/bin/bash
   java com.Jie.view.DoMain
   ```

## 📁 项目结构

```
java-cs-shop/
├── MyServer/                    # 服务端代码
│   └── src/
│       ├── com/Jie/
│       │   ├── Dao/            # 数据访问层
│       │   │   ├── DBUtils.java     # 数据库工具类
│       │   │   ├── User.java        # 用户实体
│       │   │   ├── UserDao.java     # 用户数据访问
│       │   │   ├── Goods.java       # 商品实体
│       │   │   └── GoodsDao.java    # 商品数据访问
│       │   ├── Entity/         # 实体层
│       │   │   └── Entity.java      # 通用实体类
│       │   ├── model/          # 业务逻辑层
│       │   │   └── Model.java       # 业务处理
│       │   └── net/            # 网络通信层
│       │       └── Net.java         # 服务端网络处理
│       └── config.properties       # 配置文件
├── MyClient/                    # 客户端代码
│   └── src/
│       └── com/Jie/
│           ├── Entity/         # 实体层
│           ├── model/          # 业务逻辑层
│           ├── net/            # 网络通信层
│           ├── utils/          # 工具类
│           │   └── PriceCalculator.java # 价格计算工具
│           └── view/           # 视图层
│               ├── DoMain.java      # 程序入口
│               ├── LoginView.java   # 登录界面
│               ├── CashierView.java # 收银界面
│               └── ...             # 其他界面
├── database.sql                 # 数据库初始化脚本
├── readmeImg/                   # 截图资源
└── README.md                   # 项目说明
```

## 📸 运行截图

### 登录界面
![登录界面](https://github.com/JieDreambuilder/java-cs-shop/blob/master/readmeImg/login.png)

### 主界面
![主界面](https://github.com/JieDreambuilder/java-cs-shop/blob/master/readmeImg/index.png)

### 收银界面
![收银界面](https://github.com/JieDreambuilder/java-cs-shop/blob/master/readmeImg/count.png)

### 找零界面
![找零界面](https://github.com/JieDreambuilder/java-cs-shop/blob/master/readmeImg/oddchange.png)

## ❓ 常见问题

### 🔄 分支切换问题

**Q: 项目运行出错，如何回退到原始版本？**

A: 使用以下命令切换到原始版本：
```bash
# 切换到原始版本
git checkout backup

# 如果需要回到修复版本
git checkout master
```

**Q: 如何查看当前在哪个分支？**

A: 使用以下命令：
```bash
# 查看当前分支
git branch

# 查看所有分支
git branch -a
```

### 🔧 连接问题

**Q: 客户端连接不上服务端？**

A: 检查以下几点：
1. 服务端是否正常启动（端口 8887）
2. 防火墙是否阻止了连接
3. 客户端配置的服务器地址是否正确

**Q: 数据库连接失败？**

A: 检查以下几点：
1. MySQL 服务是否启动
2. 数据库配置信息是否正确
3. MySQL JDBC 驱动是否正确添加到 classpath

### 💾 数据问题

**Q: 找不到商品信息？**

A: 检查以下几点：
1. 数据库中是否有对应的商品数据
2. 输入的商品 ID 是否正确
3. 数据库连接是否正常

**Q: 用户登录失败？**

A: 检查以下几点：
1. 用户名和密码是否正确
2. 用户数据是否存在于数据库中
3. 数据库用户表结构是否正确

### 🎨 界面问题

**Q: 界面显示乱码？**

A: 设置正确的字符编码：
1. IDE 项目编码设置为 UTF-8
2. 数据库字符集设置为 utf8mb4
3. JVM 启动参数添加 `-Dfile.encoding=UTF-8`

## 📄 授权及版权说明

### 🎓 项目用途声明
本项目**仅供学习使用**，是一个基于 Java CS 架构技术的学习项目。

### 📝 开源协议
- 项目源码可**随意使用**，无需额外授权
- 可自由进行修改、分发和商业使用
- 使用本项目源码时无需署名，但非常欢迎 ⭐️ Star 或打赏支持作者

### ⚠️ 免责声明
- 项目中涉及的相关商标、品牌名称及图片资源均为其**官方所有**
- 本项目仅作为技术学习演示，不涉及任何商业用途
- 因使用本项目代码或资源所产生的任何法律后果与原作者**无关**
- 请在合法合规的前提下使用本项目

### ☕️ 请我喝杯咖啡
如果这个项目对你有帮助，欢迎请我喝杯咖啡 😊

<p align="center">
  <img src="./readmeImg/pay.jpg" width="200" alt="微信支付" />
  &nbsp;&nbsp;&nbsp;&nbsp;
  <img src="./readmeImg/alipay.jpg" width="200" alt="支付宝" />
</p>

---

<p align="center">
  <strong>📧 联系方式</strong><br>
  如有问题或建议，欢迎提交 Issue 或 Pull Request
</p>

<p align="center">
  Made with ❤️ by Rshan
</p>
