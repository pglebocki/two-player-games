package org.home.twoplayergames.ox

import org.home.twoplayergames.engine.minmax.MinMax
import org.home.twoplayergames.engine.minmax.VariantTreeBuilder
import org.home.twoplayergames.ox.Sign.X
import org.junit.jupiter.api.Test

class OXMinMaxTest {

    val tested = MinMax<OXPosition>(OXPositionEvaluator())

    @Test
    fun `test min max OX`() {
        val pos = OXPosition()
        val node = VariantTreeBuilder().build(pos)
        val tree = tested.minmax(node, true)
        tree
    }

    private fun createPosition(vararg signs: Sign): OXPosition {
        return OXPosition(arrayOf(*signs), X)
    }
}