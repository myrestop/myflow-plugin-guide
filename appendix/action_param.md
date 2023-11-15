# Action Param

| field        | type                                              | explanation                              | example |
|--------------|---------------------------------------------------|------------------------------------------|---------|
| scene        | Enum<[ActionKeywordScene](#action-keyword-scene)> | what's the scene triggered the keyword   | MAIN    |
| originAction | String                                            | the origin content of user input         |         |
| keyword      | String                                            | the keyword of user input                |         |
| args         | List<[Arg](#arg)>                                 | the args that parsed from origin content |         |
| sizeLimit    | Int                                               | we suggested the result list size        | 10      |

### Arg

| field    | type                                    | explanation     | example |
|----------|-----------------------------------------|-----------------|---------|
| value    | Object                                  | the arg value   |         |
| type     | Enum<[ActionArgType](#action-arg-type)> | the value type  |         |
| strValue | String                                  | string of value |         |

### Action Keyword Scene

| name           | explanation                                            |
|----------------|--------------------------------------------------------|
| MAIN           | at main scene                                          |
| PINNED_KEYWORD | at pinned keyword                                      |
| func page      | at [func page](conceptual_interpretation.md#func-page) |

### Action Arg Type

| name   | explanation      |
|--------|------------------|
| STRING | java.lang.String |
| FILE   | java.io.File     |
| IMAGE  | java.awt.Image   |
| URL    | java.net.URL     |

### Json Example

```json
{
    "scene": "MAIN",
    "originAction": "runflow",
    "keyword": "runflow",
    "args": [
        {
            "value": "halo",
            "type": "STRING",
            "strValue": "halo"
        }
    ],
    "sizeLimit": 10
}
```
