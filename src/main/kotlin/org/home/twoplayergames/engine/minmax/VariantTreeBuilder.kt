package org.home.twoplayergames.engine.minmax

import org.home.twoplayergames.ox.OXPosition

class VariantTreeBuilder(
    private val evaluator: PositionEvaluator<OXPosition>
) {

    private var allNodesCount = 0
    private var leafNodesCount = 0

    fun build(rootPosition: OXPosition): Node<OXPosition> {
        val rootNode = Node(position = rootPosition)
        allNodesCount++

        if (evaluator.isGameEnd(rootPosition)) {
            leafNodesCount++
            return rootNode
        }

        rootPosition.getAllChildren().map {
            val node = build(it)
            rootNode.children.add(node)
        }
        return rootNode
    }

    fun printNodesInfo() {
        println("All nodes = $allNodesCount, leafs = $leafNodesCount")
    }
}