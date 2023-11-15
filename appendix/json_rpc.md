# The Request Parameter Common Fields

| field    | type                                                          | explanation                                                                            |
|----------|---------------------------------------------------------------|----------------------------------------------------------------------------------------|
| language | Enum<[LanguageType](appendix/language_code.md#language-code)> | represents the language user currently using                                           |
| method   | Enum<[JsonRpcMethod](#json-rpc-method)>                       | represents the request method                                                          |
| openId   | String                                                        | represents the user unique id we computed, you can use this field to identify the user |
| body     | Object                                                        | represents the request content which depends on request method                         |

### Json Rpc Method

| name                | explanation                                                  |
|---------------------|--------------------------------------------------------------|
| HOT_EVENT           | trigger on hot event                                         |
| QUERY_ACTION        | action result query                                          |
| ACTION_CALLBACK     | action callback                                              |
| EXECUTED_CALLBACK   | callback executed                                            |
| PROVIDE_THEME       | request to provide theme                                     |
| PLACEHOLDER         | request to update placeholder                                |
| BEFORE_PLUGIN_LOAD  | prepare to load plugin, only in cycle listener               |
| AFTER_PLUGIN_LOADED | after plugin loaded, only in cycle listener                  |
| ON_PLUGIN_STOP      | user stopped the plugin, only in cycle listener              |
| ON_PLUGIN_DISABLE   | user disabled the plugin, only in cycle listener             |
| ON_PLUGIN_UNINSTALL | user prepare to uninstall the plugin, only in cycle listener |
| ON_PLUGIN_RUN       | plugin started, only in cycle listener                       |
| BEFORE_APP_EXIT     | before app exit, only in cycle listener                      |

### Json Example

```json
{
    "language": "EN_US",
    "method": "BEFORE_APP_EXIT",
    "openId": "abc",
    "body": null
}
```
