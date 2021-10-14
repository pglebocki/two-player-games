package org.home.twoplayergames.ox


// TODO optimize methods
class OXPosition {

    var nextTurn = 1

    // TODO optimize memory
    var array = Array(3) {
        IntArray(3)
    }

    fun isWin(turn: Int): Boolean {
        return 0.rowEqualTo(turn) ||
                1.rowEqualTo(turn) ||
                2.rowEqualTo(turn) ||
                0.columnEqualTo(turn) ||
                1.columnEqualTo(turn) ||
                2.columnEqualTo(turn) ||
                firstDiagonalEqual(turn) ||
                secondDiagonalEqual(turn)
    }

    fun isDraw(): Boolean {
        return allFieldsMarked() && !isWin(-1) && !isWin(1)
    }

    fun markCell(row: Int, column: Int, value: Int) {
        array[row][column] = value
        nextTurn *= -1
    }

    private fun allFieldsMarked(): Boolean {
        var allFieldsMarked = true
        (0..2).forEach { x ->
            (0..2).forEach { y ->
                if (array[x][y] == 0) {
                    allFieldsMarked = false
                }
            }
        }
        return allFieldsMarked
    }

    private fun Int.rowEqualTo(value: Int): Boolean {
        return array[this][0] == value && array[this][1] == value && array[this][2] == value
    }

    private fun Int.columnEqualTo(value: Int): Boolean {
        return array[0][this] == value && array[1][this] == value && array[2][this] == value
    }

    private fun firstDiagonalEqual(value: Int): Boolean {
        return array[0][0] == value && array[1][1] == value && array[2][2] == value
    }

    private fun secondDiagonalEqual(value: Int): Boolean {
        return array[0][2] == value && array[1][1] == value && array[2][0] == value
    }

    fun getAllChildren(): List<OXPosition>? {
        if (allFieldsMarked()) return null

        val positions = mutableListOf<OXPosition>()
        (0..2).forEach { x ->
            (0..2).forEach { y ->
                if (array[x][y] == 0) {
                    val newArray = array.copy3x3()
                    val nt = nextTurn
                    val newPosition = OXPosition().apply {
                        this.nextTurn = nt
                        this.array = newArray
                    }
                    newPosition.markCell(x, y, nt)
                    positions.add(newPosition)
                }
            }
        }
        return positions
    }
}

fun Array<IntArray>.copy3x3(): Array<IntArray> {
    return arrayOf(
        get(0).copyOf(),
        get(1).copyOf(),
        get(2).copyOf()
    )
}

