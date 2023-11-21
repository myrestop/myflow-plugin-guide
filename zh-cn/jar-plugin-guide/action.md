# 动作(Action)

在本节中，我们将编写两个动作，一个用Java编写和通用插件[GeneralPluginDemo](general-plugin-guide/action.md#动作action)的示例一样返回表情符，另一个用Kotlin编写，可以通过自定义UI动态刷新内容。

## Java

在`src/main/java/runflow`目录下创建一个名为`JavaActionHandler.java`的类，并写入以下内容：

[JavaActionHandler.java](../../jar-plugin-guide/java-demo-plugin/src/main/java/runflow/JavaActionHandler.java ':include :type=code')

添加以下内容到文件`plugin-spec.yml`：

```yaml
actions:
  - keywords:
      - java
    handler: runflow.JavaActionHandler
```

## Kotlin

在这个Kotlin写的动作中，我们将返回两个结果，一个可以通过`Alt`键刷新，另一个可以实时显示当前时间。**如果您想自定义界面内容，首先需要了解[JetpackCompose](https://developer.android.com/jetpack/compose/documentation)。**

现在，让我们在`src/main/kotlin/runflow`目录下创建一个名为`KotlinActionHandler.kt`文件，并写入以下内容：

[KotlinActionHandler.java](../../jar-plugin-guide/java-demo-plugin/src/main/kotlin/runflow/KotlinActionHandler.kt ':include :type=code')

添加下面的内容到文件`plugin-spec.yml`里`actions`节点下：

```yaml
  - keywords:
      - kotlin
    name-bundle-id: Demo Action
    handler: runflow.KotlinActionHandler
```

## 注意

> `ActionRequireArgHandler`是我们一个优化的抽象类，您也可以直接实现上层接口`ActionKeywordHandler`。

> 如何自定义动作的设置界面？通过重写`getCustomizeSettingContent`方法，并返回一个实现了`top.myrest.myflow.component.SettingsContent`接口的实例。要实现这个功能，您应该首先了解[JetpackCompose](https://developer.android.com/jetpack/compose/documentation)。

了解关联的说明：[**ActionParam**](appendix/action_param.md#actionparam)，[**ActionResult**](appendix/action_result.md#字段解释)，[**ActionResultCallback**](appendix/action_result_callback.md#字段解释)，[HotEventType](appendix/hot_event_type.md#hoteventtype)。
