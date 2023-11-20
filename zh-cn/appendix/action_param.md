# ActionParam

| 字段           | 类型                                              | 说明        | 示例   |
|--------------|-------------------------------------------------|-----------|------|
| scene        | Enum<[ActionKeywordScene](#actionkeywordscene)> | 关键字触发的场景  | MAIN |
| originAction | String                                          | 用户原始的输入内容 |      |
| keyword      | String                                          | 用户输入的关键字  |      |
| args         | List<[Arg](#arg)>                               | 用户输入的参数   |      |
| sizeLimit    | Int                                             | 我们建议的限制数量 | 10   |

### Arg

| 字段       | 类型                                    | 说明   | 示例 |
|----------|---------------------------------------|------|----|
| value    | Object                                | 原始值  |    |
| type     | Enum<[ActionArgType](#actionargtype)> | 值的类型 |    |
| strValue | String                                | 字符串值 |    |

### ActionKeywordScene

| 名称             | 说明                                      |
|----------------|-----------------------------------------|
| MAIN           | 主场景                                     |
| PINNED_KEYWORD | 固定的关键字                                  |
| FUNC_PAGE      | [工作页](conceptual_interpretation.md#工作页) |

### ActionArgType

| 名称     | 说明               |
|--------|------------------|
| STRING | java.lang.String |
| FILE   | java.io.File     |
| IMAGE  | java.awt.Image   |
| URL    | java.net.URL     |

### Json示例

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
