# 快速开始

在本章中，您将了解如何编写一个响应固定内容的插件。

> 请确保您已安装应用程序[RunFlow](https://myrest.top/myflow)。

## 创建项目目录

首先，您需要在您喜欢的任意位置创建一个目录，您不需要关心目录位于哪里，或者您也可以直接选择一个已存在的目录。在这里，我们将创建一个名为`hello-runflow`的目录。

## 创建JSON文件

接下来, 我们需要创建一个名为`hello_runflow.json`的JSON文件来响应内容（取什么文件名并不重要，只是这里我们这样命名而已），打来文件并写入以下内容：

[hello_runflow.json](../hello-runflow/hello_runflow.json ':include :type=code')

> 了解这些字段的含义请查看[动作结果(ActionResult)](appendix/action_result.md#字段解释)。

## 创建插件配置文件

在这一步中，您需要创建一个名为`plugin-spec.yml`的插件配置文件（注意：**配置文件的名称是固定的，您不能修改他**），然后写入以下内容到文件：

[plugin-spec.yml](../hello-runflow/plugin-spec.yml ':include :type=code')

> 了解这些字段的含义请查看[PluginSpecificationConfiguration](appendix/plugin_specification.md#plugin-specification)。

## 绑定语言资源文件（可选）

如果您想插件支持多语言，那么您需要绑定语言资源文件。

创建一个名为`language`的目录，然后在`language`目录下创建一个名为`en_us.yml`的英语语言文件。如果您也想支持简体中文，您可以创建一个名为`zh_cn.yml`的文件，[查看其他语言编码](appendix/language_code.md#语言编码)。

文件内容如下：

**en_us.yml**

[en_us.yml](../hello-runflow/language/en_us.yml ':include :type=code')

**zh_cn.yml**

[zh_cn.yml](../hello-runflow/language/zh_cn.yml ':include :type=code')


> **我们强烈建议开发者至少需要支持英语语言。**

## 描述插件（可选）

用户将从您撰写的插件描述文档中了解到您的插件提供了哪些功能以及如何更便捷的使用这些功能。

通过英文描述插件请创建文件`description_en_us.md`，并撰写对用户有用的内容。在本示例中，我们写入以下内容：

[description_en_us.yml](../hello-runflow/description_en_us.md ':include :type=code')

通过简体中文描述插件请创建`description_zh_cn.yml`文件：

[description_zh_cn.yml](../hello-runflow/description_zh_cn.md ':include :type=code')

## 运行插件

当您跟着我们的步骤操作到这里时，所有的工作均已完成，现在我们只需要运行插件。打开RunFlow工作窗口，打开**设置** -> **通用设置**，滚动到最底部，您会看到一个`加载外部插件`的标签，选择本示例插件的`plugin-spec.yml`来加载当前插件。

然后在动作输入框中键入关键字`hello`，您将看到运行结果：`你好RunFlow`。当您将语言切换至英语时，重新键入关键字您将看到`Hello RunFlow`（如果您绑定了`en_us.yml`资源文件）。

> [查看本示例全部代码](https://github.com/myrestop/myflow-plugin-guide/tree/master/hello-runflow)

## 接下来做什么

了解我们的[**功能与设计**](conceptual_interpretation.md#功能与设计)。
