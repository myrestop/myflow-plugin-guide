# JsonRPC请求的公共字段

| 字段       | 类型                                                   | 说明                          |
|----------|------------------------------------------------------|-----------------------------|
| language | Enum<[LanguageType](appendix/language_code.md#语言编码)> | 当前使用的语言                     |
| method   | Enum<[JsonRpcMethod](#jsonrpcmethod)>                | 请求执行方法                      |
| openId   | String                                               | 我们计算的一个用户唯一ID，您可以用这个ID来标识用户 |
| body     | Object                                               | 请求的正文                       |

### JsonRpcMethod

| 名称                  | 说明                       |
|---------------------|--------------------------|
| HOT_EVENT           | 热点事件                     |
| QUERY_ACTION        | 请求动作                     |
| ACTION_CALLBACK     | 动作执行回调                   |
| EXECUTED_CALLBACK   | 回调被执行通知                  |
| PROVIDE_THEME       | 提供主题                     |
| PLACEHOLDER         | 更新占位符                    |
| BEFORE_PLUGIN_LOAD  | 准备加载插件，仅CycleListener可用  |
| AFTER_PLUGIN_LOADED | 插件被加载之后，仅CycleListener可用 |
| ON_PLUGIN_STOP      | 插件被停止运行，仅CycleListener可用 |
| ON_PLUGIN_DISABLE   | 插件被禁用，仅CycleListener可用   |
| ON_PLUGIN_UNINSTALL | 插件被卸载，仅CycleListener可用   |
| ON_PLUGIN_RUN       | 运行插件，仅CycleListener可用    |
| BEFORE_APP_EXIT     | 准备退出应用，仅CycleListener可用  |

### Json示例

```json
{
    "language": "EN_US",
    "method": "BEFORE_APP_EXIT",
    "openId": "abc",
    "body": null
}
```
