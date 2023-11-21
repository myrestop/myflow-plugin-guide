# ActionKeywordPin

| 字段                  | 类型                                                                | 说明                     |
|---------------------|-------------------------------------------------------------------|------------------------|
| pluginId            | String                                                            | 插件ID                   |
| keyword             | String                                                            | 关键字                    |
| nameBundleId        | String                                                            | 名称的资源绑定ID              |
| scene               | [ActionKeywordScene](appendix/action_param.md#actionkeywordscene) | 当前关键字的场景               |
| actionHandlerName   | String                                                            | 处理器的类名                 |
| pin                 | Boolean                                                           | 固定，或取消固定               |
| initSelect          | Boolean                                                           | 初次固定是否选中               |
| logo                | Object                                                            | logo路径，或image，或painter |
| toolbar             | [ActionKeywordToolbar](jar-plugin-guide/toolbar.md#toolbar)       | 工具栏                    |
| placeholderBundleId | String                                                            | 占位符的资源绑定ID             |
| pinId               | String                                                            | 固定的ID                  |