package org.home.twoplayergames.engine.minmax

import javax.inject.Inject

class VariantTreeBuilder<T> @Inject constructor(
    private val evaluator: PositionEvaluator<T>
) {

    private var allNodesCount = 0
    private var leafNodesCount = 0

    fun build(rootPosition: T): Node<T> {
        val rootNode = Node(position = rootPosition)
        allNodesCount++

        if (evaluator.isGameEnd(rootPosition)) {
            leafNodesCount++
            return rootNode
        }
        val children = evaluator.getAllChildren(rootPosition)
        children.map {
            val node = build(it)
            rootNode.children.add(node)
        }
        return rootNode
    }

    fun printNodesInfo() {
        println("All nodes = $allNodesCount, leafs = $leafNodesCount")
    }
}