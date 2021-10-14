package org.home.twoplayergames.ox

import org.home.twoplayergames.engine.minmax.Node
import org.home.twoplayergames.ox.OXGameState.DRAW
import org.home.twoplayergames.ox.OXGameState.O_WON
import org.home.twoplayergames.ox.OXGameState.X_WON

enum class OXGameState {
    O_WON,
    X_WON,
    DRAW
}

class OXGame(
    private val callback: (OXGameState) -> Unit
) {

    private val O = 1
    private val X = -1

    private var turn: Int = O

    val position = OXPosition()


    fun markCell(row: Int, column: Int): Int {
        position.markCell(row, column, turn)

        if (position.isWin(turn)) {
            callback.invoke(if (turn == 1) O_WON else X_WON)
        } else if (position.isDraw()) {
            callback.invoke(DRAW)
        }

        turn *= -1
        return turn * -1
    }

    fun buildVariantsTree(): Node<OXPosition> {
        val rootNode = Node(
            position = OXPosition(),
            children = mutableListOf(),
            evaluation = 0.0f
        )
        calculateVariants(rootNode)
        return rootNode
    }

    private fun calculateVariants(node: Node<OXPosition>) {
        node.position.getAllChildren()?.forEach {
            val newNode = Node(
                position = it,
                children = mutableListOf(),
                evaluation = 0.0f
            )
            node.children.add(newNode)
            calculateVariants(newNode)
        }
    }
}