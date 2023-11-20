# Action Keyword Pin

| field               | type                                                                | explanation                     |
|---------------------|---------------------------------------------------------------------|---------------------------------|
| pluginId            | String                                                              | plugin id                       |
| keyword             | String                                                              | keyword                         |
| nameBundleId        | String                                                              | name bundle id                  |
| scene               | [ActionKeywordScene](appendix/action_param.md#action-keyword-scene) | scene of current keyword        |
| actionHandlerName   | String                                                              | class name of action handler    |
| pin                 | Boolean                                                             | to pin or unpin                 |
| initSelect          | Boolean                                                             | select on initialization        |
| logo                | Object                                                              | logo path, or image, or painter |
| toolbar             | [ActionKeywordToolbar](jar-plugin-guide/toolbar.md#toolbar)         | toolbar                         |
| placeholderBundleId | String                                                              | placeholder bundle id           |
| pinId               | String                                                              | pinned id                       |