# 字段解释

**下面列出的所有字段均是可选的。**

### ActionResult

| 字段               | 类型                                                                    | 说明                                             | 示例                 |
|------------------|-----------------------------------------------------------------------|------------------------------------------------|--------------------|
| actionId         | String                                                                | 结果的ID，他将影响结果的权重，也是唯一标识符，我们将使用这个ID来删除重复值        | "id"               |
| score            | Int                                                                   | 结果的分数，对排序有一定的影响                                | 90                 |
| logo             | Object                                                                | 在通用插件中，本字段类型是String，在Jar插件中，还可以是image，或painter | "./logos/logo.png" |
| title            | List<[ActionResultTitle](#actionresulttitle)>                         | 标题                                             |                    |
| subtitle         | String                                                                | 副标题                                            | "subtitle"         |
| result           | Object                                                                | 真实的运算结果                                        | null               |
| callbacks        | List<[ActionResultCallback](appendix/action_result_callback.md#字段解释)> | 回调执行方法                                         |                    |
| content          | @Composable                                                           | 自定义动作的界面，仅Jar插件支持                              |                    |
| contentHeight    | Int                                                                   | 自定义界面的高度，设置为-1我们将不限制高度                         |                    |
| executedCallback | Object                                                                | 回调被执行通知，在通用插件中，本字段是一个字符串                       |                    |

### ActionResultTitle

| 字段    | 类型                                        | 说明    | 示例            |
|-------|-------------------------------------------|-------|---------------|
| value | String                                    | 标题的值  | "Title"       |
| type  | Enum<[ActionTitleType](#actiontitletype)> | 标题的类型 | "PLAIN_TITLE" |

### ActionTitleType

| 名称              | 说明   |
|-----------------|------|
| HIGHLIGHT_TITLE | 高亮文本 |
| PLAIN_TITLE     | 普通文本 |
| SUBTITLE        | 下标文本 |

### Json示例

```json
{
    "actionId": "id",
    "score": 90,
    "logo": "./logos/logo.png",
    "title": [
        {
            "value": "Highlight",
            "type": "HIGHLIGHT_TITLE"
        },
        {
            "value": "Plain",
            "type": "PLAIN_TITLE"
        },
        {
            "value": "Subscript",
            "type": "SUBTITLE"
        }
    ],
    "subtitle": "subtitle",
    "result": null,
    "callbacks": [
        {
            "icon": "./logos/icon.png",
            "label": "Copy",
            "result": "some text",
            "actionMethod": "COPY_RESULT",
            "sortOrder": "NONE",
            "actionWindowBehavior": "HIDE_IF_POSSIBLE",
            "showNotify": true
        }
    ]
}
```
