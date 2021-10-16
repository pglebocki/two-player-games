package org.home.twoplayergames.ox

import org.home.twoplayergames.engine.minmax.MinMax
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
    private val gameStatuCallback: (OXGameState) -> Unit,
    private val updatePositionCallback: (OXPosition) -> Unit
) {

    private val O = 1
    private val X = -1

    var currentPosition = OXPosition()

    private val oxPositionEvaluator: (OXPosition) -> Int = {
//        when {
//            it.isWin(1) -> {
//                1
//            }
//            it.isWin(-1) -> {
//                -1
//            }
//            else -> {
//                0
//            }
//        }
         0
    }


//    var currentNode: Node

    init {
//        currentNode = buildVariantsTree(currentPosition)
//        val mm = MinMax(oxPositionEvaluator)
//        mm.minmax(currentNode, false)
//        currentNode
    }

//    fun playerMove(row: Int, col: Int) {
//        currentPosition.markCell(row, col, 1)
//        updatePositionCallback.invoke(currentPosition)
//
//        if (currentPosition.isWin(1)) {
//            gameStatuCallback.invoke(O_WON)
//            return
//        } else if (currentPosition.isDraw()) {
//            gameStatuCallback.invoke(DRAW)
//            return
//        }
//
//        currentNode.children.forEach {
//            if (it.position.isSame(currentPosition)) {
//                currentNode = it
//            }
//        }
//
//        machineMove()
//    }
//
//    fun machineMove() {
//        var bestMove: Node? = null
//        currentNode.children.forEach {
//            if (bestMove == null) {
//                bestMove = it
//            }
//            if (it.evaluation!! < bestMove!!.evaluation!!) {
//                bestMove = it
//            }
//        }
//
//        bestMove?.let {
//            currentNode = it
//            currentPosition = it.position
//            updatePositionCallback.invoke(currentPosition)
//        }
//
//        if (currentPosition.isWin(-1)) {
//            gameStatuCallback.invoke(X_WON)
//        } else if (currentPosition.isDraw()) {
//            gameStatuCallback.invoke(DRAW)
//        }
//    }
//
//    fun buildVariantsTree(position: OXPosition): Node {
//        val rootNode = Node(
//            position = position
//        )
//        calculateVariants(rootNode)
//        return rootNode
//    }
//
//    private fun calculateVariants(node: Node) {
//        node.position.getAllChildren()?.forEach {
//            val newNode = Node(
//                position = it
//            )
//            node.children.add(newNode)
//            calculateVariants(newNode)
//        }
//    }
}