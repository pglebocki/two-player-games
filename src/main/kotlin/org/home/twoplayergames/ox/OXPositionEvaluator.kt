package org.home.twoplayergames.ox

import org.home.twoplayergames.engine.minmax.PositionEvaluator
import java.lang.IllegalStateException

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
}