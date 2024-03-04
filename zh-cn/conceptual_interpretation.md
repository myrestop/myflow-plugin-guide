# 功能与设计

本章将向您介绍RunFlow的主要功能和一些设计理论，希望您能从这里了解到如何编写一个具有友好体验的插件。祝您有一个愉快的阅读体验。

## 动作(Action)

一个**动作**代表一个最小单位的功能，他基本由[关键字](#动作关键字actionkeyword)和[处理器](#动作处理器actionhandler)组成，程序会通过用户输入的关键字找到对应的**动作**，然后调用动作的处理器，处理器将返回一个结果列表给我们的[工作窗口](#工作窗口actionwindow)渲染。

## 工作窗口(ActionWindow)

工作窗口是我们应用程序的主要窗口。**工作窗口**的主要工作是负责渲染[固定的关键字](#动作关键字actionkeyword)、工具栏、工作窗口的固定状态、结果被执行的状态通知、[动作输入框](#动作输入框actioninputfield)、[动作结果列表](#动作结果actionresult)以及[动作结果回调](#动作结果回调actionresultcallback)。

## 动作输入框(ActionInputField)

动作输入框是一个可输入的文本框，他的主要工作是获取用户键盘输入的内容，以及展示固定关键字的Logo，他是[**工作窗口**](#工作窗口actionwindow)的一部分。

## 动作关键字(ActionKeyword)

动作关键字（我们也称“关键字”）指一个[**动作**](#动作action)的一个或多个关键字，我们要求关键字的长度不能超过32个字符。

## 动作处理器(ActionHandler)

您的功能代码将主要在**动作处理器**（我们也称“处理器”）这里，我们会将用户输入的内容解析成关键字和参数并传递给您的处理器，您需要处理我们的查询请求并返回一个结果列表。

## 动作结果(ActionResult)

动作结果是指您的处理器返回的结果列表，他的核心字段包括score、logo、title、subtitle、callbacks以及result（真实的运算结果）。

> [动作结果字段解释](appendix/action_result.md#字段解释)

## 动作结果回调(ActionResultCallback)

动作结果回调是指结果的具体执行方法，例如打开或复制结果等等，回调也是动作结果的一部分。

> [动作结果回调字段解释](appendix/action_result_callback.md#字段解释)

## 功能页

功能页是您自定义的界面，他可以作为固定关键字打开，如果您提供的功能需要与用户图形界面交互，那么您需要通过功能页来实现，但此特性只能在[Jar插件](jar-plugin-guide/jar_guide.md#jar插件指南)下可用。如果您熟悉任何JVM类编程语言，您可以阅读[本节](jar-plugin-guide/func_page.md#功能页)来了解如何编写一个功能页。

## 接下来做什么

[**跟着我们的教程编写一个功能齐全的通用插件**](general-plugin-guide/general_guide.md#通用插件指南)，或者[**编写一个Jar插件**](jar-plugin-guide/jar_guide.md#jar插件指南)。
