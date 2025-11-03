// Octavio Vieira
// CS 143
//
// Assignment: HW #1: Sudoku #1 (Board Setup)
//
// This program loads uses a SudokuBoard Class that can load a sudoku board from specified text file.

import java.io.FileNotFoundException;

public class PlaySudoku {
    public static void main(String[] args) throws FileNotFoundException {
        SudokuBoard board = new SudokuBoard("data1.sdk"); 
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
 
 
  ----jGRASP: Operation complete.
 */
 
 
 // new comment for testing commit 