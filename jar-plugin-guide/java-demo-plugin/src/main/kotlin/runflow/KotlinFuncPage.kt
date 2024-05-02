package runflow

import androidx.compose.runtime.Composable
import top.myrest.myflow.AppInfo
import top.myrest.myflow.action.ActionKeywordFuncPageContentResult
import top.myrest.myflow.action.ActionKeywordHandler
import top.myrest.myflow.action.ActionParam
import top.myrest.myflow.action.ActionResult
import top.myrest.myflow.action.plain
import top.myrest.myflow.action.singleCallback
import top.myrest.myflow.component.ActionKeywordPin
import top.myrest.myflow.component.ActionKeywordToolbar
import top.myrest.myflow.component.ActionToolbar
import top.myrest.myflow.component.FuncPageScope
import top.myrest.myflow.enumeration.ActionMethod

class KotlinFuncPage : ActionKeywordHandler {

    override fun getFuncPageResults(): List<ActionKeywordFuncPageContentResult> {
        return listOf(getFuncPageResult())
    }

    override fun queryAction(param: ActionParam): List<ActionResult> {
        if (param.args.isNotEmpty()) {
            return emptyList()
        }
        return listOf(
            ActionResult(
                actionId = "page.func",
                title = listOf("Open Func Page".plain),
                result = getFuncPageResult(),
                callbacks = singleCallback(
                    actionMethod = ActionMethod.GOTO_FUNC_PAGE,
                    label = AppInfo.currLanguageBundle.shared.open,
                ),
            )
        )
    }

    private fun getFuncPageResult() = ActionKeywordFuncPageContentResult(
        logo = AppInfo.LOGO,
        height = 600,
        nameBundleId = "Demo Func Page",
        pinName = "Demo",
        placeholderBundleId = "demo placeholder",
        hideActionTextField = true,
        toolbar = FuncPageToolbar(),
        content = content,
    )

    private val content: @Composable FuncPageScope.() -> Unit
        get() = {
            DemoEmptyBox()
        }

    private class FuncPageToolbar : ActionKeywordToolbar {
        override val toolbar: @Composable (ActionKeywordPin, ActionToolbar) -> Unit
            get() = { pin, toolbar -> DemoToolbar(toolbar) }
    }
}