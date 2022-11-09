// Carlos Aguilera
// 11/08/2000
// Mini Sudoku

public class MiniSudoku {
  static final int EMPTY_CELL = 0;

  public static boolean isSafe(int[][] board, int row, int col, int c) {
    for (int i = 0; i < 3; i++) {
      if (board[row][i] == c) {
        return false;
      }

      if (board[i][col] == c) {
        return false;
      }
    }

    return true;
  }

  public static boolean isSolution(int[][] board) {
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        if (board[row][col] == EMPTY_CELL) {
          for (int c = 1; c <= 3; c++) {
            if (isSafe(board, row, col, c)) {
              board[row][col] = c;
              if (isSolution(board)) {
                return true;
              }
              board[row][col] = EMPTY_CELL;
            }
          }
          return false;
        }
      }
    }

    return true;
  };

  public static void print(int[][] board) {
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        System.out.print(board[row][col] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    {
      int[][] board = {
          { EMPTY_CELL, 2, EMPTY_CELL },
          { 3, 1, EMPTY_CELL },
          { EMPTY_CELL, 3, EMPTY_CELL }
      };

      if (isSolution(board)) {
        print(board);
      }
    }

    System.out.println();

    {
      int[][] board = {
          { EMPTY_CELL, EMPTY_CELL, EMPTY_CELL },
          { 1, EMPTY_CELL, EMPTY_CELL },
          { EMPTY_CELL, 3, EMPTY_CELL }
      };

      if (isSolution(board)) {
        print(board);
      }
    }
  }
};