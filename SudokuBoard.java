// Octavio Vieira
// CS 143
//
// Assignment: HW #1: Sudoku #1 (Board Setup)
//
// This program loads uses a SudokuBoard Class that can load a sudoku board from a text file.


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SudokuBoard {

    private char[][] board; // 9x9 Sudoku grid

    // pre:  filename must be a text file containing exactly 9 lines with 9 characters each
    // post: the file contents are read into the 9x9 board array.
    public SudokuBoard(String filename) throws FileNotFoundException {
        board = new char[9][9];  // Creates a 9x9 grid

        Scanner fileScanner = new Scanner(new File(filename));

        int row = 0;
        while (fileScanner.hasNextLine() && row < 9) {
            String line = fileScanner.nextLine();

            for (int col = 0; col < 9; col++) {
                board[row][col] = line.charAt(col);
            }
            row++;
        }

        fileScanner.close();
    }

    // pre:  none.
    // post: returns a formatted String that represents the Sudoku board.
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < 9; row++) {
            // Add a horizontal line every 3 rows
            if (row % 3 == 0 && row != 0) {
                sb.append("------+-------+------\n");
            }

            for (int col = 0; col < 9; col++) {
                // Add vertical line every 3 columns
                if (col % 3 == 0 && col != 0) {
                    sb.append("| ");
                }

                char cell = board[row][col];
                sb.append(cell == '.' ? ". " : cell + " ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
