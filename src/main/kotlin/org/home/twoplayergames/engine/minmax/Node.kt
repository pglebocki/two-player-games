package org.home.twoplayergames.engine.minmax


data class Node<T>(
    val position: T,
    val children: MutableList<Node<T>>,
    var evaluation: Float
)