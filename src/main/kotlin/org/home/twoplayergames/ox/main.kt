import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import org.home.twoplayergames.engine.minmax.MinMax
import org.home.twoplayergames.engine.minmax.PositionEvaluator
import org.home.twoplayergames.ox.OXGame
import org.home.twoplayergames.ox.OXGameState
import org.home.twoplayergames.ox.OXPosition


private val gameCallback: (OXGameState) -> Unit = {
    println("Game status: $it")
}

private val oxPositionEvaluator: PositionEvaluator<OXPosition> = object : PositionEvaluator<OXPosition> {

    override fun evaluate(position: OXPosition): Float {
        return when {
            position.isWin(1) -> 1.0f
            position.isWin(-1) -> -1.0f
            else -> 0.0f
        }
    }
}

private val game = OXGame(gameCallback).apply {
    val tree = buildVariantsTree()
    val minMax = MinMax(tree, oxPositionEvaluator)
    minMax.start()
}

// TODO implement opponent !

@ExperimentalFoundationApi
fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "O & X",
        state = rememberWindowState(width = 300.dp, height = 300.dp)
    ) {
        MaterialTheme {
            Row {
                Spacer(Modifier.size(30.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    button(0, 0)
                    button(1, 0)
                    button(2, 0)
                }
                Spacer(Modifier.size(30.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    button(0, 1)
                    button(1, 1)
                    button(2, 1)
                }
                Spacer(Modifier.size(30.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    button(0, 2)
                    button(1, 2)
                    button(2, 2)
                }
            }
        }
    }
}

@Composable
private fun button(row: Int, column: Int) {
    val text = remember { mutableStateOf("") }
    val enabled = remember { mutableStateOf(true) }

    Spacer(Modifier.size(30.dp))
    Button(
        onClick = {
            val result = game.markCell(row, column)
            val sign = if (result == 1) "O" else "X"
            text.value = sign
            enabled.value = false
        },
        modifier = Modifier.width(50.dp).height(50.dp),
        enabled = enabled.value
    ) {
        Text(text.value)
    }
}