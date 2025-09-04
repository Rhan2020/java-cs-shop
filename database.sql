-- 超市收银管理系统数据库初始化脚本
-- 创建数据库
CREATE DATABASE IF NOT EXISTS `shop` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE `shop`;

-- 创建用户表
CREATE TABLE IF NOT EXISTS `user` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `username` varchar(50) NOT NULL COMMENT '用户名',
    `password` varchar(100) NOT NULL COMMENT '密码',
    `flag` int(1) NOT NULL DEFAULT '1' COMMENT '用户角色：1-收银员，2-仓库管理员，3-系统管理员',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- 创建商品表
CREATE TABLE IF NOT EXISTS `goods` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
    `goodsid` varchar(50) NOT NULL COMMENT '商品编号',
    `goodsname` varchar(100) NOT NULL COMMENT '商品名称',
    `goodsprice` decimal(10,2) NOT NULL COMMENT '商品价格',
    `goodscount` int(11) NOT NULL DEFAULT '0' COMMENT '商品库存数量',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `goodsid` (`goodsid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品表';

-- 插入测试数据
-- 用户数据
INSERT INTO `user` (`username`, `password`, `flag`) VALUES
('admin', '123456', 3),
('cashier', '123456', 1),
('warehouse', '123456', 2);

-- 商品数据
INSERT INTO `goods` (`goodsid`, `goodsname`, `goodsprice`, `goodscount`) VALUES
('10001', '可口可乐 330ml', 3.50, 100),
('10002', '方便面', 4.00, 50),
('10003', '薯片', 6.50, 30),
('10004', '牛奶 250ml', 2.80, 80),
('10005', '面包', 5.00, 25),
('10086', '测试商品', 1.00, 999);
