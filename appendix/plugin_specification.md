# Plugin Specification

| field           | type                                                                      | required | explanation                                                                         | example              |
|-----------------|---------------------------------------------------------------------------|----------|-------------------------------------------------------------------------------------|----------------------|
| id              | String                                                                    | yes      | the plugin id, you can apply it [here](https://myrest.top/user/plugins)             | "com.example.plugin" |
| name            | String                                                                    | yes      | the plugin's english name, you can apply it [here](https://myrest.top/user/plugins) | "Demo Plugin"        |
| names           | Map<Enum<[LanguageType](appendix/language_code.md#language-code)>,String> | no       | plugin name in other language                                                       | ZH_CN: "示例插件"        |
| entry           | String                                                                    | no       | plugin main entry file, in jar plugin, this is a required jar file                  | "plugin.jar"         |
| customizeLoader | String                                                                    | no       | how to load the plugin, or the class loader of jar, [learn more](#customize-loader) | "customizable"       |
| version         | String                                                                    | yes      | the plugin version                                                                  | "1.0.0"              |

### Customize Loader

| special value | explanation                                                                                    |
|---------------|------------------------------------------------------------------------------------------------|
| default       | use default class loader to load jar                                                           |
| isolate       | load jar using an isolated class loader                                                        |
| commandline   | as a general plugin, interacting with commandline                                              |
| http          | as a general plugin, interacting with http post request                                        |
| python        | as a general plugin, interacting with python command                                           |
| qlexpress     | as a general plugin, interacting with [qlexpress](https://github.com/alibaba/QLExpress) script |
