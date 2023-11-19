# Utilities

Most of the useful utility classes, methods and fields you can find in here.

## Base Classes

- `data class top.myrest.myflow.action.ActionFocusedData` includes some info for focused mode.

- `abstract class top.myrest.myflow.action.ActionKeywordResultWrapper<T>` can wrap the result.

- `open class top.myrest.myflow.action.ActionKeywordSuggestionResult<T> : top.myrest.myflow.action.ActionKeywordResultWrapper<T>` can include result and suggest text.

- `top.myrest.myflow.db.KeyValueRepo`, you can store some key value to this document.

- `top.myrest.myflow.event.ShouldCaptureScreenShotEvent`, emit this event to notify us to capture screen.

- `top.myrest.myflow.event.ShouldOpenImageEditorEvent`, emit this event to open system image editor.

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

### top.myrest.myflow.action.ActionPlaceholderUpdater

| signature                                                  | explanation                 |
|------------------------------------------------------------|-----------------------------|
| fun getCurrentUpdater(): ActionPlaceholderUpdater?         | current placeholder updater |
| fun restoreCounts()                                        | restore placeholder counts  |
| fun getUpdater(updater: String): ActionPlaceholderUpdater? | get placeholder updater     |
| fun cache(updater: ActionPlaceholderUpdater)               | cache placeholder           |

### top.myrest.myflow.action.ActionTitles

| signature                                                                                                                                  | explanation         |
|--------------------------------------------------------------------------------------------------------------------------------------------|---------------------|
| fun omitExceed(titles: MutableList\<ActionResultTitle\>,maxWidth: Int = AppInfo.actionWindow.width / 15): MutableList\<ActionResultTitle\> | omit exceeded title |

### top.myrest.myflow.component.Composes

| signature                                                                                                           | explanation                                                                 |
|---------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------|
| var actionWindowProvider: ActionWindowProvider?                                                                     | current action window provider                                              |
| var apis: AppApis?                                                                                                  | app apis                                                                    |
| val mainPin: ActionKeywordPin                                                                                       | the main pin, can't unpin                                                   |
| fun emitActionTextChangedEvent(pin: ActionKeywordPin, action: String? = null)                                       | send action changed event                                                   |
| fun \<T : Any\> cacheByCurrentLanguage(calculator: () -> T): T                                                      | cache state                                                                 |
| fun Dp.roundToPx(): Int                                                                                             | dp to px                                                                    |
| fun Number.roundToDp(): Dp                                                                                          | px to dp                                                                    |
| fun \<T : Any\> FuncPageScope.remember4FuncPage(key: String = "", calculation: @DisallowComposableCalls () -> T): T | cache for func page                                                         |
| fun \<T : Any\> remember(pinId: String, key: String = "", calculation: @DisallowComposableCalls () -> T): T         | cache state                                                                 |
| fun \<T : Any\> cacheState(pinId: String, key: String = "", calculation: () -> T): T                                | cache state                                                                 |
| fun removeStateCache(pinId: String?)                                                                                | remove state cache                                                          |
| fun resolveLogo(pluginId: String, handlerName: String?, logo: Any?): Pair\<Any?, Boolean\>                          | resolve action logo, return a pair that include logo and boolean (resolved) |
| fun getPainter(src: Any?): Painter?                                                                                 | to compose painter                                                          |

### top.myrest.myflow.data.DataSyncServices

| signature                                      | explanation       |
|------------------------------------------------|-------------------|
| fun getService(name: String): DataSyncService? | get sync service  |
| fun stopService(name: String)                  | stop sync service |
| fun stopService(service: DataSyncService)      | stop sync service |

### top.myrest.myflow.db.MyDb

| signature                  | explanation               |
|----------------------------|---------------------------|
| fun exportTo(file: File)   | export database to file   |
| fun importFrom(file: File) | import database from file |

### top.myrest.myflow.event.CombinedEvents

| signature                                                                                                                  | explanation                 |
|----------------------------------------------------------------------------------------------------------------------------|-----------------------------|
| fun addCombinedListener(combinedEvents: Set\<Class\<out AppEvent\>\>, listener: CombinedEventListener)                     | add combined event listener |
| fun removeCombinedListener(combinedEvents: Set\<Class\<out AppEvent\>\>, listener: CombinedEventListener)                  | remove listener             |
| fun removeCombinedListener(tolerance: Long, combinedEvents: Set\<Class\<out AppEvent\>\>, listener: CombinedEventListener) | remove listener             |

### top.myrest.myflow.event.EventBus

| signature                                                                                                                        | explanation           |
|----------------------------------------------------------------------------------------------------------------------------------|-----------------------|
| fun \<T : AppEvent\> Class\<T\>.addSimpleListener(priority: Int = 100, handler: () -> Unit): BaseEventListener\<T\>              | add event listener    |
| fun \<T : AppEvent\> Class\<T\>.addListener(priority: Int = 100, handler: (EventExtraDetail, T) -> Unit): BaseEventListener\<T\> | add event listener    |
| fun \<T : AppEvent\> Class\<T\>.addListener(handler: EventListener\<T\>)                                                         | add event listener    |
| fun \<T : AppEvent\> Class\<T\>.removeListener(handler: EventListener\<T\>)                                                      | remove event listener |
| fun \<T : AppEvent\> Class\<T\>.removeEvent(): Set\<EventListener\<out AppEvent\>\>                                              | remove event listener |
| fun \<T : AppEvent\> T.emit(): Future\<Unit\>                                                                                    | emit event            |

### top.myrest.myflow.util.AsyncTasks

| signature                                          | explanation        |
|----------------------------------------------------|--------------------|
| fun execute(task: Runnable)                        | execute async task |
| fun \<T\> submit(task: Callable\<T\>): Future\<T\> | execute async task |

### top.myrest.myflow.util.Jackson

| signature                                                    | explanation |
|--------------------------------------------------------------|-------------|
| val jsonMapper: ObjectMapper                                 |             |
| val yamlMapper: ObjectMapper                                 |             |
| inline fun \<reified T\> String.readByYaml(): T              |             |
| fun Any.toYamlString(): String                               |             |
| inline fun \<reified T\> String.readByJson(): T              |             |
| inline fun \<reified T\> String.readByJsonArray(): List\<T\> |             |
| fun Any.toJsonString(pretty: Boolean = false): String        |             |

### top.myrest.myflow.util.SearchingSyntax

| signature                                                                                        | explanation     |
|--------------------------------------------------------------------------------------------------|-----------------|
| fun highlightTitle(keyword: String, title: String): SearchingHighlightTitle                      | highlight title |
| fun fuzzyKeyword(keyword: String, fuzzyStart: Boolean = false, fuzzyEnd: Boolean = true): String | fuzzy keyword   |
