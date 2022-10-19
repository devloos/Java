public class Main {
  private static boolean delim = false;
  public static void main(String[] args) {
    {
      char[][] board = new char[4][4];
      delim = false;
      findSolution(board, 0);
    }

    {
      char[][] board = new char[6][6];
      delim = false;
      findSolution(board, 0);
    }

    {
      char[][] board = new char[8][8];
      delim = false;
      findSolution(board, 0);
    }
  }

  public static void findSolution(char[][] state, int col) {
    if (col == state.length || delim) {
      if (delim) return;
      printBoard(state);
      System.out.println();
      delim = true;
      return;
    }

    for (int row = 0; row < state.length; row++) {
      if (moveValid(state, row, col)) {
        state[row][col] = 'Q';
        findSolution(state, col + 1);
        state[row][col] = '-';
      }
    }
  }

  public static boolean moveValid(char[][] state, int row, int col) {
    for (int i = 1; i <= state.length; i++) {
      // Check Left
      if (!(col - i < 0)) {
        if (state[row][col - i] == 'Q') {
          return false;
        }
      }

      // Check Diagonal Up
      if (!(col - i < 0 || row - i < 0)) {
        if (state[row - i][col - i] == 'Q') {
          return false;
        }
      }

      // Check Diagonal Down
      if (!(row + i > (state.length - 1) || col - i < 0)) {
        if (state[row + i][col - i] == 'Q') {
          return false;
        }
      }
    } 
    return true;
  }

  public static void printBoard(char[][] state) {
    cleanBoard(state);
    for (int row = 0; row < state.length; row++) {
      System.out.print('[');
      for (int col = 0; col < state[row].length; col++) {
        System.out.print(" " + state[row][col]);
      }
      System.out.println(" ],");
    }
  }
  
  public static void cleanBoard(char[][] state) {
    for (int row = 0; row < state.length; row++) {
      for (int col = 0; col < state[row].length; col++) {
        if (state[row][col] != 'Q') {
          state[row][col] = '-';
        }
      }
    }
  }
}