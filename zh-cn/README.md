# 欢迎阅读我们的RunFlow插件开发指南

如果您是一名开发人员，无论您使用何种编程语言，本文档将带您了解如何快速开发一个RunFlow插件。

**因为我们允许您不受任何技术层面的限制开发插件，所以您必须确保您的插件对用户来说是安全的，并且不违反任何法律。**

如果您是Java、Kotlin或其他任何基于JVM的开发人员，那么您可以与RunFlow有更友好的交互，因为您可以直接使用我们向您公开的许多API，您还可以自定义程序界面。

在开始我们的插件开发旅程之前，请确保您已阅读我们的[RunFlow用户手册](https://myrest.top/guide/myflow/user)，这将对您阅读本文档有所帮助。

> 如果您不是开发人员，那么您无需阅读此文档。

## 简介

RunFlow是一款可以通过插件来扩展功能的强大的效率工具，并且插件不受编程语言的限制，您可以使用任何您熟悉的编程语言来开发插件，这将为我们的应用程序带来无限的可能。

在这里，我们也诚挚的邀请您成为我们平台的插件开发者，让我们共同打造这个生产力工具，让他更加开放、自由、高效。

## 要求

- 安装应用程序[RunFlow](https://myrest.top/myflow)

- 熟悉任何一门编程语言

## 摘要

[**快速开始**](getting_started.md#快速开始)解释了如何编写一个“Hello RunFlow”插件，其中包括多语言支持和撰写插件描述，并且我们还将向您展示插件配置文件`plugin-spec.yml`中的一些核心字段。

[**名词解释**](conceptual_interpretation.md#名词解释)涵盖了我们的主要功能和一些概念，这些都会很容易理解。

[**通用插件指南**](general-plugin-guide/general_guide.md#general-plugin-guide)向您展示了如何编写一个功能齐全的通用插件，包括ActionHandler、ThemeProvider、PlaceholderUpdater和插件CycleListener。

[**Jar插件指南**](jar-plugin-guide/jar_guide.md#jar-plugin-guide)，在本指南中，我们将讨论许多高级功能和API，Jar插件可以直接集成到我们的应用程序中，您可以在运行时做任何您想做的工作。

[**上传插件**](upload_plugin.md#upload-to-plugin-store)，在本章中，您将了解如何将插件上传到我们的插件商店。

[**附录**](appendix/appendix.md#appendix)包含了一些非常有用的参考资料。
