package org.home.twoplayergames.ox

class OXGame {

    private val O = 1
    private val X = -1

    private var turn: Int = O

    private val array = Array(3) {
        IntArray(3)
    }

    fun markCell(row: Int, column: Int): Int {
        println("row = $row, column = $column")
        array[row][column] = turn

        (0..2).forEach { x ->
            (0..2).forEach { y ->
                print("${array[x][y]}  ")
            }
            println("\n")
        }

        if (isWin(turn)) {
            println("$turn won")
        }

        turn *= -1
        return turn * -1
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
}