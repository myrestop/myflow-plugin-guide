package runflow

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Preview
@Composable
fun DemoEmptyBox() {
    Box(contentAlignment = Alignment.Center) {
        Text(text = "Empty Box")
    }
}
