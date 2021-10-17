package org.home.twoplayergames.ox.game

import org.home.twoplayergames.engine.minmax.MinMax
import org.home.twoplayergames.engine.minmax.Node
import org.home.twoplayergames.engine.minmax.PositionEvaluator
import org.home.twoplayergames.engine.minmax.VariantTreeBuilder
import org.home.twoplayergames.ox.game.OXGameState.DRAW
import org.home.twoplayergames.ox.game.OXGameState.O_WON
import org.home.twoplayergames.ox.game.OXGameState.X_WON
import javax.inject.Inject

enum class OXGameState {
    O_WON,
    X_WON,
    DRAW
}

class OXGame @Inject constructor(
    private val evaluator: PositionEvaluator<OXPosition>,
    minMax: MinMax<OXPosition>,
    variantBuilder: VariantTreeBuilder<OXPosition>
) {

    var gameStatusCallback: ((OXGameState) -> Unit)? = null
    var updatePositionCallback: ((OXPosition) -> Unit)? = null

    var currentPosition = OXPosition()
    var currentNode: Node<OXPosition>

    init {
        currentNode = variantBuilder.build(currentPosition)
        minMax.execute(currentNode, true)
    }

    fun playerMove(row: Int, col: Int) {
        currentPosition.nextMove(row, col)
        updatePositionCallback?.invoke(currentPosition)
        updateGameStatus()

        if (evaluator.isGameEnd(currentPosition)) {
            return
        }

        currentNode.children.forEach {
            if (it.position!!.isSame(currentPosition)) {
                currentNode = it
            }
        }

        machineMove()
    }

    private fun machineMove() {
        var bestMove: Node<OXPosition>? = currentNode.children.firstOrNull()
        currentNode.children.forEach {
            if (evaluator.isWinnerB(it.position!!)) {
                bestMove = it
                return@forEach
            }
            if (it.evaluation!! < bestMove!!.evaluation!!) {
                bestMove = it
            }
        }

        bestMove?.let {
            currentNode = it
            currentPosition = it.position!!
            updatePositionCallback?.invoke(currentPosition)
        }

        updateGameStatus()
    }

    private fun updateGameStatus() {
        when {
            currentPosition.isWin(Sign.O) -> {
                gameStatusCallback?.invoke(O_WON)
            }
            currentPosition.isWin(Sign.X) -> {
                gameStatusCallback?.invoke(X_WON)
            }
            currentPosition.isDraw() -> {
                gameStatusCallback?.invoke(DRAW)
            }
        }
    }
}