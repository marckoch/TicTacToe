package stage4

import java.lang.NumberFormatException

fun printBoard(cells: String) {
    println("---------")
    println("| ${cells[0]} ${cells[1]} ${cells[2]} |")
    println("| ${cells[3]} ${cells[4]} ${cells[5]} |")
    println("| ${cells[6]} ${cells[7]} ${cells[8]} |")
    println("---------")
}

fun getRow(cells: String, row: Int): String {
    return "${cells[row * 3]}${cells[row * 3 + 1]}${cells[row * 3 + 2]}"
}

fun getCol(cells: String, col: Int): String {
    return "${cells[col]}${cells[col + 3]}${cells[col + 6]}"
}

// if one row is owned by one player
// we have to check that the other
// two rows are NOT owned by the other player
fun checkRows(cells: String): String? {
    for (row in 0..2) {
        if (getRow(cells, row) == "XXX") {
            for (otherRow in 0..2) {
                if (row != otherRow) {
                    if (getRow(cells, otherRow) == "OOO") {
                        return "Impossible"
                    }
                }
            }
            return "X wins"
        }
        else if (getRow(cells, row) == "OOO") {
            for (otherRow in 0..2) {
                if (row != otherRow) {
                    if (getRow(cells, otherRow) == "XXX") {
                        return "Impossible"
                    }
                }
            }
            return "O wins"
        }
    }
    return null
}

// if one col is owned by one player
// we have to check that the other
// two cols are NOT owned by the other player
fun checkColumns(cells: String): String? {
    for (col in 0..2) {
        if (getCol(cells, col) == "XXX") {
            for (otherCol in 0..2) {
                if (col != otherCol) {
                    if (getCol(cells, otherCol) == "OOO") {
                        return "Impossible"
                    }
                }
            }
            return "X wins"
        }
        else if (getCol(cells, col) == "OOO") {
            for (otherCol in 0..2) {
                if (col != otherCol) {
                    if (getCol(cells, otherCol) == "XXX") {
                        return "Impossible"
                    }
                }
            }
            return "O wins"
        }
    }
    return null
}

fun checkDiagonals(cells: String): String? {
    if (cells[0] == cells[4] && cells[4] == cells[8]) { // top left to bottom right
        return "${cells[0]} wins"
    }
    if (cells[2] == cells[4] && cells[4] == cells[6]) { // top right to bottom left
        return "${cells[2]} wins"
    }
    return null
}

fun checkState(cells: String) {
    val countX = cells.filter { it == 'X' }.length
    val countO = cells.filter { it == 'O' }.length
    if (kotlin.math.abs(countO - countX) > 1) {
        println("Impossible")
        return
    }

    val rowResult = checkRows(cells)
    if (rowResult != null) {
        println(rowResult)
        return
    }

    val colResult = checkColumns(cells)
    if (colResult != null) {
        println(colResult)
        return
    }

    val diagResult = checkDiagonals(cells)
    if (diagResult != null) {
        println(diagResult)
        return
    }

    if (cells.contains("_")) {
        println("Game not finished")
    } else {
        println("Draw")
    }
}

// get user input, validate it and return new board
fun getUserInput(cells: String): String {
    while (true) {
        println("Enter the coordinates:")

        val input = readLine()!!.trim().split(" ")
        if (input.size != 2) {
            println("You should enter numbers!")
            continue
        }
        try {
            val row = Integer.parseInt(input[0])
            val col = Integer.parseInt(input[1])

            if (row in 1..3 && col in 1..3) {
                val index =  3 * (row - 1) + (col - 1)
                val cell = cells[index]
                if (cell == '_') {
                    return cells.replaceRange(index..index, "X")
                } else if (cell in "XO") {
                    println("This cell is occupied! Choose another one!")
                }
            } else {
                println("Coordinates should be from 1 to 3!")
            }
        } catch (ex: NumberFormatException) {
            println("You should enter numbers!")
        }
    }
}

// TODO: maybe use other/better class to store state than String?
fun main() {
    print("Enter cells:")
    var cells = readLine()!!

    printBoard(cells)

    cells = getUserInput(cells)
    printBoard(cells)

    checkState(cells)
}