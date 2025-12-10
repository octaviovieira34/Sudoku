// Octavio Vieira
// CS 143
//
// Assignment: HW #2: Sudoku #2 (isValid, isSolved)
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
    
    // pre: none
    // post: returns true if the board follows all Sudoku rules. Otherwise returns false.
    public boolean isValid() {
        return validData() && validRows() && validCols() && validMiniSquares();
    }

    // pre: none
    // post: returns true if all cells are filled, board is valid, and each number 1-9.
    public boolean isSolved() {
        if (!isValid()) {
            return false;
        }

        java.util.Map<Character, Integer> counts = new java.util.HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                if (val == '.') {
                    return false; 
                }
                counts.put(val, counts.getOrDefault(val, 0) + 1);
            }
        }

        for (char num = '1'; num <= '9'; num++) {
            if (counts.getOrDefault(num, 0) != 9) {
                return false;
            }
        }

        return true;
    }

    // Helper Methods:

    // checks that all data is valid (1–9 or '.')
    private boolean validData() {
        java.util.Set<Character> validChars = new java.util.HashSet<>();
        for (char ch = '1'; ch <= '9'; ch++) {
            validChars.add(ch);
        }
        validChars.add('.');

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (!validChars.contains(board[r][c])) {
                    return false;
                }
            }
        }
        return true;
    }

    // checks that no row contains duplicates
    private boolean validRows() {
        for (int r = 0; r < 9; r++) {
            java.util.Set<Character> seen = new java.util.HashSet<>();
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                if (val != '.') {
                    if (seen.contains(val)) {
                        return false;
                    }
                    seen.add(val);
                }
            }
        }
        return true;
    }

    // checks that no column contains duplicates
    private boolean validCols() {
        for (int c = 0; c < 9; c++) {
            java.util.Set<Character> seen = new java.util.HashSet<>();
            for (int r = 0; r < 9; r++) {
                char val = board[r][c];
                if (val != '.') {
                    if (seen.contains(val)) {
                        return false;
                    }
                    seen.add(val);
                }
            }
        }
        return true;
    }

    // checks that each 3x3 mini-square contains no duplicates
    private boolean validMiniSquares() {
        for (int spot = 1; spot <= 9; spot++) {
            java.util.Set<Character> seen = new java.util.HashSet<>();
            char[][] mini = miniSquare(spot);
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    char val = mini[r][c];
                    if (val != '.') {
                        if (seen.contains(val)) {
                            return false;
                        }
                        seen.add(val);
                    }
                }
            }
        }
        return true;
    }

    // helper to extract a 3x3 mini-square
    private char[][] miniSquare(int spot) {
        char[][] mini = new char[3][3];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                mini[r][c] = board[(spot - 1) / 3 * 3 + r][(spot - 1) % 3 * 3 + c];
            }
        }
        return mini;
    }
    
    // pre: board must be a valid Sudoku board
    // post: returns true if board can be solved with back tracking. Board gets modidied to the solved puzzle.
    public boolean solve() {      
      if (!isValid()) {
            return false;
        }
        if (isSolved()) {
            return true;
        }
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                
                    for (char ch = '1'; ch <= '9'; ch++) {

                        board[row][col] = ch;

                        if (isValid() && solve()) {
                            return true;
                        }

                        board[row][col] = '.';
                    }

                    return false;
                }
            }
        }

        return false;
    }  
}

/*      ----jGRASP exec: java PlaySudoku
 8 2 7 | 1 5 4 | 3 9 6 
 9 6 5 | . 2 7 | 1 4 8 
 3 4 1 | 6 . 9 | 7 5 2 
 ------+-------+------
 . . . | . . . | . . . 
 . . . | . . . | . . . 
 6 1 8 | 9 7 . | 4 3 5 
 ------+-------+------
 7 8 6 | 2 3 5 | . 1 4 
 1 5 4 | 7 9 6 | 8 . 3 
 2 3 9 | 8 4 . | . . . 
 
 */
