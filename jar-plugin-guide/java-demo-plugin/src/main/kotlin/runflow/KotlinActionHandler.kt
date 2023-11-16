package runflow

import java.util.Date
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cn.hutool.core.date.DatePattern
import cn.hutool.core.date.DateUtil
import kotlinx.coroutines.delay
import top.myrest.myflow.AppInfo
import top.myrest.myflow.action.ActionParam
import top.myrest.myflow.action.ActionRequireArgHandler
import top.myrest.myflow.action.ActionResult
import top.myrest.myflow.action.RefreshableActionResult
import top.myrest.myflow.action.basicCopyResult
import top.myrest.myflow.action.customContentResult
import top.myrest.myflow.action.plain
import top.myrest.myflow.action.singleCallback
import top.myrest.myflow.component.FuncPageScope
import top.myrest.myflow.component.ResultTitleViewer
import top.myrest.myflow.component.SettingsContent
import top.myrest.myflow.enumeration.ActionArgMode
import top.myrest.myflow.enumeration.ActionArgType
import top.myrest.myflow.enumeration.ActionMethod
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
                    DemoEmptyBox()
                }
        }
    }

    override fun queryArgAction(param: ActionParam): List<ActionResult> {
        return listOf(
            RefreshableActionResult(
                actionId = "kotlin.refresh",
                value = "value",
                refreshResult = { value, count ->
                    val list = listOf("😃", "🤢", "🤔", "😆", "😜", "😉", "😎", "😢", "😂", "😊", "😁", "😘", "😒", "😍")
                    basicCopyResult(actionId = "", result = list[count % list.size])
                },
            ),
            customContentResult(
                actionId = "kotlin.customize",
                content = @Composable {
                    var now by remember { mutableStateOf(Date()) }
                    LaunchedEffect(Unit) {
                        while (true) {
                            delay(100)
                            now = Date()
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        ResultTitleViewer(
                            ActionResult(
                                actionId = "",
                                title = listOf(DateUtil.format(now, DatePattern.NORM_DATETIME_MS_FORMATTER).plain),
                                subtitle = AppInfo.currLanguageBundle.shared.copyResult,
                            ),
                        )
                    }
                },
                callbacks = singleCallback(
                    actionMethod = ActionMethod.COPY_RESULT,
                ),
            ),
        )
    }
}