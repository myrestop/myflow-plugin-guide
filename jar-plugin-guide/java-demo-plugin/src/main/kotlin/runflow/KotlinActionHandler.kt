package runflow

import androidx.compose.runtime.Composable
import top.myrest.myflow.action.ActionParam
import top.myrest.myflow.action.ActionRequireArgHandler
import top.myrest.myflow.action.ActionResult
import top.myrest.myflow.action.plain
import top.myrest.myflow.component.FuncPageScope
import top.myrest.myflow.component.SettingsContent
import top.myrest.myflow.enumeration.ActionArgMode
import top.myrest.myflow.enumeration.ActionArgType
import top.myrest.myflow.enumeration.HotEventType

class KotlinActionHandler : ActionRequireArgHandler() {

    override val argRequireMode: Pair<ActionArgMode, List<ActionArgType>> = ActionArgMode.emptyArgMode

    override fun isSupportHotEventTrigger(): Boolean = false

    override fun triggerOnHotEvent(hotEventType: HotEventType) {
        println("trigger on hot event, if you supported");
    }

    override fun getCustomizeSettingContent(): SettingsContent {
        return object : SettingsContent {
            override val settingsContent: @Composable FuncPageScope.(pluginId: String) -> Unit
                get() = {

                }
        }
    }

    override fun queryArgAction(param: ActionParam): List<ActionResult> {
        return emptyList()
    }
}