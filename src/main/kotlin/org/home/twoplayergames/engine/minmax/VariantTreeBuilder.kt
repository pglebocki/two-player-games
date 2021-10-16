package org.home.twoplayergames.engine.minmax

import org.home.twoplayergames.ox.OXPosition

class VariantTreeBuilder {

    fun build(rootPosition: OXPosition): Node<OXPosition> {
        val rootNode = Node(position = rootPosition)
        rootPosition.getAllChildren().map {
            val node = build(it)
            rootNode.children.add(node)
        }
        return rootNode
    }
}