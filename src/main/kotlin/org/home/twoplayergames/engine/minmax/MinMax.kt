package org.home.twoplayergames.engine.minmax

import kotlin.math.max
import kotlin.math.min

class MinMax<T>(
    val startNode: Node<T>,
    val positionEvaluator: PositionEvaluator<T>
) {

    fun start() {

    }

    private fun minmax(node: Node<T>, depth: Int, maximizing: Boolean): Float {
        if (depth == 0) {
            return positionEvaluator.evaluate(node.position)
        }

        return if (maximizing) {
            var maxEval = Float.MIN_VALUE
            node.children.forEach {
                val eval = minmax(it, depth -1, false)
                maxEval = max(maxEval, eval)
            }
            maxEval
        } else {
            var minEval = Float.MAX_VALUE
            node.children.forEach {
                val eval = minmax(it, depth -1, true)
                minEval = min(minEval, eval)
            }
            minEval
        }
    }
}
