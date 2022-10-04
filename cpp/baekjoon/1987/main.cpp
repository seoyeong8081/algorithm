#include <iostream>
#include <string>
using namespace std;

int ans = 0;
int R, C;

void dfs(int r, int c, int **board, int flag, int cnt);

int main(int argc, char const *argv[])
{
  // int R, C;
  cin >> R >> C;

  int **board = new int *[R];
  string input;
  for (int i = 0; i < R; i++)
  {
    cin >> input;
    board[i] = new int[C];
    for (int j = 0; j < C; j++)
    {
      board[i][j] = input[j] - 'A';
    }
  }

  dfs(0, 0, board, 0, 1);

  cout << ans << endl;

  return 0;
}

int dr[4] = {-1, 1, 0, 0};
int dc[4] = {0, 0, -1, 1};

void dfs(int r, int c, int **board, int flag, int cnt)
{
  if (cnt > ans)
    ans = cnt;
  flag = flag | (1 << board[r][c]);

  for (int i = 0; i < 4; i++)
  {
    int nr = r + dr[i];
    int nc = c + dc[i];
    if (nr >= 0 && nr < R && nc >= 0 && nc < C && !(flag & (1 << board[nr][nc])))
    {
      // dfs(nr, nc, board, flag | (1 << board[nr][nc]), cnt + 1);
      dfs(nr, nc, board, flag, cnt + 1);
    }
  }
}