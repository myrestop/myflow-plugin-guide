# Plugin Specification

| field               | type                                              | required | explanation                                                                         | example              |
|---------------------|---------------------------------------------------|----------|-------------------------------------------------------------------------------------|----------------------|
| id                  | String                                            | yes      | the plugin id, you can apply it [here](https://myrest.top/user/plugin)              | "com.example.plugin" |
| name                | String                                            | yes      | the plugin's english name, you can apply it [here](https://myrest.top/user/plugin)  | "Demo Plugin"        |
| entry               | String                                            | no       | plugin main entry file, in jar plugin, this is a required jar file                  | "plugin.jar"         |
| customizeLoader     | String                                            | no       | how to load the plugin, or the class loader of jar, [learn more](#customize-loader) | "customizable"       |
| version             | String                                            | yes      | the plugin version                                                                  | "1.0.0"              |
| logo                | String                                            | no       | logo file path, required if you want upload to plugin store                         | "./logos/logo.png"   |
| homepage            | String                                            | no       | plugin homepage url                                                                 |                      |
| compatibleVersion   | [CompatibleVersion](#compatible-version)          | yes      | compatible RunFlow version                                                          |                      |
| owner               | [Vendor](#vendor)                                 | no       | owner of this plugin, required if you want upload to plugin store                   |                      |
| contributors        | List<[Vendor](#vendor)>                           | no       | contributor of this plugin                                                          |                      |
| dependOnPlugins     | List<[DependOnPlugin](#depend-on-plugin)>         | no       | plugin depends                                                                      |                      |
| cycleListener       | String                                            | no       | when plugin is loaded, or started, or stopped, or uninstalled, we'll call you       |                      |
| languageBundleName  | String                                            | no       | bundle language to java class, only available for jar plugin                        |                      |
| groups              | List<[Group](#group)>                             | no       | grouping                                                                            |                      |
| actions             | List<[ActionKeywordProps](#action-keyword-props)> | no       | all of your [actions](conceptual_interpretation.md#action)                          |                      |
| actionWindows       | List<[NamedService](#named-service)>              | no       | provide action window, only jar plugin available                                    |                      |
| placeholderUpdaters | List<[PlaceholderUpdater](#placeholder-updater)>  | no       | update the placeholder of action input field                                        |                      |
| themes              | List<[NamedService](#named-service)>              | no       | provide theme                                                                       |                      |
| httpModules         | List\<String\>                                    | no       | run http service use [ktor](https://ktor.io/docs/welcome.html)                      |                      |
| translator          | [NamedService](#named-service)                    | no       | provide a language translator, only jar plugin available                            |                      |
| dataEncryptors      | List\<String\>                                    | no       | data encryptor, only jar plugin available                                           |                      |
| dataSyncServices    | List<[NamedService](#named-service)>              | no       | provide data sync service, only jar plugin available                                |                      |

| field                          | type                                                                      | required | explanation                                                    | example          |
|--------------------------------|---------------------------------------------------------------------------|----------|----------------------------------------------------------------|------------------|
| names                          | Map<Enum<[LanguageType](appendix/language_code.md#language-code)>,String> | no       | plugin name in other language                                  | ZH_CN: "示例插件"    |
| categories                     | List<Enum<[Category](#category)>>                                         | no       | required if you want upload to plugin store                    | - "PRODUCTIVITY" |
| platforms                      | List<Enum<[PlatformType](#platform-type)>>                                | no       | your plugin supported platforms, default support all platforms |                  |
| actionResultCallbackExtensions | List<[NamedService](#named-service)>                                      | no       | extends action result callbacks                                |                  |

### Compatible Version

**If you develop with jar plugin, and you called some APIs we provided to you, in this situation, you mostly need to set compatible version, you can see the compatible build number in our printed log.**

| field      | type | required | explanation                     | example    |
|------------|------|----------|---------------------------------|------------|
| sinceBuild | Int  | yes      | minimum compatible build number | 0          |
| untilBuild | Int  | yes      | maximum compatible build number | 2147483647 |


### Vendor

| field    | type   | required | explanation   | example               |
|----------|--------|----------|---------------|-----------------------|
| name     | String | yes      | user name     | "MyRest"              |
| email    | String | no       | user email    |                       |
| homepage | String | no       | user homepage | "https://example.com" |

### Depend On Plugin

| field    | type    | required | explanation                                    | example              |
|----------|---------|----------|------------------------------------------------|----------------------|
| id       | String  | yes      | plugin id                                      | "com.example.plugin" |
| optional | Boolean | no       | the depends plugin is required                 | true                 |

### Group

| field        | type   | required | explanation            | example |
|--------------|--------|----------|------------------------|---------|
| id           | String | yes      | group id               |         |
| nameBundleId | String | yes      | the language bundle id |         |

### Action Keyword Props

| field                | type                                       | required | explanation                                                                                     | example            |
|----------------------|--------------------------------------------|----------|-------------------------------------------------------------------------------------------------|--------------------|
| pinName              | String                                     | no       | if the action support pin, you need set a pin name                                              |                    |
| nameBundleId         | String                                     | no       | the language bundle id, we suggest you set this value                                           |                    |
| logo                 | String                                     | no       | logo file path                                                                                  | "./logos/logo.png" |
| placeholderBundleId  | String                                     | no       | the language bundle id, the value will as a placeholder show in action input field after pinned |                    |
| groupId              | String                                     | no       | grouping action, see [group](#group)                                                            |                    |
| toolbar              | String                                     | no       | the toolbar class name, only in jar plugin                                                      |                    |
| descriptionBundleId  | String                                     | no       | the language bundle id                                                                          |                    |
| unsupportedPlatforms | List<Enum<[PlatformType](#platform-type)>> | no       | the action unsupported platforms                                                                |                    |
| keywords             | List\<String\>                             | yes      | keywords of the action                                                                          | - "keyword"        |
| handler              | String                                     | yes      | handler of the action                                                                           |                    |

### Named Service

| field        | type   | required | explanation        | example |
|--------------|--------|----------|--------------------|---------|
| service      | String | yes      | a service          |         |
| nameBundleId | String | yes      | language bundle id |         |

### Placeholder Updater

| field       | type   | required | explanation           | example |
|-------------|--------|----------|-----------------------|---------|
| updater     | String | yes      | a placeholder updater |         |
| previewText | String | yes      | preview text          |         |

### Customize Loader

**If you set the value other than the following, we will use this value to create a class loader you customized.**

| special value | explanation                                                                                    |
|---------------|------------------------------------------------------------------------------------------------|
| default       | use default class loader to load jar                                                           |
| isolate       | load jar using an isolated class loader                                                        |
| commandline   | as a general plugin, interactive using command                                                 |
| http          | as a general plugin, interactive using http post request                                       |
| python        | as a general plugin, interactive using python                                                  |
| qlexpress     | as a general plugin, interactive using [qlexpress](https://github.com/alibaba/QLExpress)       |

### Category

| name          | explanation                             |
|---------------|-----------------------------------------|
| THEME         | provided theme                          |
| PRODUCTIVITY  | some functions about productivity       |
| LANGUAGE      | some functions about spoken language    |
| DEVELOP_TOOL  | some functions about program developing |
| MEDIA         | some functions about media              |
| SECURITY      | some functions about security           |
| SEARCHING     | some functions about data retrieval     |
| GAME          | game                                    |
| NEWS          | news                                    |
| ENTERTAINMENT | some functions about entertainment      |
| ACTION_WINDOW | provided action window                  |
| OTHERS        | any others                              |

## Platform Type

| name    | explanation          |
|---------|----------------------|
| WINDOWS | the windows platform |
| MACOS   | the macos platform   |
| LINUX   | ths linux platform   |

### Yaml Example

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
  since-build: 0
  until-build: 2147483647
owner:
  name: example
  email: service@example.com
  homepage: https://example.com
dependOnPlugins:
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
