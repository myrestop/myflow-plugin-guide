package runflow

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.onClick
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Air
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import top.myrest.myflow.component.ActionToolbar

@Preview
@Composable
fun DemoEmptyBox() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "Empty Box")
    }
}

@Preview
@Composable
@OptIn(ExperimentalFoundationApi::class)
fun DemoToolbar(toolbar: ActionToolbar) {
    toolbar.hoverable {
        Icon(
            imageVector = Icons.Outlined.Air,
            contentDescription = "Air",
            tint = MaterialTheme.colors.onSecondary,
            modifier = Modifier.height(toolbar.iconSize).width(toolbar.iconSize).onClick {
                // do something
                println("clicked toolbar")
            },
        )
    }
}
