package org.home.twoplayergames.engine.minmax

import org.home.twoplayergames.ox.OXPosition

interface PositionEvaluator<T> {

    fun evaluate(position: T) : Int

    fun isGameEnd(position: T): Boolean

    fun isWinnerA(position: OXPosition): Boolean

    fun isWinnerB(position: OXPosition): Boolean
}