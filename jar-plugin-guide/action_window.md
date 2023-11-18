# Action Window

To replace our default [**action window**](conceptual_interpretation.md#action-window), you need to do a lot of works. **First, you should be familiar with [Jetpack Compose](https://developer.android.com/jetpack/compose/documentation), then you should know all the knowledge of this documentation.**

Provide action window by implementing interface `top.myrest.myflow.component.ActionWindowProvider`:

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

> **You can refer our action window to design an action window, to make it more concise, fashionable and gorgeous.**
