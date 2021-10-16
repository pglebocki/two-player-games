package org.home.twoplayergames.engine.minmax

interface PositionEvaluator<T> {

    fun evaluate(position: T): Int

    fun isGameEnd(position: T): Boolean

    fun isWinnerA(position: T): Boolean

    fun isWinnerB(position: T): Boolean

    // TODO move it somewhere else
    fun getAllChildren(position: T): List<T>
}