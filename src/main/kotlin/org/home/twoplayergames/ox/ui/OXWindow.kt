package org.home.twoplayergames.ox.ui

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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import org.home.twoplayergames.ox.game.OXGame
import org.home.twoplayergames.ox.game.OXGameState
import org.home.twoplayergames.ox.game.OXPosition
import org.home.twoplayergames.ox.game.Sign
import javax.inject.Inject

class OXWindow @Inject constructor(
    private val game: OXGame
) {

    private lateinit var displayedPosition: MutableState<OXPosition>

    private val gameCallback: (OXGameState) -> Unit = {
        println("Game status: $it")
    }

    private val updatePositionCallback: (OXPosition) -> Unit = {
        displayedPosition.value = it
    }

    init {
        game.gameStatusCallback = gameCallback
        game.updatePositionCallback = updatePositionCallback
    }

    fun start() {
        application {
            displayedPosition = remember { mutableStateOf(OXPosition()) }

            Window(
                onCloseRequest = ::exitApplication,
                title = "O & X",
                state = rememberWindowState(width = 300.dp, height = 300.dp)
            ) {
                MaterialTheme {
                    Row {
                        Spacer(Modifier.size(30.dp))
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            button(game, displayedPosition, 0, 0)
                            button(game, displayedPosition, 1, 0)
                            button(game, displayedPosition, 2, 0)
                        }
                        Spacer(Modifier.size(30.dp))
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            button(game, displayedPosition, 0, 1)
                            button(game, displayedPosition, 1, 1)
                            button(game, displayedPosition, 2, 1)
                        }
                        Spacer(Modifier.size(30.dp))
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            button(game, displayedPosition, 0, 2)
                            button(game, displayedPosition, 1, 2)
                            button(game, displayedPosition, 2, 2)
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun button(game: OXGame, position: MutableState<OXPosition>, row: Int, column: Int) {
        val sign = position.value.getCell(row, column)
        val char = if (sign != Sign.E) sign.toString() else ""

        Spacer(Modifier.size(30.dp))
        Button(
            onClick = {
                game.playerMove(row, column)
            },
            modifier = Modifier.width(50.dp).height(50.dp),
            enabled = sign == Sign.E
        ) {
            Text(char)
        }
    }
}