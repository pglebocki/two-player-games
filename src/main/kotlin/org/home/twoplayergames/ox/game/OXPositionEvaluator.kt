package org.home.twoplayergames.ox.game

import org.home.twoplayergames.engine.minmax.PositionEvaluator

class OXPositionEvaluator : PositionEvaluator<OXPosition> {

    override fun evaluate(position: OXPosition): Int {
        return when {
            position.isWin(Sign.X) -> 1
            position.isWin(Sign.O) -> -1
            position.isDraw() -> 0
            else -> {
                throw IllegalStateException()
            }
        }
    }

    override fun isGameEnd(position: OXPosition): Boolean {
        return position.isWin(Sign.X) || position.isWin(Sign.O) || position.isDraw()
    }

    override fun isWinnerA(position: OXPosition): Boolean {
        return position.isWin(Sign.X)
    }

    override fun isWinnerB(position: OXPosition): Boolean {
        return position.isWin(Sign.O)
    }

    override fun getAllChildren(position: OXPosition): List<OXPosition> {
        return position.getAllChildren()
    }
}