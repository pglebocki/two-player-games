package org.home.twoplayergames.engine.minmax

interface PositionEvaluator<T> {

    fun evaluate(position: T) : Int

    fun isGameEnd(position: T): Boolean
}