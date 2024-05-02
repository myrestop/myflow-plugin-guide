# 工作窗口(ActionWindow)

要替换我们的[**工作窗口**](conceptual_interpretation.md#工作窗口actionwindow)，您需要做很多额外的工作 **首先您需要熟悉[JetpackCompose](https://developer.android.com/jetpack/compose/documentation)，然后您还需要熟悉本文档的所有内容。**

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
    fun setRawTextFieldValue(pin: ActionKeywordPin, textFieldValue: TextFieldValue)
    fun getRawTextFieldValue(): TextFieldValue
    fun pinActionFuncPage(result: ActionFuncPageResult)
    fun pinActionKeyword(pin: ActionKeywordPin)
    fun pinOrOpenExist(pin: ActionKeywordPin): ActionKeywordPin
    fun pinOrOpenExist(result: ActionFuncPageResult): ActionFuncPageResult
    fun getPinnedKeywords(onlyActionWindow: Boolean): List<ActionKeywordPin>
    fun getActionResults(pin: ActionKeywordPin): List<ActionResult>
    fun pinActionResult(pin: ActionKeywordPin, result: ActionResult)
    fun unpinActionResult(pin: ActionKeywordPin, result: ActionResult)
    fun hasFocus(): Boolean
    fun getWindow(pinId: String): MyWindow
    fun getAction(): String = getRawTextFieldValue().text
    fun getSelectedActionResult(pin: ActionKeywordPin): ActionResult? {
        return getActionResults(pin).firstOrNull { it.selected }
    }
    fun setAction(pin: ActionKeywordPin, action: String) {
        setRawTextFieldValue(pin, TextFieldValue(action, TextRange(action.length)))
    }
    fun setAction(pin: ActionKeywordPin, action: String, sendEvent: Boolean) {
        setRawTextFieldValue(pin, TextFieldValue(action, TextRange(action.length)), sendEvent)
    }
    fun setRawTextFieldValue(pin: ActionKeywordPin, textFieldValue: TextFieldValue, sendEvent: Boolean) {
        setRawTextFieldValue(pin, textFieldValue)
        if (sendEvent) {
            Composes.emitActionTextChangedEvent(pin, textFieldValue.text)
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
