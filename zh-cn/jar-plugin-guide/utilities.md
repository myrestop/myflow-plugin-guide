# 实用工具

大部分常用的工具类、方法、属性都在这里。

## 基类

- `data class top.myrest.myflow.action.ActionFocusedData`包括了专注模式的一些信息。

- `abstract class top.myrest.myflow.action.ActionKeywordResultWrapper<T>`可以用来包装真实的运算结果。

- `open class top.myrest.myflow.action.ActionKeywordSuggestionResult<T> : top.myrest.myflow.action.ActionKeywordResultWrapper<T>`包括真实的运算结果和建议文本。

- `top.myrest.myflow.db.KeyValueRepo`您可以在这里存储键值对。

- `top.myrest.myflow.event.ShouldCaptureScreenShotEvent`发送此事件通知我们截屏。

- `top.myrest.myflow.event.ShouldOpenImageEditorEvent`发送此事件通知我们打开图片编辑器。

## 方法和属性

### top.myrest.myflow.AppInfo

| 签名                                                                                         | 说明              |
|--------------------------------------------------------------------------------------------|-----------------|
| val startAt: Long                                                                          | 程序启动时间          |
| const val APP_NAME: String                                                                 | 程序名称            |
| const val LOGO: String                                                                     | logo路径          |
| const val BUILTIN_PLUGIN_ID: String                                                        | 内置插件的ID         |
| val appDir: String                                                                         | 应用使用的数据存储目录     |
| val tempDir: String                                                                        | 临时文件的存储目录       |
| val configurationFile: File                                                                | 配置文件            |
| val currPid: Int                                                                           | 当前进程PID         |
| val runtimeProps: ConfigProps                                                              | 运行时的程序配置        |
| val actionWindow: ActionWindow                                                             | 一个ComposeDialog |
| var themeColors: Colors                                                                    | 当前的主题配色         |
| fun provideActionWindows(actionWindows: List\<PluginSpecification.NamedService\>): Boolean | 工作窗口            |
| fun listActionWindowProvider(): List\<PluginSpecification.NamedService\>                   | 获取所有的工作窗口       |
| val mainToolbars: AtomicReference\<List\<ActionKeywordToolbar\>\>                          | 可以在Main场景驻扎的工具栏 |
| val actionWindowLoader: ClassLoader                                                        | 当前工作窗口的类加载器     |
| val warningColor: Color                                                                    | 警告类的字体颜色        |
| val successColor: Color                                                                    | 成功类的字体颜色        |
| var typography: Typography                                                                 | 字体              |

### top.myrest.myflow.action.ActionCallbackExtensions

| 签名                                                                                                         | 说明     |
|------------------------------------------------------------------------------------------------------------|--------|
| fun register(pluginId: String, extension: ActionResultCallbackExtension)                                   | 注册回调扩展 |
| fun remove(extension: ActionResultCallbackExtension)                                                       | 删除扩展   |
| fun getExtendedCallbacks(result: Any?, excludes: Set\<String\> = emptySet()): List\<ActionResultCallback\> | 获取扩展   |

### top.myrest.myflow.action.Actions

| 签名                                                                                                                 | 说明         |
|--------------------------------------------------------------------------------------------------------------------|------------|
| fun getFocusedData(pinId: String?): ActionFocusedData?                                                             | 获取专注模式的数据  |
| fun closeFocusedData(pinId: String?)                                                                               | 退出专注模式     |
| fun closeFocusedSession(handlerName: String)                                                                       | 退出专注模式     |
| fun setFocusedData(pin: ActionKeywordPin, pluginId: String, keyword: String, handler: ActionFocusedKeywordHandler) | 进入专注模式     |
| fun register(keyword: String, handler: ActionKeywordHandler, pluginId: String = AppInfo.BUILTIN_PLUGIN_ID)         | 注册一个动作     |
| fun remove(keyword: String, handler: ActionKeywordHandler)                                                         | 移除一个动作     |
| fun getKeywords(): List\<String\>                                                                                  | 获取所有的关键字   |
| fun getSpecialKeywords(): Set\<String\>                                                                            | 获取所有特殊的关键字 |
| fun getHandlers(keyword: String): List\<PluginActionKeywordHandler\>                                               | 获取所有的处理器   |
| fun allHandlers(): List\<PluginActionKeywordHandler\>                                                              | 获取所有的处理器   |
| fun isSpecialKeyword(keyword: String): Boolean                                                                     | 判断是否是特殊关键字 |
| fun isKeywordValid(keyword: String): Boolean                                                                       | 判断关键字是否有效  |

