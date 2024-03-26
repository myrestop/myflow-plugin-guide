# 通用插件指南

从本教程开始，您将了解在实践中如何编写一个插件。在本章中，我们将讨论如何编写一个有动作、占位符和主题的通用插件。

我们将使用`commandline`、`http`、`python`和`qlexress`四种方式来实现这些功能，您可以选择您感兴趣的部分阅读，准备好，让我们开始吧。

## 创建项目目录和插件配置文件

首先，我们需要创建一个项目目录和插件配置文件`plugin-spec.yml`。

<!-- tabs:start -->

#### **Commandline**

在本插件中，我们创建一个名为`commandline-demo-plugin`的目录，并写入以下内容到文件`plugin-spec.yml`中。

```yaml
id: runflow.commandline
name: Commandline Plugin
entry: ./{os}/commandline-demo-plugin
customize-loader: commandline
version: 1.0.0
compatible-version:
  since-build: 567
  until-build: 567
```

**在这类插件实现方式中，我们将通过命令行向您传递一个json字符串被base64编码后的参数，因此当您获取此参数时，首先您需要通过base64解码成json字符串，然后使用您喜欢的json库解析。**

[**本示例全部代码**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/commandline-demo-plugin)。

#### **HTTP**

在本插件中，我们创建一个名为`http-demo-plugin`的目录，并写入以下内容到文件`plugin-spec.yml`中。

```yaml
id: runflow.http
name: HTTP Plugin
entry: http://127.0.0.1:8080
customize-loader: http
version: 1.0.0
compatible-version:
  since-build: 567
  until-build: 567
```

**在这类插件实现方式中，我们将使用post方法并携带一个json正文向您发起请求，并且我们要求您的http接口需要在500毫秒内响应。** 

[**本示例全部代码**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/http-demo-plugin)。

#### **Python**

在本插件中，我们创建一个名为`python-demo-plugin`的目录，并写入以下内容到文件`plugin-spec.yml`中。

```yaml
id: runflow.python
name: Python Plugin
customize-loader: python
version: 1.0.0
compatible-version:
  since-build: 567
  until-build: 567
```

**在这类插件实现方式中，他本质上是和`commandline`一样的，我们将通过命令行向您传递一个json字符串被base64编码后的参数。**

[**本示例全部代码**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/python-demo-plugin)。

#### **QLExpress**

在本插件中，我们创建一个名为`qlexpress-demo-plugin`的目录，并写入以下内容到文件`plugin-spec.yml`中。

```yaml
id: runflow.qlexpress
name: QLExpress Plugin
customize-loader: qlexpress
version: 1.0.0
compatible-version:
  since-build: 567
  until-build: 567
```

**在这类插件实现方式中，请求的json参数我们将直接存放到上下文中，您可以像使用变量一样直接使用他们。** [了解我们对qlexpress的优化](appendix/qlexpress.md#qlexpress) & [了解QLExpress](https://github.com/alibaba/QLExpress)

[**本示例全部代码**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/qlexpress-demo-plugin)。

<!-- tabs:end -->

> [这些字段的含义是什么？](appendix/plugin_specification.md#pluginspecification)

## 请求的公共字段

了解[JsonRpc请求的公共字段](appendix/json_rpc.md#jsonrpc请求的公共字段)，您也可以稍后阅读。

在`qlexpress`类的插件实现方式中，所有的这些字段都是变量，否则是一个json字符串。

## 实现功能

- [**监听器(CycleListener)**](general-plugin-guide/cycle-listener.md#监听器cyclelistener)展示了如何监听插件状态。

- [**动作(Action)**](general-plugin-guide/action.md#动作action)展示了如何解析参数以及响应结果。

- [**占位符(Placeholder)**](general-plugin-guide/placeholder.md#占位符placeholder)展示了如何更新占位符。

- [**主题(Theme)**](general-plugin-guide/theme.md#主题theme)展示了如何更新主题。