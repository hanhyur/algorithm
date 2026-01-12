class Solution {
  public int solution(String[] board) {
    int oCount = 0;
    int xCount = 0;

    for (int i = 0; i < 3; i++) {
      String row = board[i];
      for (int j = 0; j < 3; j++) {
        char c = row.charAt(j);
        if (c == 'O') {
          oCount++;
        } else if (c == 'X') {
          xCount++;
        }
      }
    }

    if (xCount > oCount || oCount > xCount + 1) {
      return 0;
    }

    boolean oWin = hasWin(board, 'O');
    boolean xWin = hasWin(board, 'X');

    if (oWin && xWin) {
      return 0;
    }

    if (oWin && oCount != xCount + 1) {
      return 0;
    }

    if (xWin && oCount != xCount) {
      return 0;
    }

    return 1;
  }

  private boolean hasWin(String[] board, char player) {
    for (int i = 0; i < 3; i++) {
      if (board[i].charAt(0) == player
          && board[i].charAt(1) == player
          && board[i].charAt(2) == player) {
        return true;
      }
      if (board[0].charAt(i) == player
          && board[1].charAt(i) == player
          && board[2].charAt(i) == player) {
        return true;
      }
    }

    if (board[0].charAt(0) == player
        && board[1].charAt(1) == player
        && board[2].charAt(2) == player) {
      return true;
    }

    if (board[0].charAt(2) == player
        && board[1].charAt(1) == player
        && board[2].charAt(0) == player) {
      return true;
    }

    return false;
  }
}