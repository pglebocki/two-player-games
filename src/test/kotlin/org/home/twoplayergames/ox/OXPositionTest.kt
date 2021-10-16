package org.home.twoplayergames.ox

import org.home.twoplayergames.ox.Sign.E
import org.home.twoplayergames.ox.Sign.O
import org.home.twoplayergames.ox.Sign.X
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class OXPositionTest {

    @Test
    fun `test areAllFieldsMarked`() {
        val pos1 = createPosition(X, X, X, X, X, O, O, O, O)
        Assertions.assertTrue(pos1.areAllFieldsMarked())

        val pos2 = createPosition(X, E, X, X, X, O, O, O, O)
        Assertions.assertFalse(pos2.areAllFieldsMarked())

        val pos3 = createPosition(X, X, X, X, X, O, O, O, E)
        Assertions.assertFalse(pos3.areAllFieldsMarked())
    }

    @Test
    fun `test isWin`() {
        val pos1 = createPosition(
            X, X, X,
            X, O, O,
            O, O, E
        )
        Assertions.assertTrue(pos1.isWin(X))

        val pos2 = createPosition(
            X, O, O,
            X, X, X,
            O, O, E
        )
        Assertions.assertTrue(pos2.isWin(X))

        val pos3 = createPosition(
            X, O, O,
            O, O, E,
            X, X, X,
        )
        Assertions.assertTrue(pos3.isWin(X))

        val pos4 = createPosition(
            X, X, O,
            X, O, O,
            X, O, E
        )
        Assertions.assertTrue(pos4.isWin(X))

        val pos5 = createPosition(
            X, X, O,
            O, X, O,
            O, X, E
        )
        Assertions.assertTrue(pos5.isWin(X))

        val pos6 = createPosition(
            O, O, X,
            O, O, X,
            E, X, X,
        )
        Assertions.assertTrue(pos6.isWin(X))

        val pos7 = createPosition(
            X, X, O,
            O, X, O,
            O, O, X
        )
        Assertions.assertTrue(pos7.isWin(X))

        val pos8 = createPosition(
            O, O, X,
            O, X, X,
            X, X, O,
        )
        Assertions.assertTrue(pos8.isWin(X))
    }

    @Test
    fun `test isDraw`() {
        val pos1 = createPosition(
            O, X, X,
            X, X, O,
            O, O, X
        )
        Assertions.assertTrue(pos1.isDraw())
    }

    @Test
    fun `test getAllChildren`() {
        val pos1 = OXPosition()
        pos1.nextMove(0, 0)
        Assertions.assertEquals(8, pos1.getAllChildren().size)

        val pos2 = OXPosition()
        pos2.nextMove(0, 0)
        pos2.nextMove(0, 3)
        pos2.nextMove(0, 5)
        Assertions.assertEquals(6, pos2.getAllChildren().size)
    }

    private fun createPosition(vararg signs: Sign): OXPosition {
        return OXPosition(arrayOf(*signs), X)
    }
}