### top.myrest.myflow.action.ActionKeywordsKt

| 签名                                                                                                           | 说明               |
|--------------------------------------------------------------------------------------------------------------|------------------|
| fun String.asSuggestionResult(): ActionKeywordSuggestionResult\<String\>                                     | 使string类型的结果可被建议 |
| fun \<T\> T.asSuggestionResult(suggestion: String): ActionKeywordSuggestionResult\<T\>                       | 使结果可被建议          |
| fun basicCopyResult(actionId: String, logo: Any? = null, score: Int = 60, result: Any? = null): ActionResult | 一个可复制的结果         |
| val String.highlight: ActionResultTitle                                                                      | 高亮文本             |
| val String.plain: ActionResultTitle                                                                          | 普通文本             |
| val String.subtitle: ActionResultTitle                                                                       | 下标文本             |
| val separateByBundledLanguage: ActionResultTitle                                                             | 单词分隔符            |

### top.myrest.myflow.action.ActionPlaceholderUpdater

| 签名                                                         | 说明          |
|------------------------------------------------------------|-------------|
| fun getCurrentUpdater(): ActionPlaceholderUpdater?         | 获取当前占位符更新器  |
| fun restoreCounts()                                        | 重置占位符更新次数统计 |
| fun getUpdater(updater: String): ActionPlaceholderUpdater? | 获取占位符更新器    |
| fun cache(updater: ActionPlaceholderUpdater)               | 缓存占位符更新器    |

### top.myrest.myflow.action.ActionTitles

| 签名                                                                                                                                         | 说明      |
|--------------------------------------------------------------------------------------------------------------------------------------------|---------|
| fun omitExceed(titles: MutableList\<ActionResultTitle\>,maxWidth: Int = AppInfo.actionWindow.width / 15): MutableList\<ActionResultTitle\> | 省略超出的部分 |

### top.myrest.myflow.component.Composes

| 签名                                                                                                                  | 说明                              |
|---------------------------------------------------------------------------------------------------------------------|---------------------------------|
| var actionWindowProvider: ActionWindowProvider?                                                                     | 获取当前的工作窗口                       |
| var apis: AppApis?                                                                                                  | 程序开放的API                        |
| val mainPin: ActionKeywordPin                                                                                       | Main场景，不能被取消固定                  |
| fun emitActionTextChangedEvent(pin: ActionKeywordPin, action: String? = null)                                       | 发送动作文本更新事件                      |
| fun \<T : Any\> cacheByCurrentLanguage(calculator: () -> T): T                                                      | 缓存状态                            |
| fun Dp.roundToPx(): Int                                                                                             | dp转px                           |
| fun Number.roundToDp(): Dp                                                                                          | px转dp                           |
| fun \<T : Any\> FuncPageScope.remember4FuncPage(key: String = "", calculation: @DisallowComposableCalls () -> T): T | 针对工作页的状态缓存                      |
| fun \<T : Any\> remember(pinId: String, key: String = "", calculation: @DisallowComposableCalls () -> T): T         | 缓存状态                            |
| fun \<T : Any\> cacheState(pinId: String, key: String = "", calculation: () -> T): T                                | 缓存状态                            |
| fun removeStateCache(pinId: String?)                                                                                | 删除状态缓存                          |
| fun resolveLogo(pluginId: String, handlerName: String?, logo: Any?): Pair\<Any?, Boolean\>                          | 解析动作的logo，返回一个包含logo和是否被解析的pair |
| fun getPainter(src: Any?): Painter?                                                                                 | 转成compose的painter               |

