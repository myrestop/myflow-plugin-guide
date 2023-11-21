# 字段解释

**下面列出的所有字段均是可选的。**

### ActionResultCallback

| 字段                   | 类型                                                  | 说明                                                   | 示例                 |
|----------------------|-----------------------------------------------------|------------------------------------------------------|--------------------|
| icon                 | Object                                              | 在通用插件中，这是一个字符串，在Jar插件中，还可以是image，或painter            | "./logos/icon.png" |
| label                | String                                              | 回调的标签                                                | "Copy"             |
| result               | Object                                              | 真实的运算结果                                              |                    |
| actionMethod         | Enum<[ActionMethod](#actionmethod)>                 | 回调执行的方法                                              | "COPY_RESULT"      |
| actionCallback       | Object                                              | 自定义回调执行方式，设置这个值后我们会忽略`actionMethod`字段，在通用插件中，这是一个字符串 |                    |
| sortOrder            | Enum<[SortOrder](#sortorder)>                       | 排序优先级                                                | "NONE"             |
| actionWindowBehavior | Enum<[ActionWindowBehavior](#actionwindowbehavior)> | 回调被执行后工作窗口的处理方式                                      | "HIDE_IF_POSSIBLE" |
| showNotify           | Boolean                                             | 是否显示通知                                               | true               |

### ActionMethod

| 名称                        | 说明                                                                     |
|---------------------------|------------------------------------------------------------------------|
| OPEN_FILE                 | 将结果作为文件打开                                                              |
| OPEN_URL                  | 将结果作为URL并用默认浏览器打开                                                      |
| COPY_RESULT               | 复制结果                                                                   |
| COPY_AND_PASTE            | 复制并粘贴结果                                                                |
| COMMANDLINE               | 将结果作为终端命令执行                                                            |
| PYTHON_SCRIPT             | 将结果作为Python脚本执行                                                        |
| GOTO_FUNC_PAGE            | 将结果作为[工作页](conceptual_interpretation.md#工作页)打开                         |
| SET_TO_ACTION_TEXT        | 将结果作为字符串输入到[动作输入框](conceptual_interpretation.md#动作输入框actioninputfield) |
| POWERSHELL_SCRIPT         | 将结果作为多行的PowerShell脚本执行                                                 |
| POWERSHELL_SINGLE_COMMAND | 将结果作为单行的PowerShell命令执行                                                 |

### SortOrder

| 名称    | 说明   |
|-------|------|
| NONE  | 普通   |
| FRONT | 排在前面 |
| LAST  | 排在后面 |

### [ActionWindow](conceptual_interpretation.md#工作窗口actionwindow)Behavior

| 名称               | 说明           |
|------------------|--------------|
| FORCE_HIDE       | 强制隐藏工作窗口     |
| HIDE_IF_POSSIBLE | 如果可能的话隐藏工作窗口 |
| EMPTY_LIST       | 清空结果列表       |
| REFRESH_LIST     | 刷新结果列表       |
| NOTHING          | 不做任何操作       |


### Json示例

```json
{
    "icon": "./logos/icon.png",
    "label": "Copy",
    "result": "some text",
    "actionMethod": "COPY_RESULT",
    "sortOrder": "NONE",
    "actionWindowBehavior": "HIDE_IF_POSSIBLE",
    "showNotify": true
}
```
