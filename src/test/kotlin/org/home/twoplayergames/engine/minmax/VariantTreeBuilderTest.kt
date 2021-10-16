package org.home.twoplayergames.engine.minmax

import org.home.twoplayergames.ox.OXPosition
import org.junit.jupiter.api.Test

class VariantTreeBuilderTest {

    val tested = VariantTreeBuilder()

    @Test
    fun `test build tree`() {
        val pos = OXPosition()
        pos.nextMove(0, 0)

        val node = tested.build(pos)
        node
    }
}