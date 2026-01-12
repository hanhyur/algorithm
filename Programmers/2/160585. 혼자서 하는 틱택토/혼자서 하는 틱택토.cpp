#include <string>
#include <vector>

using namespace std;

bool isWinner(const vector<string>& board, char player)
{
    for (int i = 0; i < 3; i++)
    {
        if (board[i][0] == player &&
            board[i][1] == player &&
            board[i][2] == player) 
        {
                return true;
        }
    }

    for (int j = 0; j < 3; j++)
    {
        if (board[0][j] == player &&
            board[1][j] == player &&
            board[2][j] == player)
        {
            return true;
        }
    }

    if (board[0][0] == player &&
        board[1][1] == player &&
        board[2][2] == player)
    {
        return true;
    }

    if (board[0][2] == player && 
        board[1][1] == player && 
        board[2][0] == player) 
    {
        return true;
    }

    return false;
}

int solution(vector<string> board)
{
    int oCount = 0;
    int xCount = 0;

    for (const string& row : board)
    {
        for (char c : row)
        {
            if (c == 'O')
            {
                oCount++;
            } 
            else if (c == 'X')
            {
                xCount++;
            }
        }
    }

    if (oCount < xCount || oCount > xCount + 1) {
        return 0;
    }

    bool oWin = isWinner(board, 'O');
    bool xWin = isWinner(board, 'X');

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