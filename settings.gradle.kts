pluginManagement {
    repositories {
        // 国内镜像优先
        maven { url = uri("https://maven.aliyun.com/repository/public") }
        maven { url = uri("https://maven.aliyun.com/repository/google") }
        maven { url = uri("https://maven.aliyun.com/repository/gradle-plugin") }

        // 备用镜像
        maven { url = uri("https://repo.huaweicloud.com/repository/maven") }

        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    // repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        // 本地仓库优先
        mavenLocal()

        // 国内镜像
        maven { url = uri("https://maven.aliyun.com/repository/public") }
        maven { url = uri("https://maven.aliyun.com/repository/google") }
        maven { url = uri("https://repo.huaweicloud.com/repository/maven") }
        maven { url = uri("https://mirrors.cloud.tencent.com/nexus/repository/maven-public") }

        // 官方源
        google()
        mavenCentral()

        // 自定义仓库
        maven {
            url = uri("https://jitpack.io")
            content {
                includeGroup("com.github")
            }
        }
    }
}

rootProject.name = "AiNavigator"
include(":app")
 