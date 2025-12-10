// Octavio Vieira
// CS 143
//
// Assignment: HW #2: Sudoku #2 (isValid, isSolved)
//
// This program loads uses a SudokuBoard Class that can load a sudoku board from specified text file.

import java.io.FileNotFoundException;

public class PlaySudoku {
    public static void main(String[] args) throws FileNotFoundException {
        SudokuBoard board = new SudokuBoard("fast-solve.sdk"); 
        System.out.println(board);
    }
}


/*   ----jGRASP exec: java PlaySudoku
 2 . . | 1 . 5 | . . 3 
 . 5 4 | . . . | 7 1 . 
 . 1 . | 2 . 3 | . 8 . 
 ------+-------+------
 6 . 2 | 8 . 7 | 3 . 4 
 . . . | . . . | . . . 
 1 . 5 | 3 . 9 | 8 . 6 
 ------+-------+------
 . 2 . | 7 . 1 | . 6 . 
 . 8 1 | . . . | 2 4 . 
 7 . . | 4 . 2 | . . 1 
 
 
 
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
