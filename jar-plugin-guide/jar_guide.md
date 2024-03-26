# Jar Plugin Guide

In this tutorial, you'll learn how to write a jar plugin on JVM, we'll use both **Java** and **Kotlin** to program this demo plugin. **And we'll discuss more advanced features, so you can choose some you needed parts to read, other parts can be read at any time later.**

> **We strongly recommend programing in kotlin.**

## Creating Project

First step, we need to use [intellij idea](https://www.jetbrains.com/idea) to create a java project named `java-demo-plugin` using [gradle](https://gradle.org) as the build tool, and choosing kotlin as the gradle dsl.

`settings.gradle.kts` content as follows:

[settings.gradle.kts](java-demo-plugin/settings.gradle.kts ':include :type=code kotlin')

`build.gradle.kts` content as follows:

[build.gradle.kts](java-demo-plugin/build.gradle.kts ':include :type=code kotlin')

> Refer our [kotlin gradle template](https://github.com/myrestop/myflow-plugin-gradle-template).

## Creating Plugin Specification File

Create `plugin-spec.yml` in project directory, writing content as follows:

```yaml
id: runflow.java
name: Java Plugin
entry: ./java-demo-plugin.jar
customize-loader: default
version: 1.0.0
compatible-version:
  since-build: 1
  until-build: 516
```

## Adding MainTest Class For Developing And Testing

Create a `MainTest.java` file locate in `src/test/java`, the codes like following:

[MainTest.java](java-demo-plugin/src/test/java/MainTest.java ':include :type=code')

**Run** `MainTest`, you'll see the action window, here is no any plugins, even no builtin plugin, **it's simple and base implemented only, just for plugin developing and testing**.

> [This sample full codes](https://github.com/myrestop/myflow-plugin-guide/tree/master/jar-plugin-guide/java-demo-plugin).

## Writing Functions

- [**Cycle Listener**](jar-plugin-guide/cycle_listener.md#cycle-listener) interprets how to listen plugin loading state.

- [**Action**](jar-plugin-guide/action.md#action) interprets how to write a general action, and an action of customized ui.

- [**Placeholder**](jar-plugin-guide/placeholder.md#placeholder) interprets how to update our placeholder.

- [**Theme**](jar-plugin-guide/theme.md#theme) interprets how to update our theme.

- [**Action Callback Extension**](jar-plugin-guide/callback_extension.md#action-callback-extension) interprets how to extend action callbacks.

- [**Storing Data**](jar-plugin-guide/data_store.md#storing-data) interprets how to store data by using our builtin database, and some requirements.

- [**Data Encryptor**](jar-plugin-guide/data_encryptor.md#data-encryptor) interprets how to provide data encryptors for data sync service.

- [**Data Sync Service**](jar-plugin-guide/data_sync_service.md#data-sync-service) interprets how to provide data sync methods for user.

- [**Translator**](jar-plugin-guide/translator.md#translator) interprets how to provide language translator for user to translate bundled language resources.

- [**Action Focused Mode**](jar-plugin-guide/focused_mode.md#action-focused-mode) interprets how to write an action that supports focused mode.

- [**Toolbar**](jar-plugin-guide/toolbar.md#toolbar) interprets how to write a toolbar.

- [**Func Page**](jar-plugin-guide/func_page.md#func-page) interprets how to write a func page with gui.

- [**Action Window**](jar-plugin-guide/action_window.md#action-window) interprets how to replace our action window.

- [**Http Service**](jar-plugin-guide/http_service.md#http-service) interprets how to use our builtin http service to expose endpoint.

- [**Bundle Language**](jar-plugin-guide/bundle_language.md#bundle-language-to-bean) interprets how to bundle language resource to java bean.

- [**Utilities**](jar-plugin-guide/utilities.md#utilities) interprets all the useful classes, methods and fields.