# 系统操作Flag映射表

## 客户端-服务端通信协议

系统使用flag字段来标识不同的操作类型，以下是完整的映射关系：

### 🔐 用户认证操作
| Flag | 操作 | 说明 | 客户端 | 服务端 |
|------|------|------|--------|--------|
| 0 | 登录验证 | 用户登录系统 | Model.doLogin() | Model.dologin() |

### 📦 商品管理操作  
| Flag | 操作 | 说明 | 客户端 | 服务端 |
|------|------|------|--------|--------|
| 4 | 查询商品 | 根据ID查询商品信息 | Model.goodsFindById() | Model.findGoodsById() |
| 5 | 添加商品 | 新增商品到库存 | Model.addGoods() | GoodsDao.add() |
| 6 | 删除商品 | 从库存中删除商品 | Model.delGoods() | GoodsDao.del() |
| 7 | 修改商品 | 更新商品信息 | Model.updateGoods() | GoodsDao.update() |

### 👥 用户管理操作
| Flag | 操作 | 说明 | 客户端 | 服务端 |
|------|------|------|--------|--------|
| 10 | 添加用户 | 新增系统用户 | Model.addUser() | UserDao.add() |
| 11 | 删除用户 | 删除系统用户 | Model.delUser() | UserDao.del() |
| 12 | 修改用户 | 更新用户信息 | Model.updateUser() | UserDao.updateUser() |
| 13 | 查询用户 | 根据用户名查询用户 | Model.findUser() | UserDao.findUser() |

### 🎭 用户角色定义
| Role | 角色 | 权限 | 界面 |
|------|------|------|------|
| 1 | 收银员 | 商品扫描、收银结算 | CashierView |
| 2 | 仓库管理员 | 商品增删改查 | WarehouseView |
| 3 | 系统管理员 | 用户管理、所有权限 | UserManager |

### 🔄 返回状态说明
| 状态 | 说明 |
|------|------|
| 0 | 操作失败 / 用户不存在 |
| 1-3 | 登录成功，返回用户角色 |
| 9 | 密码错误 |
| true/false | 操作成功/失败（result字段） |

### ⚠️ 注意事项
1. 所有操作都通过Entity对象封装数据
2. 网络通信使用Socket + 对象序列化
3. 服务端根据flag值分发到对应的DAO层处理
4. 客户端根据返回的flag值或result判断操作结果
5. 异常情况下返回null或false，客户端需要妥善处理

### 🔧 错误处理机制
- 空指针检查：所有关键数据访问前检查null
- 输入验证：界面层验证用户输入的有效性
- 数据库异常：DAO层捕获SQL异常并返回false
- 网络异常：客户端处理连接失败情况
- 业务逻辑：Model层处理业务规则和数据完整性
