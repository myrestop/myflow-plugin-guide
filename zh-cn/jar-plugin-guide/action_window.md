# 工作窗口(ActionWindow)

要替换我们的[**工作窗口**](conceptual_interpretation.md#工作窗口actionwindow)，您需要做很多额外的工作 **首先您需要熟悉[JetpackCompose](https://developer.android.com/jetpack/compose/documentation)，然后您需要熟悉本文档的所有内容。

提供一个工作窗口可以通过实现`top.myrest.myflow.component.ActionWindowProvider`接口：

```kotlin
interface ActionWindowProvider {
    @get:JsonIgnore
    val actionWindowContent: @Composable DialogWindowScope.(defaultIcon: Painter) -> Unit
    fun updateActionResultList(pin: ActionKeywordPin, list: List<ActionResult>)
    fun getActionTextFieldLocationOffset(): Point
    fun getActionTextFieldHeight(): Int
    fun getWindowInitHeight(): Int
    fun getState(): ActionWindowState?
    fun getActiveKeywordPin(onlyActionWindow: Boolean): ActionKeywordPin
    fun setAction(pin: ActionKeywordPin,action: String)
    fun getAction(): String
    fun pinActionFuncPage(result: ActionFuncPageResult)
    fun pinActionKeyword(pin: ActionKeywordPin)
    fun pinOrOpenExist(pin: ActionKeywordPin): ActionKeywordPin
    fun pinOrOpenExist(result: ActionFuncPageResult): ActionFuncPageResult
    fun getPinnedKeywords(onlyActionWindow: Boolean): List<ActionKeywordPin>
    fun getActionResults(pin: ActionKeywordPin): List<ActionResult>
    fun hasFocus(): Boolean
    fun getWindow(pinId: String): MyWindow
    fun getSelectedActionResult(pin: ActionKeywordPin): ActionResult? {
        return getActionResults(pin).firstOrNull { it.selected }
    }
    fun setAction(pin: ActionKeywordPin,action: String, sendEvent: Boolean) {
        setAction(pin, action)
        if (sendEvent) {
            Composes.emitActionTextChangedEvent(pin, action)
        }
    }
    fun pinOrOpenExist(pluginId: String, result: ActionKeywordFuncPageContentResult): ActionFuncPageResult? {
        val funcPage = Composes.apis?.convertFuncPage(pluginId, result)
        return if (funcPage == null) null else pinOrOpenExist(funcPage)
    }
}

interface ActionWindowState {
    fun pinWindow(pin: Boolean = true, keep: Boolean)
    fun restorePinState()
    fun isPinned(): Boolean
    fun showNotify(state: NotifyState = NotifyState.SUCCESS)
}
```

> **您可以参考我们的工作窗口来设计，使其更加简洁、时尚、绚烂。**
