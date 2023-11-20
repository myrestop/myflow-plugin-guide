# Fields Explanation

**All these fields are optional at the listed below.**

### Action Result Callback

| field                | type                                                  | explanation                                                                                                    | example            |
|----------------------|-------------------------------------------------------|----------------------------------------------------------------------------------------------------------------|--------------------|
| icon                 | Object                                                | in general plugin, it is a string, in jar plugin, it can be image or painter                                   | "./logos/icon.png" |
| label                | String                                                | the execution method description                                                                               | "Copy"             |
| result               | Object                                                | the real computed result                                                                                       |                    |
| actionMethod         | Enum<[ActionMethod](#action-method)>                  | the execution method                                                                                           | "COPY_RESULT"      |
| actionCallback       | Object                                                | customize callback execution, set this value will ignore action method field, in general plugin, it's a string |                    |
| sortOrder            | Enum<[SortOrder](#sort-order)>                        | sort priority in callback list                                                                                 | "NONE"             |
| actionWindowBehavior | Enum<[ActionWindowBehavior](#action-window-behavior)> | how to handle action window after callback executed                                                            | "HIDE_IF_POSSIBLE" |
| showNotify           | Boolean                                               | show notify after callback executed                                                                            | true               |

### Action Method

| name                      | explanation                                                                                             |
|---------------------------|---------------------------------------------------------------------------------------------------------|
| OPEN_FILE                 | let result as a file and open it                                                                        |
| OPEN_URL                  | let result as a url and use the default browser to browse it                                            |
| COPY_RESULT               | copy the result to clipboard                                                                            |
| COPY_AND_PASTE            | copy the result and paste it                                                                            |
| COMMANDLINE               | let result as a terminal command and execute it                                                         |
| PYTHON_SCRIPT             | let result as a python script file and execute it                                                       |
| GOTO_FUNC_PAGE            | let result as a [func page](conceptual_interpretation.md#func-page) and pin it as keyword               |
| SET_TO_ACTION_TEXT        | let result as a string and set to [action input field](conceptual_interpretation.md#action-input-field) |
| POWERSHELL_SCRIPT         | let result as multi line powershell script and execute it                                               |
| POWERSHELL_SINGLE_COMMAND | let result as a single powershell command and execute it                                                |

### Sort Order

| name  | explanation          |
|-------|----------------------|
| NONE  | no effect on sorting |
| FRONT | will sort to front   |
| LAST  | will sort to last    |

### [Action Window](conceptual_interpretation.md#action-window) Behavior

| name             | explanation                  |
|------------------|------------------------------|
| FORCE_HIDE       | force hide it                |
| HIDE_IF_POSSIBLE | hide if window is not pinned |
| EMPTY_LIST       | empty the result list        |
| REFRESH_LIST     | refresh the result list      |
| NOTHING          | do nothing                   |


### Json Example

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
