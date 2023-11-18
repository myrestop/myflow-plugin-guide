package runflow

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import top.myrest.myflow.component.ActionKeywordPin
import top.myrest.myflow.component.ActionKeywordToolbar
import top.myrest.myflow.component.ActionToolbar

class KotlinToolbar : ActionKeywordToolbar {

    override fun isSupportMainScene(): Boolean = true

    @OptIn(ExperimentalFoundationApi::class)
    override val toolbar: @Composable (ActionKeywordPin, ActionToolbar) -> Unit
        get() = { pin, toolbar -> DemoToolbar(toolbar) }
}