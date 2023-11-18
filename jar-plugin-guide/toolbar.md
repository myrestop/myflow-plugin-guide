# Toolbar

Toolbar is the part of the action, and make sure you are familiar with [**Jetpack Compose**](https://developer.android.com/jetpack/compose/documentation). To provide a toolbar on action you should implement class `top.myrest.myflow.component.ActionKeywordToolbar`, and here we use kotlin to give an example:

[KotlinToolbar.kt](java-demo-plugin/src/main/kotlin/runflow/KotlinToolbar.kt ':include :type=code')

To config `plugin-spec.yml`, you should config the item `toolbar: runflow.KotlinToolbar` to the specific [action](jar-plugin-guide/action.md#kotlin-action), like this:

```yaml
actions:
  - keywords:
      - kotlin
    name-bundle-id: Demo Action
    handler: runflow.KotlinActionHandler
    toolbar: runflow.KotlinToolbar
```
