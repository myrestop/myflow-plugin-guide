package runflow

import androidx.compose.runtime.Composable
import top.myrest.myflow.component.ActionKeywordPin
import top.myrest.myflow.component.ActionKeywordToolbar
import top.myrest.myflow.component.ActionToolbar

class KotlinToolbar : ActionKeywordToolbar {
    override val toolbar: (ActionKeywordPin, ActionToolbar) -> Unit
        get() = @Composable { pin, toolbar ->

        }
}