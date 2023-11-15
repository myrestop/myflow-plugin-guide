# Theme

| field            | type    | explanation                                                          |
|------------------|---------|----------------------------------------------------------------------|
| isLight          | Boolean | the theme is light, otherwise is dark                                |
| primary          | String  | selected text background                                             |
| primaryVariant   | String  | mostly used for hovered background                                   |
| secondary        | String  | mostly used for button's background                                  |
| secondaryVariant | String  | button hovered color                                                 |
| surface          | String  | mostly used for some top-level element's background, like pop dialog |
| error            | String  | error background                                                     |
| onPrimary        | String  | font color on primary                                                |
| onSecondary      | String  | font color on secondary                                              |
| onBackground     | String  | font color for default                                               |
| onSurface        | String  | font color on surface                                                |
| onError          | String  | font color on error, and we also use this color to highlight text    |

### Example Json

[theme.json](../general-plugin-guide/qlexpress-demo-plugin/theme.json ':include :type=code')