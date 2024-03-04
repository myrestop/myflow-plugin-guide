# 功能页

要编写功能页，请确保您熟悉[**JetpackCompose**](https://developer.android.com/jetpack/compose/documentation)。

打开功能页也是依赖动作的，代码如下：

[KotlinFuncPage.kt](../../jar-plugin-guide/java-demo-plugin/src/main/kotlin/runflow/KotlinFuncPage.kt ':include :type=code')

配置`plugin-spec.yml`：

```yaml
actions:
  - keywords:
      - funcpage
    name-bundle-id: Demo Func Page
    handler: runflow.KotlinFuncPage
```

## ActionKeywordFuncPageContentResult

| 字段                  | 类型                   | 必填 | 说明                            | 示例                 |
|---------------------|----------------------|----|-------------------------------|--------------------|
| logo                | Object               | 是  | logo，可以是string，image，或painter | "./logos/logo.png" |
| height              | Int                  | 是  | 初始的高度                         | 600                |
| nameBundleId        | String               | 是  | 名称的资源绑定ID                     | "app-name"         |
| pinName             | String               | 是  | 固定名称                          | "Demo"             |
| initSelect          | Boolean              | 否  | 初始化时打开                        | true               |
| arg                 | Object               | 否  | 参数                            | null               |
| placeholderBundleId | String               | 否  | 占位符的资源绑定ID                    | "app-name"         |
| toolbar             | ActionKeywordToolbar | 否  | 工具栏                           | null               |
| hideActionTextField | Boolean              | 否  | 隐藏动作输入框                       | false              |
| content             | @Composable          | 是  | 功能页界面                         |                    |

## FuncPageScope

| 字段  | 类型                                                                  | 说明       |
|-----|---------------------------------------------------------------------|----------|
| pin | [ActionKeywordPin](appendix/action_keyword_pin.md#actionkeywordpin) | 当前固定的关键字 |
| arg | Object                                                              | 您传递的参数   |

| 方法                                                                  | 说明        |
|---------------------------------------------------------------------|-----------|
| Modifier.removeStateCacheOnUnpin()                                  | 删除缓存      |
| Modifier.onActionTextChanged(onEvent: (param: ActionParam) -> Unit) | 动作文本更新事件  |
| Modifier.onFileChooserRequest(onEvent: () -> Unit)                  | 请求打开文件选择器 |
| Modifier.onActionWindowShow(onEvent: () -> Unit)                    | 工作窗口显示事件  |

## 功能页里的Remember

在[JetpackCompose](https://developer.android.com/jetpack/compose/documentation)中，您可以使用语法`var value by remeber {}`来缓存一个状态，直到组合被销毁，但是这里，当用户切换固定的关键字之后，实质上组合已经被销毁了。

因此我们需要使用相同的语法`var value by remember4FuncPage {}`在整个功能页的生命周期缓存状态，方法`remember4FuncPage`位于`top.myrest.myflow.component.Composes`。
