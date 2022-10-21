public class Main {
  final static int SAFE = -1;
  // Got idea off https://www.geeksforgeeks.org/the-knights-tour-problem-backtracking-1/
  final static int xMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
  final static int yMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };

  public static void initBoard(int[][] board) {
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        board[row][col] = SAFE;
      }
    }
  }

  public static void printBoard(int[][] board) {
    for (int row = 0; row < board.length; row++) {
      System.out.print("[ ");
      for (int col = 0; col < board[row].length; col++) {
        System.out.printf("%02d", board[row][col]);
        System.out.print(" ");
      }
      System.out.println("]");
    }
  }

  public static boolean isValid(int[][] board, int[] pos) {
    final int length = board.length;
    int row = pos[0];
    int col = pos[1];

    if (row < 0 || row > length - 1) {
      return false;
    }
    
    if (col < 0 || col > length - 1) {
      return false;
    }

    if (board[row][col] != SAFE) {
      return false;
    }

    return true;
  }

  public static boolean findSolution(int[][] board, int row, int col, int counter) {
    if (counter == Math.pow(board.length, 2)) {
      return true;
    }

    int[] pos = new int[2];
    for (int move = 0; move < 8; move++) {
      pos[0] = row + yMove[move];
      pos[1] = col + xMove[move];

      if (isValid(board, pos)) {
        board[pos[0]][pos[1]] = counter;
        if (findSolution(board, pos[0], pos[1], counter + 1)) {
          return true;
        } 

        board[pos[0]][pos[1]] = SAFE;
      }

    }

    return false;
  }

  public static void main(String[] args) {
    int[][] board = new int[8][8];
    initBoard(board);
    board[0][0] = 0;

    if (findSolution(board, 0, 0, 1)) {
      printBoard(board);
    } else {
      System.out.println("No Solution Found!");
    }
  }
}

// PAIN THAT I DID THIS
// switch (move) {
//   // Up two and right one
//   case 1: {
//     if (row - 2 < 0 || col + 1 >= board.length) {
//       break;
//     }

//     if (board[row - 2][col + 1] < 0) {
//       pos[0] = row - 2;
//       pos[1] = col + 1;
//       return true;
//     }
//     break;
//   }
//   // Up two left one
//   case 2: {
//     if (row - 2 < 0 || col - 1 < 0) {
//       break;
//     }

//     if (board[row - 2][col - 1] < 0) {
//       pos[0] = row - 2;
//       pos[1] = col - 1;
//       return true;
//     }
//     break;
//   }
//   // Left two up one
//   case 3: {
//     if (row - 1 < 0 || col - 2 < 0) {
//       break;
//     }

//     if (board[row - 1][col - 2] < 0) {
//       pos[0] = row - 1;
//       pos[1] = col - 2;
//       return true;
//     }
//     break;
//   }
//   // left two down one
//   case 4: {
//     if (row + 1 >= board.length || col - 2 < 0) {
//       break;
//     }

//     if (board[row + 1][col - 2] < 0) {
//       pos[0] = row + 1;
//       pos[1] = col - 2;
//       return true;
//     }
//     break;
//   }
//   // down two left one
//   case 5: {
//     if (row + 2 >= board.length || col - 1 < 0) {
//       break;
//     }

//     if (board[row + 2][col - 1] < 0) {
//       pos[0] = row + 2;
//       pos[1] = col - 1;
//       return true;
//     }
//     break;
//   }
//   // down two right one
//   case 6: {
//     if (row + 2 >= board.length || col + 1 >= board.length) {
//       break;
//     }

//     if (board[row + 2][col + 1] < 0) {
//       pos[0] = row + 2;
//       pos[1] = col + 1;
//       return true;
//     }
//     break;
//   }
//   // right two down one
//   case 7: {
//     if (row + 1 >= board.length || col + 2 >= board.length) {
//       break;
//     }

//     if (board[row + 1][col + 2] < 0) {
//       pos[0] = row + 1;
//       pos[1] = col + 2;
//       return true;
//     }
//     break;
//   }
//   // right two up one
//   case 8: {
//     if (row - 1 < 0 || col + 2 >= board.length) {
//       break;
//     }

//     if (board[row - 1][col + 2] < 0) {
//       pos[0] = row - 1;
//       pos[1] = col + 2;
//       return true;
//     }
//     break;
//   }
// }