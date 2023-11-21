# Toolbar

工具栏是动作的一部分，实现工具栏请确保您已熟悉[**JetpackCompose**](https://developer.android.com/jetpack/compose/documentation)。要编写一个动作的工具栏，您需要实现`top.myrest.myflow.component.ActionKeywordToolbar`接口，这里我们使用Kotlin给出示例：

[KotlinToolbar.kt](../../jar-plugin-guide/java-demo-plugin/src/main/kotlin/runflow/KotlinToolbar.kt ':include :type=code')

要配置`plugin-spec.yml`文件，您可以将`toolbar: runflow.KotlinToolbar`添加到指定[动作](jar-plugin-guide/action.md#kotlin-action)下面，像这样：

```yaml
actions:
  - keywords:
      - kotlin
    name-bundle-id: Demo Action
    handler: runflow.KotlinActionHandler
    toolbar: runflow.KotlinToolbar
```
