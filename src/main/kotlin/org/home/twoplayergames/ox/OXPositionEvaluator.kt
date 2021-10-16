package org.home.twoplayergames.ox

import org.home.twoplayergames.engine.minmax.PositionEvaluator

class OXPositionEvaluator : PositionEvaluator<OXPosition> {

    override fun evaluate(position: OXPosition): Int {
        return when {
            position.isWin(SIGN.X) -> 1
            position.isWin(SIGN.O) -> -1
            position.isDraw() -> 0
            else -> 0
        }
    }

    override fun isGameEnd(position: OXPosition): Boolean {
        return position.isWin(SIGN.X) || position.isWin(SIGN.O)
    }
}