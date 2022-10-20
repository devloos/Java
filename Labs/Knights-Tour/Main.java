public class Main {
  public static void main(String[] args) {
    int[][] board = new int[6][6];
    initArray(board);
    findSolution(board, 0,0, 0);
  }

  public static void initArray(int[][] board) {
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        board[row][col] = -1;
      }
    }
  }

  public static boolean findSolution(int[][] board, int row, int col, int counter) {
    if (counter == Math.pow(board.length, 2)) {
      printBoard(board);
      return true;
    }

    int[] pos = new int[2];
    pos[0] = row;
    pos[1] = col;
    for (int move = 1; move <= 8; move++) {
      if (isValid(board, pos, move)) {
        row = pos[0];
        col = pos[1];
        board[row][col] = counter;
        boolean found = findSolution(board, row, col, counter + 1);
        if (found) {
          return true;
        }
        board[row][col] = -1;
      }
    }
    return false;
  }

  public static void printBoard(int[][] board) {
    for (int row = 0; row < board.length; row++) {
      System.out.print("[");
      for (int col = 0; col < board[row].length; col++) {
        System.out.print(" " + board[row][col]);
      }
      System.out.println(" ]");
    }
    System.out.println();
  }

  public static boolean isValid(int[][] board, int[] pos, int move) {
    int row = pos[0];
    int col = pos[1];
    switch (move) {
      // Up two and right one
      case 1: {
        if (row - 2 < 0 || col + 1 >= board.length) {
          break;
        }

        if (board[row - 2][col + 1] < 0) {
          pos[0] = row - 2;
          pos[1] = col + 1;
          return true;
        }
        break;
      }
      // Up two left one
      case 2: {
        if (row - 2 < 0 || col - 1 < 0) {
          break;
        }

        if (board[row - 2][col - 1] < 0) {
          pos[0] = row - 2;
          pos[1] = col - 1;
          return true;
        }
        break;
      }
      // Left two up one
      case 3: {
        if (row - 1 < 0 || col - 2 < 0) {
          break;
        }

        if (board[row - 1][col - 2] < 0) {
          pos[0] = row - 1;
          pos[1] = col - 2;
          return true;
        }
        break;
      }
      // left two down one
      case 4: {
        if (row + 1 >= board.length || col - 2 < 0) {
          break;
        }

        if (board[row + 1][col - 2] < 0) {
          pos[0] = row + 1;
          pos[1] = col - 2;
          return true;
        }
        break;
      }
      // down two left one
      case 5: {
        if (row + 2 >= board.length || col - 1 < 0) {
          break;
        }

        if (board[row + 2][col - 1] < 0) {
          pos[0] = row + 2;
          pos[1] = col - 1;
          return true;
        }
        break;
      }
      // down two right one
      case 6: {
        if (row + 2 >= board.length || col + 1 >= board.length) {
          break;
        }

        if (board[row + 2][col + 1] < 0) {
          pos[0] = row + 2;
          pos[1] = col + 1;
          return true;
        }
        break;
      }
      // right two down one
      case 7: {
        if (row + 1 >= board.length || col + 2 >= board.length) {
          break;
        }

        if (board[row + 1][col + 2] < 0) {
          pos[0] = row + 1;
          pos[1] = col + 2;
          return true;
        }
        break;
      }
      // right two up one
      case 8: {
        if (row - 1 < 0 || col + 2 >= board.length) {
          break;
        }

        if (board[row - 1][col + 2] < 0) {
          pos[0] = row - 1;
          pos[1] = col + 2;
          return true;
        }
        break;
      }
    }

    return false;
  }
}