# Action

In this section, we'll write two action, one action writing in java that returns emojis like [general plugin demo](general-plugin-guide/action.md#action), another writing in kotlin that can dynamic refresh the content by customizing ui.

## Java Action

Create a java file named `JavaActionHandler.java` locate in `src/main/java/runflow`, writing the following content:

[JavaActionHandler.java](java-demo-plugin/src/main/java/runflow/JavaActionHandler.java ':include :type=code')

Add the following content to `plugin-spec.yml`:

```yaml
actions:
  - keywords:
      - java
    handler: runflow.JavaActionHandler
```

## Kotlin Action

In kotlin action, we'll return two results, one result can refresh by `Alt` key, another can show currently real time that implements by customized ui. **If you want to customize ui, you need know [Jetpack Compose](https://developer.android.com/jetpack/compose/documentation) firstly.**

Now, let's create a kotlin file named `KotlinActionHandler.kt` locate in `src/main/kotlin/runflow`, writing the following content:

[KotlinActionHandler.java](java-demo-plugin/src/main/kotlin/runflow/KotlinActionHandler.kt ':include :type=code')

Add the following content in `plugin-spec.yml`'s `actions` node:

```yaml
  - keywords:
      - kotlin
    name-bundle-id: Demo Action
    handler: runflow.KotlinActionHandler
```

## Note

> `ActionRequireArgHandler` is our optimized abstraction class, you can also implement the top interface class `ActionKeywordHandler`.

> How to customize the action settings content? Override the method `getCustomizeSettingContent`, and return an instance which implemented `top.myrest.myflow.component.SettingsContent` interface class. To implement this function, you should know [Jetpack Compose](https://developer.android.com/jetpack/compose/documentation) firstly.

Read explanation: [**ActionParam**](appendix/action_param.md#action-param), [**ActionResult**](appendix/action_result.md#fields-explanation), [**ActionResultCallback**](appendix/action_result_callback.md#fields-explanation), [HotEventType](appendix/hot_event_type.md#hot-event-type).