### top.myrest.myflow.data.DataSyncServices

| 签名                                             | 说明      |
|------------------------------------------------|---------|
| fun getService(name: String): DataSyncService? | 获取同步的服务 |
| fun stopService(name: String)                  | 暂停同步服务  |
| fun stopService(service: DataSyncService)      | 暂停同步服务  |

### top.myrest.myflow.db.MyDb

| 签名                         | 说明    |
|----------------------------|-------|
| fun exportTo(file: File)   | 导出到文件 |
| fun importFrom(file: File) | 从文件导入 |

### top.myrest.myflow.event.CombinedEvents

| 签名                                                                                                                         | 说明       |
|----------------------------------------------------------------------------------------------------------------------------|----------|
| fun addCombinedListener(combinedEvents: Set\<Class\<out AppEvent\>\>, listener: CombinedEventListener)                     | 添加组合事件监听 |
| fun removeCombinedListener(combinedEvents: Set\<Class\<out AppEvent\>\>, listener: CombinedEventListener)                  | 移除监听器    |
| fun removeCombinedListener(tolerance: Long, combinedEvents: Set\<Class\<out AppEvent\>\>, listener: CombinedEventListener) | 移除监听器    |

### top.myrest.myflow.event.EventBus

| 签名                                                                                                                               | 说明      |
|----------------------------------------------------------------------------------------------------------------------------------|---------|
| fun \<T : AppEvent\> Class\<T\>.addSimpleListener(priority: Int = 100, handler: () -> Unit): BaseEventListener\<T\>              | 添加事件监听器 |
| fun \<T : AppEvent\> Class\<T\>.addListener(priority: Int = 100, handler: (EventExtraDetail, T) -> Unit): BaseEventListener\<T\> | 添加事件监听器 |
| fun \<T : AppEvent\> Class\<T\>.addListener(handler: EventListener\<T\>)                                                         | 添加事件监听器 |
| fun \<T : AppEvent\> Class\<T\>.removeListener(handler: EventListener\<T\>)                                                      | 删除事件监听器 |
| fun \<T : AppEvent\> Class\<T\>.removeEvent(): Set\<EventListener\<out AppEvent\>\>                                              | 参数事件监听器 |
| fun \<T : AppEvent\> T.emit(): Future\<Unit\>                                                                                    | 发送事件    |

### top.myrest.myflow.util.AsyncTasks

| 签名                                                 | 说明     |
|----------------------------------------------------|--------|
| fun execute(task: Runnable)                        | 执行异步任务 |
| fun \<T\> submit(task: Callable\<T\>): Future\<T\> | 执行异步任务 |

### top.myrest.myflow.util.Jackson

| 签名                                                           | 说明 |
|--------------------------------------------------------------|----|
| val jsonMapper: ObjectMapper                                 |    |
| val yamlMapper: ObjectMapper                                 |    |
| inline fun \<reified T\> String.readByYaml(): T              |    |
| fun Any.toYamlString(): String                               |    |
| inline fun \<reified T\> String.readByJson(): T              |    |
| inline fun \<reified T\> String.readByJsonArray(): List\<T\> |    |
| fun Any.toJsonString(pretty: Boolean = false): String        |    |

### top.myrest.myflow.util.SearchingSyntax

| 签名                                                                                               | 说明   |
|--------------------------------------------------------------------------------------------------|------|
| fun highlightTitle(keyword: String, title: String): SearchingHighlightTitle                      | 高亮标题 |
| fun fuzzyKeyword(keyword: String, fuzzyStart: Boolean = false, fuzzyEnd: Boolean = true): String | 模糊搜索 |
