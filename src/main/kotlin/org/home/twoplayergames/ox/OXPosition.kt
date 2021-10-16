package org.home.twoplayergames.ox

import org.home.twoplayergames.ox.SIGN.E
import org.home.twoplayergames.ox.SIGN.O
import org.home.twoplayergames.ox.SIGN.X


enum class SIGN {
    X, O, E
}

class OXPosition() {

    constructor(array: Array<SIGN>, nextTurn: SIGN) : this() {
        this.array = array
        this.nextTurn = nextTurn
    }


    private var nextTurn: SIGN = X
    private var array = Array(9) { E }

    fun nextMove(row: Int, column: Int) {
        val index = row * 3 + column
        array[index] = nextTurn
        nextTurn = nextTurn.opposite()
    }

    fun markIndex(index: Int) {
        array[index] = nextTurn
        nextTurn = nextTurn.opposite()
    }

    fun isWin(sign: SIGN): Boolean {
        return (array[0] == sign && array[1] == sign && array[2] == sign) ||   // rows
                (array[3] == sign && array[4] == sign && array[5] == sign) ||
                (array[6] == sign && array[7] == sign && array[8] == sign) ||
                (array[0] == sign && array[3] == sign && array[6] == sign) ||  // columns
                (array[1] == sign && array[4] == sign && array[7] == sign) ||
                (array[2] == sign && array[5] == sign && array[8] == sign) ||
                (array[0] == sign && array[4] == sign && array[8] == sign) ||  // diagonals
                (array[2] == sign && array[4] == sign && array[6] == sign)
    }

    fun isDraw(): Boolean {
        return areAllFieldsMarked() && !isWin(X) && !isWin(O)
    }

    fun getAllChildren(): List<OXPosition> {
        if (areAllFieldsMarked()) return emptyList()

        val positions = mutableListOf<OXPosition>()
        (0 until 9).forEach { index ->
            if (array[index] == E) {
                val newPosition = OXPosition(array.copyOf(), nextTurn)
                newPosition.markIndex(index)
                positions.add(newPosition)
            }
        }
        return positions
    }

    fun print() {
        (0..2).forEach { row ->
            (0..2).forEach { column ->
                val index = row * 3 + column
                print("${array[index]} ")
            }
            println()
        }
    }

    fun isSame(other: OXPosition): Boolean {
        return array.contentEquals(other.array) && nextTurn == other.nextTurn
    }

    fun areAllFieldsMarked(): Boolean {
        return array.find { it == E } == null
    }

    fun SIGN.opposite(): SIGN {
        return when (this) {
            X -> O
            O -> X
            E -> {
                throw IllegalStateException()
            }
        }
    }
}

