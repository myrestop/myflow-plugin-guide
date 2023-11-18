# Utilities

All the utility classes, methods and fields you can find in here.

## Base Classes

- `data class top.myrest.myflow.action.ActionFocusedData` includes some info for focused mode.

- `abstract class top.myrest.myflow.action.ActionKeywordResultWrapper<T>` can wrap the result.

- `open class top.myrest.myflow.action.ActionKeywordSuggestionResult<T> : top.myrest.myflow.action.ActionKeywordResultWrapper<T>` can include result and suggest text.

## Methods & Fields

### top.myrest.myflow.AppInfo

| signature                                                                                  | explanation                               |
|--------------------------------------------------------------------------------------------|-------------------------------------------|
| val startAt: Long                                                                          | app start time                            |
| const val APP_NAME: String                                                                 | app name                                  |
| const val LOGO: String                                                                     | app logo path                             |
| const val BUILTIN_PLUGIN_ID: String                                                        | builtin plugin id                         |
| val appDir: String                                                                         | directory of app data storing             |
| val tempDir: String                                                                        | directory of temporary file               |
| val configurationFile: File                                                                | app configuration file                    |
| val currPid: Int                                                                           | app pid                                   |
| val runtimeProps: ConfigProps                                                              | configuration properties at runtime       |
| val actionWindow: ActionWindow                                                             | a compose dialog                          |
| var themeColors: Colors                                                                    | current theme colors                      |
| fun provideActionWindows(actionWindows: List\<PluginSpecification.NamedService\>): Boolean | provide action window                     |
| fun listActionWindowProvider(): List\<PluginSpecification.NamedService\>                   | list action windows                       |
| val mainToolbars: AtomicReference\<List\<ActionKeywordToolbar\>\>                          | toolbars which support main scene         |
| val actionWindowLoader: ClassLoader                                                        | the class loader of current action window |
| val warningColor: Color                                                                    | the color of warning                      |
| val successColor: Color                                                                    | the color of success                      |
| var typography: Typography                                                                 | typography of material theme              |

### top.myrest.myflow.action.ActionCallbackExtensions

| signature                                                                                                  | explanation                 |
|------------------------------------------------------------------------------------------------------------|-----------------------------|
| fun register(pluginId: String, extension: ActionResultCallbackExtension)                                   | register callback extension |
| fun remove(extension: ActionResultCallbackExtension)                                                       | remove extension            |
| fun getExtendedCallbacks(result: Any?, excludes: Set\<String\> = emptySet()): List\<ActionResultCallback\> | get extensions              |

### top.myrest.myflow.action.Actions

| signature                                                                                                          | explanation              |
|--------------------------------------------------------------------------------------------------------------------|--------------------------|
| fun getFocusedData(pinId: String?): ActionFocusedData?                                                             | get data of focused mode |
| fun closeFocusedData(pinId: String?)                                                                               | exit focused mode        |
| fun closeFocusedSession(handlerName: String)                                                                       | exit focused mode        |
| fun setFocusedData(pin: ActionKeywordPin, pluginId: String, keyword: String, handler: ActionFocusedKeywordHandler) | enter focused mode       |
| fun register(keyword: String, handler: ActionKeywordHandler, pluginId: String = AppInfo.BUILTIN_PLUGIN_ID)         | register an action       |
| fun remove(keyword: String, handler: ActionKeywordHandler)                                                         | remove action            |
| fun getKeywords(): List\<String\>                                                                                  | get all keywords         |
| fun getSpecialKeywords(): Set\<String\>                                                                            | get all special keywords |
| fun getHandlers(keyword: String): List\<PluginActionKeywordHandler\>                                               | get handlers             |
| fun allHandlers(): List\<PluginActionKeywordHandler\>                                                              | get all handlers         |
| fun isSpecialKeyword(keyword: String): Boolean                                                                     | check keyword is special |
| fun isKeywordValid(keyword: String): Boolean                                                                       | check keyword is valid   |

### top.myrest.myflow.action.ActionKeywordsKt

| signature                                                                                                    | explanation                                 |
|--------------------------------------------------------------------------------------------------------------|---------------------------------------------|
| fun String.asSuggestionResult(): ActionKeywordSuggestionResult\<String\>                                     | make the string result as suggestion result |
| fun \<T\> T.asSuggestionResult(suggestion: String): ActionKeywordSuggestionResult\<T\>                       | as suggestion result                        |
| fun basicCopyResult(actionId: String, logo: Any? = null, score: Int = 60, result: Any? = null): ActionResult | a copy action result                        |
| val String.highlight: ActionResultTitle                                                                      | highlight title                             |
| val String.plain: ActionResultTitle                                                                          | pain title                                  |
| val String.subtitle: ActionResultTitle                                                                       | subscript title                             |
| val separateByBundledLanguage: ActionResultTitle                                                             | word separator                              |


