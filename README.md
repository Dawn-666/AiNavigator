<p align="center"> <img src="https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white" alt="Android"> <img src="https://img.shields.io/badge/Kotlin-0095D5?style=for-the-badge&logo=kotlin&logoColor=white" alt="Kotlin"> <img src="https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpack-compose&logoColor=white" alt="Jetpack Compose"> <img src="https://img.shields.io/badge/License-Apache%202.0-blue.svg?style=for-the-badge" alt="License"> </p> <p align="center"> <b>一款专为AI开发者设计的智能导航应用，快速访问各类AI工具和平台</b> </p>

## 📖 简介

AiNavigator 是一个专为AI开发者、研究人员和爱好者设计的Android应用，提供便捷的AI工具和平台导航服务。应用集成了国内外知名的AI网站，包括大语言模型、计算机视觉、AI智能体开发等多个类别，帮助用户快速找到所需的AI资源。

## ✨ 功能特点

- 🗂️ **分类导航**：按功能分类展示AI网站，包括大语言模型、计算机视觉、AI智能体开发等7大类别
- 🔍 **智能搜索**：实时搜索网站名称、描述和分类，快速定位目标资源
- ⭐ **收藏管理**：一键收藏常用网站，个性化定制导航体验
- 🌐 **内置浏览器**：集成WebView，提供流畅的网站浏览体验
- 🎨 **现代UI设计**：采用Jetpack Compose和Material Design 3，提供美观的用户界面
- 🚀 **高性能**：优化加载速度和内存使用，提供流畅的用户体验

## 🛠️ 技术栈

- **语言**：Kotlin
- **UI框架**：Jetpack Compose
- **架构模式**：MVVM (Model-View-ViewModel)
- **图像加载**：Coil
- **数据存储**：Room Database
- **网络请求**：Retrofit (未来扩展)
- **依赖注入**：Hilt (未来扩展)

## 📦 安装与运行

### 前提条件

- Android Studio 2025.1.2 或更高版本
- Android SDK 36 或更高版本
- Gradle 8.0 或更高版本

### 安装步骤

1. 克隆项目到本地：

```
git clone https://github.com/Dawn-666/AiNavigator.git
```

2. 使用Android Studio打开项目
3. 同步Gradle依赖
4. 连接Android设备或启动模拟器（API级别33+）
5. 点击运行按钮构建并安装应用

### 构建变体

项目包含两种构建变体：

- **debug**：用于开发和测试，包含调试功能
- **release**：用于发布，已进行代码优化和压缩

## 🎯 使用方法

### 主界面导航

1. **浏览分类**：首页按分类展示AI网站，点击分类标题可快速定位
2. **搜索网站**：使用顶部搜索栏输入关键词，实时筛选结果
3. **收藏网站**：点击网站卡片上的收藏图标，将常用网站加入收藏
4. **访问网站**：点击网站卡片，在内置浏览器中打开网站

### 收藏管理

- 收藏的网站会在所有分类中显示星标标识
- 未来版本将添加独立的收藏页面，管理所有收藏内容

### 搜索功能

- 支持按网站名称、描述和分类关键词搜索
- 搜索结果实时更新，显示匹配数量
- 点击搜索栏右侧的清除按钮可重置搜索

## 📁 项目结构

```
ai-navigator-app/
├── app/
│   ├── src/main/
│   │   ├── java/com/kugou/navigator/
│   │   │   ├── data/
│   │   │   │   ├── model/          # 数据模型
│   │   │   │   ├── repository/     # 数据仓库
│   │   │   │   └── dao/            # 数据访问对象
│   │   │   ├── domain/             # 业务逻辑
│   │   │   ├── ui/
│   │   │   │   ├── theme/          # 应用主题
│   │   │   │   ├── components/     # 可复用组件
│   │   │   │   ├── home/           # 主页界面
│   │   │   │   ├── webview/        # WebView界面
│   │   │   │   └── favorites/      # 收藏界面
│   │   │   ├── common/             # 通用工具类
│   │   │   └── App.kt              # 应用入口
│   │   └── res/                    # 资源文件
│   └── build.gradle                # 模块构建配置
├── gradle/                         # Gradle包装器文件
├── build.gradle                    # 项目构建配置
└── settings.gradle                 # 项目设置
```

## 🔧 核心组件

### 数据模型

```
// AI网站数据类
data class AIWebsite(
    val id: Int,
    val name: String,
    val url: String,
    val description: String,
    val category: String,
    val faviconUrl: String,
    val isFavorite: Boolean = false
)

// AI分类数据类
data class AICategory(
    val id: Int,
    val name: String,
    val websites: List<AIWebsite>
)
```

### 数据提供器

```
object DataProvider {
    fun getAICategories(): List<AICategory> {
        // 返回分类和网站数据
    }
}
```

### 图标加载器

```
object FaviconLoader {
    fun getFaviconUrl(url: String): String {
        // 生成favicon URL
    }
}
```

## 🚀 性能优化

- 使用Coil进行图像加载和缓存
- 采用LazyColumn和LazyRow实现列表的懒加载
- 实现图标内存缓存，减少网络请求
- 使用DerivedState优化状态管理，减少不必要的重组

## 📝 开发计划

### 短期计划

- 添加用户评分和评论功能
- 实现网站提交功能，允许用户添加新网站
- 增加深色主题支持
- 添加数据同步功能（收藏夹云端备份）

### 长期计划

- 集成AI推荐算法，个性化推荐网站
- 添加使用统计和分析功能
- 开发iOS和Web版本
- 实现插件系统，支持第三方扩展

## 🤝 贡献指南

我们欢迎任何形式的贡献！请遵循以下步骤：

1. Fork本项目
2. 创建特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 开启Pull Request

### 开发规范

- 遵循Kotlin编码规范
- 使用描述性的提交信息
- 为新功能添加单元测试
- 更新相关文档

## 📄 许可证

本项目采用Apache 2.0许可证 - 查看 LICENSE 文件了解详情。

## 📞 联系我们

- 邮箱：dawn-666@qq.com
- GitHub Issues：提交问题
- 项目地址：https://github.com/Dawn-666/AiNavigator

## 🙏 致谢

感谢以下开源项目和技术：

- Jetpack Compose
- Coil
- Material Design 3
- Google Favicon Service

------

<p align="center"> <b>如果这个项目对您有帮助，请给个⭐️支持一下！</b> </p>