package org.home.twoplayergames.engine.minmax

enum class NodeType {
    MAX, MIN
}

data class Node<T>(
    val position: T? = null,
    var evaluation: Int? = null,
    var children: MutableList<Node<T>> = mutableListOf(),
    var type: NodeType? = null
)