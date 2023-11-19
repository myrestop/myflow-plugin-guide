# Func Page

To write a func page, please make sure you are familiar with [**Jetpack Compose**](https://developer.android.com/jetpack/compose/documentation).

To open the func page also depends on the action, the codes like the following:

[KotlinFuncPage.kt](java-demo-plugin/src/main/kotlin/runflow/KotlinFuncPage.kt ':include :type=code')

Config to `plugin-spec.yml`:

```yaml
actions:
  - keywords:
      - funcpage
    name-bundle-id: Demo Func Page
    handler: runflow.KotlinFuncPage
```

## Action Keyword Func Page Content Result

| field               | type                 | require | explanation                                  | example            |
|---------------------|----------------------|---------|----------------------------------------------|--------------------|
| logo                | Object               | yes     | the logo, type can be String, Image, Painter | "./logos/logo.png" |
| height              | Int                  | yes     | init height                                  | 600                |
| nameBundleId        | String               | yes     | name bundled id                              | "app-name"         |
| pinName             | String               | yes     | pin name                                     | "Demo"             |
| initSelect          | Boolean              | no      | init select                                  | true               |
| arg                 | Object               | no      | arguments                                    | null               |
| placeholderBundleId | String               | no      | placeholder bundled id                       | "app-name"         |
| toolbar             | ActionKeywordToolbar | no      | func page toolbar                            | null               |
| hideActionTextField | Boolean              | no      | hide action text input field                 | false              |
| content             | @Composable          | yes     | func page content                            |                    |

## Func Page Scope

| field | type                                                                  | explanation    |
|-------|-----------------------------------------------------------------------|----------------|
| pin   | [ActionKeywordPin](appendix/action_keyword_pin.md#action-keyword-pin) | current pin    |
| arg   | Object                                                                | your given arg |

| method                                                              | explanation                                  |
|---------------------------------------------------------------------|----------------------------------------------|
| Modifier.removeStateCacheOnUnpin()                                  | remove state chache for this func page score |
| Modifier.onActionTextChanged(onEvent: (param: ActionParam) -> Unit) | action changed event                         |
| Modifier.onFileChooserRequest(onEvent: () -> Unit)                  | request open file chooser                    |
| Modifier.onActionWindowShow(onEvent: () -> Unit)                    | action window showed event                   |

## Remember For Func Page

In [jetpack compose](https://developer.android.com/jetpack/compose/documentation) you use the syntax `var value by remeber {}` to cache a state until the composition is destroyed, but when user switch the pinned keyword, the current composition is disposed in fact.

So we need to cache the state through the whole FuncPage's life cycle, by using the same syntax `var value by remember4FuncPage {}`, the method `remember4FuncPage` is located in `top.myrest.myflow.component.Composes`.
