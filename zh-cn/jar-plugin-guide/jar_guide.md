# Jar插件指南

在本教程中，您将学习如何在JVM上编写我们的Jar插件，我们将用**Java**和**Kotlin**来演示这个插件。**在这里我们将讨论许多进阶功能，因此您可以选择您感兴趣的部分阅读，其他部分可以之后随时阅读。**

> **我们强烈建议您使用Kotlin编程。**

## 创建项目

首页，我们需要用[IntellijIdea](https://www.jetbrains.com/idea)创建一个名为`java-demo-plugin`使用[Gradle](https://gradle.org)作为构建工具的Java项目，并使用Kotlin作为GradleDSL语言。

`settings.gradle.kts`内容如下：

[settings.gradle.kts](../../jar-plugin-guide/java-demo-plugin/settings.gradle.kts ':include :type=code kotlin')

`build.gradle.kts`内容如下：

[build.gradle.kts](../../jar-plugin-guide/java-demo-plugin/build.gradle.kts ':include :type=code kotlin')

> 参考我们的[KotlinGradle模板项目](https://github.com/myrestop/myflow-plugin-gradle-template)。

## 新建配置文件

在项目目录下创建名为`plugin-spec.yml`的文件，并写入以下内容：

```yaml
id: runflow.java
name: Java Plugin
entry: ./java-demo-plugin.jar
customize-loader: default
version: 1.0.0
compatible-version:
  since-build: 567
  until-build: 567
```

## 创建MainTest类用于开发与测试

在目录`src/test/java`下创建一个名为`MainTest.java`的类，其代码大致如下：

[MainTest.java](../../jar-plugin-guide/java-demo-plugin/src/test/java/MainTest.java ':include :type=code')

**运行**`MainTest`，你将会看到工作窗口，注意这里没有任何插件，甚至没有内置插件，**这是一个很简单只有基本实现的窗口，仅用于插件开发和测试**。

> [本案例全部代码](https://github.com/myrestop/myflow-plugin-guide/tree/master/jar-plugin-guide/java-demo-plugin)。

## 编写功能

- [**监听器(CycleListener)**](jar-plugin-guide/cycle_listener.md#监听器cyclelistener)解释了如果监听插件的加载状态。

- [**动作(Action)**](jar-plugin-guide/action.md#动作action)解释了如何写一个通用和一个可以自定义界面的动作。

- [**占位符(Placeholder)**](jar-plugin-guide/placeholder.md#占位符placeholder)解释了如果更新占位符。

- [**主题(Theme)**](jar-plugin-guide/theme.md#主题theme)解释了如何更新主题。

- [**扩展动作回调**](jar-plugin-guide/callback_extension.md#扩展动作回调)解释了如何扩展动作的回调。

- [**数据存储**](jar-plugin-guide/data_store.md#数据存储)解释了如何使用我们内置的数据库存储数据。

- [**数据加密器**](jar-plugin-guide/data_encryptor.md#数据加密器)解释了如何为数据同步服务提供数据加密的功能。

- [**数据同步服务**](jar-plugin-guide/data_sync_service.md#数据同步服务)解释了如何提供数据同步服务。

- [**翻译**](jar-plugin-guide/translator.md#翻译)解释如何为绑定的语言资源文件提供翻译。

- [**动作专注模式**](jar-plugin-guide/focused_mode.md#动作专注模式)解释了如何让一个动作支持专注模式。

- [**工具栏**](jar-plugin-guide/toolbar.md#工具栏)解释了如何提供一个工具栏。

- [**功能页**](jar-plugin-guide/func_page.md#功能页)解释了如何实现一个自定义的界面。

- [**工作窗口(ActionWindow)**](jar-plugin-guide/action_window.md#工作窗口actionwindow)解释了如何替换我们的工作窗口。

- [**Http服务**](jar-plugin-guide/http_service.md#http服务)解释了如何使用我们内置的http服务来公开接口。

- [**绑定语言**](jar-plugin-guide/bundle_language.md#绑定语言到javabean)解释了如何将语言资源绑定到JavaBean。

- [**实用工具**](jar-plugin-guide/utilities.md#实用工具)解释了所有常用的类、方法和字段。