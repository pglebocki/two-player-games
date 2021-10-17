package org.home.twoplayergames.engine.minmax

import kotlin.math.max
import kotlin.math.min

class MinMax<T>(
    private val positionEvaluator: PositionEvaluator<T>
) {

    fun execute(node: Node<T>, maximizing: Boolean): Int {
        if (node.children.isEmpty() || positionEvaluator.isGameEnd(node.position!!)) {
            val eval = positionEvaluator.evaluate(node.position!!)
            node.evaluation = eval
            return eval
        }

        node.type = if (maximizing) NodeType.MAX else NodeType.MIN

        return if (maximizing) {
            var maxEval = Int.MIN_VALUE
            node.children.forEach {
                val eval = execute(it, false)
                maxEval = max(maxEval, eval)
            }
            node.evaluation = maxEval
            maxEval
        } else {
            var minEval = Int.MAX_VALUE
            node.children.forEach {
                val eval = execute(it, true)
                minEval = min(minEval, eval)
            }
            node.evaluation = minEval
            minEval
        }
    }
}
