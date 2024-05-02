# 动作(Action)

在本节中，我们将编写一个响应表情符的动作。

要编写一个动作，您可能会遇到这四种请求方法：`HOT_EVENT`、`QUERY_ACTION`、`ACTION_CALLBACK`、`EXECUTED_CALLBACK`。

## HotEvent

用户可以设置由热点事件触发，可能是触发角、热键或cron表达式等，更多可查看[HotEventType](appendix/hot_event_type.md#hoteventtype)。

请求的Json示例：

```json
{
    "method": "HOT_EVENT",
    "body": {
        "type": "HOTKEY"
    }
}
```

## QueryAction

这是我们查询动作结果的主要请求方法，在这个方法中，我们将在body带一个[**ActionParam**](appendix/action_param.md#actionparam)给您，您需要返回一个[ActionResult](appendix/action_result.md#字段解释)列表。

请求的Json示例：

```json
{
    "method": "QUERY_ACTION",
    "body": {
        "scene": "MAIN",
        "originAction": "emoji abc",
        "keyword": "emoji",
        "args": [
            {
                "value": "abc",
                "type": "STRING",
                "strValue": "abc"
            }
        ],
        "sizeLimit": 10
    }
}
```

响应的Json示例：

```json
[
    {
        "actionId": "emoji",
        "title": [
            {
                "value": "😃😃😃",
                "type": "PLAIN_TITLE"
            }
        ],
        "result": "😃😃😃",
        "callbacks": [
            {
                "label": "a-language-bundle-id",
                "actionCallback": "action callback"
            }
        ],
        "executedCallback": "callback executed",
        "shouldAssignBundle": true
    }
]
```

> `shouldAssignBundle` 字段说明：表示需要对返回的内容用绑定的语言资源进行翻译。

## ActionCallback

如果用户执行了您自定义的结果回调，我们会将结果和您定义的值传递给您。

请求的Json示例：

```json
{
    "method": "ACTION_CALLBACK",
    "body": {
        "actionCallback": "action callback",
        "result": "😃😃😃"
    }
}
```

## ExecutedCallback

如果用户执行了您的任何结果回调，我们会将结果和您定义的值传递给您。

请求的Json示例：

```json
{
    "method": "EXECUTED_CALLBACK",
    "body": {
        "executedCallback": "callback executed",
        "result": "😃😃😃"
    }
}
```

## 编写动作

在本示例中，我们将响应与用户输入参数相同长度的表情符。

<!-- tabs:start -->

#### **Commandline**

在本示例中，您需要构建一个可执行的二进制文件或编写一个可执行的shell脚本，您可以从命令行获取参数。

您也可以参考位于我们项目[**CommandlineDemoPlugin**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/commandline-demo-plugin)的[**示例代码**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/commandline-demo-plugin/src/nativeMain/kotlin/Main.kt)。

#### **HTTP**

在本示例中，您需要在您服务器端公开一个`/action`的接口，我们将会post方法请求这个接口。

您也可以参考位于我们项目[**HttpDemoPlugin**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/http-demo-plugin)的[**示例代码**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/http-demo-plugin/src/main/kotlin/runflow/Main.kt)。

#### **Python**

在本示例中，我们需要创建一个名为`action.py`的文件，并写入以下内容：

[action.py](../../general-plugin-guide/python-demo-plugin/action.py ':include :type=code')

#### **QLExpress**

在本示例中，我们需要创建一个名为`action.qlexpress`的文件，并写入以下内容：

[action.qlexpress](../../general-plugin-guide/qlexpress-demo-plugin/action.qlexpress ':include :type=code java')

**qlexpress里的特殊情况：** 您可以只返回一个字符串，我们会将其转换为下面的结构，否则您应该返回一个`java.util.List`包装的`java.util.Map`。

```json
[
    {
        "actionId": "qlexpress",
        "score": 100,
        "logo": "logos/sine.png",
        "result": "your returned string value",
        "title": [
            {
                "value": "your returned string value",
                "type": "PLAIN_TITLE"
            }
        ],
        "subtitle": "Copy Result To The Clipboard",
        "callbacks": [
            {
                "actionMethod": "COPY_RESULT"
            }
        ]
    }
]
```

<!-- tabs:end -->

## 添加到配置文件

添加以下内容到文件`plugin-spec.yml`：

<!-- tabs:start -->

#### **Commandline**

```yaml
actions:
  - keywords:
      - clemoji
    handler: "{entry}"
```

#### **HTTP**

```yaml
actions:
  - keywords:
      - httpemoji
    handler: "{entry}/action"
```

#### **Python**

```yaml
actions:
  - keywords:
      - pyemoji
    handler: ./action.py
```

#### **QLExpress**

```yaml
actions:
  - keywords:
      - qlemoji
    handler: ./action.qlexpress
```

<!-- tabs:end -->
