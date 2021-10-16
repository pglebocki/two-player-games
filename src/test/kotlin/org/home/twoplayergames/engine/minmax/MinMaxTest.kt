package org.home.twoplayergames.engine.minmax

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


class MinMaxTest {

    val evaluator: PositionEvaluator<Int> = object : PositionEvaluator<Int> {
        override fun evaluate(position: Int): Int {
            return position
        }

        override fun isGameEnd(position: Int): Boolean {
            return false
        }

    }

    val tested = MinMax(evaluator)

    @Test
    fun testTree1() {
        val rootNode = Node(
            children = mutableListOf(
                Node(-1), Node(2)
            )
        )
        Assertions.assertEquals(tested.minmax(rootNode, true), 2)
        Assertions.assertEquals(tested.minmax(rootNode, false), -1)
    }

    @Test
    fun testTree2() {
        val rootNode = Node(
            children = mutableListOf(
                Node(
                    children = mutableListOf(
                        Node(1), Node(2), Node(3)
                    )
                ),
                Node(
                    children = mutableListOf(
                        Node(3), Node(4), Node(5)
                    )
                )
            )
        )
        Assertions.assertEquals(tested.minmax(rootNode, true), 3)
        Assertions.assertEquals(tested.minmax(rootNode, false), 3)
    }

    @Test
    fun testTree3() {
        val rootNode = Node(
            children = mutableListOf(
                Node(
                    children = mutableListOf(
                        Node(
                            children = mutableListOf(
                                Node(-1), Node(3)
                            )
                        ),
                        Node(
                            children = mutableListOf(
                                Node(5), Node(1)
                            )
                        ),
                    )
                ),
                Node(
                    children = mutableListOf(
                        Node(
                            children = mutableListOf(
                                Node(-6), Node(-4)
                            )
                        ),
                        Node(
                            children = mutableListOf(
                                Node(0), Node(9)
                            )
                        ),
                    )
                )
            )
        )
        Assertions.assertEquals(tested.minmax(rootNode, true), 3)
        Assertions.assertEquals(tested.minmax(rootNode, false), 0)
    }

}