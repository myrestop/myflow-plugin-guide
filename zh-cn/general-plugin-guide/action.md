# 动作(Action)

In this section, we'll write an action that responds emojis.

To write an action, maybe these four methods you'll be used: `HOT_EVENT`, `QUERY_ACTION`, `ACTION_CALLBACK`, `EXECUTED_CALLBACK`.

## Hot Event

This method triggered by user settings, maybe from hot corner, hotkey or cron express. See [hot event type](appendix/hot_event_type.md#hot-event-type).

Request example json:

```json
{
    "method": "HOT_EVENT",
    "body": {
        "type": "HOTKEY"
    }
}
```

## Query Action

This is the main method for our results querying, in this method, we'll pass an [**action param**](appendix/action_param.md#action-param) to you in body, you need return an [action result](appendix/action_result.md#fields-explanation) list.

Request example json:

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

Response example json:

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
                "actionCallback": "action callback"
            }
        ],
        "executedCallback": "callback executed"
    }
]
```

## Action Callback

If user called your customized result callback, we'll pass the result and value to you.

Request example json:

```json
{
    "method": "ACTION_CALLBACK",
    "body": {
        "actionCallback": "action callback",
        "result": "😃😃😃"
    }
}
```

## Executed Callback

If user called any of your result callback, we'll pass the result and value to you.

Request example json:

```json
{
    "method": "EXECUTED_CALLBACK",
    "body": {
        "executedCallback": "callback executed",
        "result": "😃😃😃"
    }
}
```

## Writing Action

In this example, we will respond with the same number of emojis based on the length of argument of user input.

<!-- tabs:start -->

#### **Commandline**

In this example, you should build an executable binary file or write an executable shell script, you can get an argument from commandline.

And you can refer our [**sample code**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/commandline-demo-plugin/src/nativeMain/kotlin/Main.kt) in [**commandline demo plugin**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/commandline-demo-plugin).

#### **HTTP**

In this example, you need expose an endpoint `/action` in your web server, we'll use post method to request you.

And you can refer our [**sample code**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/http-demo-plugin/src/main/kotlin/runflow/Main.kt) in [**http demo plugin**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/http-demo-plugin).

#### **Python**

In this example we create an action file named `action.py`, and writing the following content:

[action.py](python-demo-plugin/action.py ':include :type=code')

#### **QLExpress**

In this example we create an action file named `action.qlexpress`, and writing the following content:

[action.qlexpress](qlexpress-demo-plugin/action.qlexpress ':include :type=code java')

**Action special in qlexpress:** you can just return a string value, we'll convert to the following structure, otherwise you should use `java.util.List` to wrap the `java.util.Map`.

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

## Adding To Specification File

Add the following content to `plugin-spec.yml`:

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
