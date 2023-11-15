package runflow

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color
import cn.hutool.core.util.RandomUtil
import top.myrest.myflow.component.ThemeProvider

class KotlinTheme : ThemeProvider {

    override fun provideTheme(): Colors = Colors(
        primary = randomColor(),
        primaryVariant = randomColor(),
        secondary = randomColor(),
        secondaryVariant = randomColor(),
        background = randomColor(),
        surface = randomColor(),
        error = randomColor(),
        onPrimary = randomColor(),
        onSecondary = randomColor(),
        onBackground = randomColor(),
        onSurface = randomColor(),
        onError = randomColor(),
        isLight = true,
    )

    private fun randomColor(): Color {
        val red = RandomUtil.randomInt(255)
        val green = RandomUtil.randomInt(255)
        val blue = RandomUtil.randomInt(255)
        return Color(red, green, blue, 255)
    }
}
