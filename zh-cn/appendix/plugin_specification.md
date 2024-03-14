# PluginSpecification

| 字段                  | 类型                                              | 必填 | 说明                                                  | 示例                   |
|---------------------|-------------------------------------------------|----|-----------------------------------------------------|----------------------|
| id                  | String                                          | 是  | 插件Id，您可以在[这里](https://myrest.top/user/plugin)申请     | "com.example.plugin" |
| name                | String                                          | 是  | 插件英文名称，您可以在[这里](https://myrest.top/user/plugin)申请   | "Demo Plugin"        |
| entry               | String                                          | 否  | 插件入口文件，在Jar插件中，这必须是一个Jar文件                          | "plugin.jar"         |
| customizeLoader     | String                                          | 否  | 插件类型或类加载器，[了解更多](#自定义加载器)                           | "customizable"       |
| version             | String                                          | 是  | 插件版本                                                | "1.0.0"              |
| logo                | String                                          | 否  | logo，如果需上传至插件商店，那么此字段必填                             | "./logos/logo.png"   |
| homepage            | String                                          | 否  | 插件主页URL                                             |                      |
| compatibleVersion   | [CompatibleVersion](#compatibleversion)         | 是  | 兼容RunFlow的版本                                        |                      |
| owner               | [Vendor](#vendor)                               | 否  | 插件所有者，  如果需上传至插件商店，那么此字段必填                          |                      |
| contributors        | List<[Vendor](#vendor)>                         | 否  | 插件的贡献者                                              |                      |
| dependOnPlugins     | List<[DependOnPlugin](#dependonplugin)>         | 否  | 依赖的插件                                               |                      |
| cycleListener       | String                                          | 否  | 插件状态监听，当插件运行、暂停或被卸载时，我们将通知您                         |                      |
| languageBundleName  | String                                          | 否  | 绑定语言资源到JavaBean                                     |                      |
| groups              | List<[Group](#group)>                           | 否  | 关键字分组                                               |                      |
| actions             | List<[ActionKeywordProps](#actionkeywordprops)> | 否  | 插件所有的[动作](conceptual_interpretation.md#动作action)    |                      |
| actionWindows       | List<[NamedService](#namedservice)>             | 否  | 提供工作窗口，仅Jar插件可用                                     |                      |
| placeholderUpdaters | List<[PlaceholderUpdater](#placeholderupdater)> | 否  | 更新占位符                                               |                      |
| themes              | List<[NamedService](#namedservice)>             | 否  | 提供主题                                                |                      |
| httpModules         | List\<String\>                                  | 否  | 通过[ktor](https://ktor.io/docs/welcome.html)启用HTTP服务 |                      |
| translator          | [NamedService](#namedservice)                   | 否  | 提供语言翻译功能，仅Jar插件可用                                   |                      |
| dataEncryptors      | List\<String\>                                  | 否  | 提供数据加密器，仅Jar插件可用                                    |                      |
| dataSyncServices    | List<[NamedService](#namedservice)>             | 否  | 提供数据同步服务，仅Jar插件可用                                   |                      |

| 字段                             | 类型                                                               | 必填 | 说明                      | 示例               |
|--------------------------------|------------------------------------------------------------------|----|-------------------------|------------------|
| names                          | Map<Enum<[LanguageType](appendix/language_code.md#语言编码)>,String> | 否  | 其他语言下的插件名称              | ZH_CN: "示例插件"    |
| categories                     | List<Enum<[Category](#category)>>                                | 否  | 插件分类，如果需上传至插件商店，那么此字段必填 | - "PRODUCTIVITY" |
| platforms                      | List<Enum<[PlatformType](#platformtype)>>                        | 否  | 插件支持的操作系统，默认支持所有操作系统    |                  |
| actionResultCallbackExtensions | List<[NamedService](#namedservice)>                              | 否  | 扩展结果回调                  |                  |

### CompatibleVersion

**如果您开发的是Jar插件，并调用了我们提供给您的一些API，那么这种情况您可能需要设置兼容的版本，您可以在我们打印的日志中看到兼容的版本号。**

| 字段         | 类型  | 必填 | 说明       | 示例         |
|------------|-----|----|----------|------------|
| sinceBuild | Int | 是  | 兼容的最小构建号 | 0          |
| untilBuild | Int | 是  | 兼容的最大构建号 | 2147483647 |


### Vendor

| 字段       | 类型     | 必填 | 说明   | 示例                    |
|----------|--------|----|------|-----------------------|
| name     | String | 是  | 用户名  | "MyRest"              |
| email    | String | 否  | 电子邮箱 |                       |
| homepage | String | 否  | 个人主页 | "https://example.com" |

### DependOnPlugin

| 字段       | 类型      | 必填 | 说明   | 示例                   |
|----------|---------|----|------|----------------------|
| id       | String  | 是  | 插件ID | "com.example.plugin" |
| optional | Boolean | 否  | 是否可选 | true                 |

### Group

| 字段           | 类型     | 必填 | 说明        | 示例 |
|--------------|--------|----|-----------|----|
| id           | String | 是  | 分组Id      |    |
| nameBundleId | String | 是  | 名称的资源绑定ID |    |

### ActionKeywordProps

| 字段                   | 类型                                        | 必填 | 说明                 | 示例                 |
|----------------------|-------------------------------------------|----|--------------------|--------------------|
| pinName              | String                                    | 否  | 固定的名称              |                    |
| nameBundleId         | String                                    | 否  | 名称的资源绑定ID，我们建议设置此值 |                    |
| logo                 | String                                    | 否  | logo路径             | "./logos/logo.png" |
| placeholderBundleId  | String                                    | 否  | 占位符的资源绑定ID         |                    |
| groupId              | String                                    | 否  | 分组，查看[分组](#group)  |                    |
| toolbar              | String                                    | 否  | 工具栏，仅Jar插件可用       |                    |
| descriptionBundleId  | String                                    | 否  | 描述的资源绑定ID          |                    |
| unsupportedPlatforms | List<Enum<[PlatformType](#platformtype)>> | 否  | 不支持的操作系统           |                    |
| keywords             | List\<String\>                            | 是  | 关键字                | - "keyword"        |
| handler              | String                                    | 是  | 处理器                |                    |

### NamedService

| 字段           | 类型     | 必填 | 说明     | 示例 |
|--------------|--------|----|--------|----|
| service      | String | 是  | 类名     |    |
| nameBundleId | String | 是  | 资源绑定ID |    |

### PlaceholderUpdater

| 字段          | 类型     | 必填 | 说明    | 示例 |
|-------------|--------|----|-------|----|
| updater     | String | 是  | 更新占位符 |    |
| previewText | String | 是  | 预览文本  |    |

### 自定义加载器

**如果您设置的不是下面的值，那么我们将用这个值作为您自定义类加载器的名称。**

| 特殊值         | 说明                                                       |
|-------------|----------------------------------------------------------|
| default     | 默认的类加载器                                                  |
| isolate     | 隔离的类加载器                                                  |
| commandline | 作为终端命令的通用插件                                              |
| http        | 作为HTTP类型的通用插件，我们将POST方法请求您                               |
| python      | 作为Python脚本的通用插件                                          |
| qlexpress   | 作为[qlexpress](https://github.com/alibaba/QLExpress)的通用插件 |

### Category

| 名称            | 说明   |
|---------------|------|
| THEME         | 主题   |
| PRODUCTIVITY  | 效率   |
| LANGUAGE      | 自然语言 |
| DEVELOP_TOOL  | 开发工具 |
| MEDIA         | 媒体   |
| SECURITY      | 安全   |
| SEARCHING     | 搜索   |
| GAME          | 游戏   |
| NEWS          | 新闻   |
| ENTERTAINMENT | 娱乐   |
| ACTION_WINDOW | 工作窗口 |
| OTHERS        | 其他   |

## PlatformType

| 名称      | 说明        |
|---------|-----------|
| WINDOWS | Windows系统 |
| MACOS   | MacOS系统   |
| LINUX   | Linux系统   |

### Yaml示例

```yaml
id: com.example.plugin
name: Demo Plugin
names:
  ZH_CN: 示例插件
entry: ./plugin.jar
customize-loader: default
version: 1.0.0
logo: ./logos/logo.png
homepage: https://example.com
compatible-version:
  since-build: 1
  until-build: 392
owner:
  name: example
  email: service@example.com
  homepage: https://example.com
depend-on-plugins:
  - id: com.example.plugin.kk
    optional: true
cycle-listener: com.example.plugin.CycleListener
language-bundle-name: com.example.plugin.LanguageBundle
categories:
  - PRODUCTIVITY
platforms:
  - WINDOWS
  - MACOS
  - LINUX
groups:
  - id: general
    name-bundle-id: app-name
actions:
  - pin-name: PinName
    name-bundle-id: app-name
    logo: ./logos/logo.png
    placeholder-bundle-id: app-name
    group-id: general
    toolbar: com.example.plugin.Toolbar
    description-bundle-id: app-name
    keywords:
      - key1
      - key2
    handler: com.example.plugin.Handler
action-windows:
  - service: com.example.plugin.ActionWindow
    name-bundle-id: app-name
placeholder-updaters:
  - updater: com.example.plugin.PlaceholderUpdater
    preview-text: placeholder
themes:
  - service: com.example.plugin.ThemeProvider
    name-bundle-id: app-name
http-modules:
  - com.example.plugin.HttpService.httpModule
translator:
  service: com.example.plugin.Translator
  name-bundle-id: app-name
data-encryptors:
  - com.example.plugin.DataEncryptor
data-sync-services:
  - service: com.example.plugin.DataSyncService
    name-bundle-id: app-name
action-result-callback-extensions:
  - service: com.example.plugin.CallbackExtension
    name-bundle-id: app-name
```