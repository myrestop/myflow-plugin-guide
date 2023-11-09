# Action Result Fields Explanation

**All these fields are optional at listed below.**

### Action Result

| field            | type                                                                                                       | explanation                                                                                                                | example            |
|------------------|------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------|--------------------|
| actionId         | String                                                                                                     | the result id, it impacts the result's weight                                                                              | "id"               |
| score            | Int                                                                                                        | the result score, it has an effect on sorting                                                                              | 90                 |
| logo             | Object                                                                                                     | in general plugin, this field type should be string, that means the logo path, in jar plugin, that can be image or painter | "./logos/logo.png" |
| title            | [ActionResultTitle](#action-result-title)                                                                  | the result title                                                                                                           |                    |
| subtitle         | String                                                                                                     | the result subtitle                                                                                                        | "subtitle"         |
| result           | Object                                                                                                     | the real computed result                                                                                                   | null               |
| callbacks        | List<[ActionResultCallback](appendix/action_result_callback.md#action-result-callback-fields-explanation)> | the result execution method                                                                                                |                    |
| content          | @Composable                                                                                                | customize render the action's ui, only jar plugin can do this                                                              |                    |
| contentHeight    | int                                                                                                        | the customize ui height, set -1 to avoid our height limitation                                                             |                    |
| executedCallback | Object                                                                                                     | in general plugin, this is a string type, we call this after callback executed                                             |                    |

### Action Result Title

| field | type                                        | explanation                                                            | example       |
|-------|---------------------------------------------|------------------------------------------------------------------------|---------------|
| value | String                                      | the title value                                                        | "Title"       |
| type  | Enum<[ActionTitleType](#action-title-type)> | the title type                                                         | "PLAIN_TITLE" |

### Action Title Type

| name            | explanation    |
|-----------------|----------------|
| HIGHLIGHT_TITLE | highlight text |
| PLAIN_TITLE     | plain text     |
| SUBTITLE        | subscript text |

### Full Example JSON

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
