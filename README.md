# mall-tiny-jpa

## 前言

（2023.12.12更新）

本项目是基于大佬[macro](https://github.com/macrozheng)的快速开发脚手架[mall-tiny](https://github.com/macrozheng/mall-tiny)进行改造，将原项目中的mysql数据库替换成postgresql，以及将mybatis框架替换成spring data jpa + querydsl。同时还实现多模块开发。本项目为作者个人学习使用，旨在记录开发过程遇到的问题以及解决方法，提高相关技术的能力。

## 项目结构

```lua
mall-tiny-jpa
├── mall-tiny-jpa-common -- 项目通用配置
├── mall-tiny-jpa-core -- 项目控制层、服务层及其实现层
├── mall-tiny-jpa-entity -- 项目实体及持久层
└── mall-tiny-jpa-security -- Spring Security相关配置
```
