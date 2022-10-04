#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

vector<int> ans;
int N;
int cntDanji;
void dfs(int r, int c, vector<vector<int>> map, bool **isVisited);

int main(int argc, char const *argv[])
{
  // int N;
  cin >> N;
  string input;

  vector<vector<int>> map(N);
  bool **isVisited = new bool *[N];
  for (int i = 0; i < N; i++)
  {
    cin >> input;
    isVisited[i] = new bool[N];
    for (int j = 0; j < N; j++)
    {
      map[i].push_back(input[j] - '0');
      isVisited[i][j] = false;
    }
  }

  for (int i = 0; i < N; i++)
  {
    for (int j = 0; j < N; j++)
    {
      if (map[i][j] && !isVisited[i][j])
      {
        cntDanji = 0;
        dfs(i, j, map, isVisited);
        ans.push_back(cntDanji);
      }
    }
  }

  sort(ans.begin(), ans.end());
  int size = ans.size();
  cout << size << endl;
  for (auto i = ans.begin(); i != ans.end(); ++i)
  {
    cout << *i << endl;
  }
  // for (int i = 0; i < size; i++)
  // {
  //   cout << ans[i] << endl;
  // }

  return 0;
}

int dr[4] = {-1, 1, 0, 0};
int dc[4] = {0, 0, -1, 1};

void dfs(int r, int c, vector<vector<int>> map, bool **isVisited)
{
  isVisited[r][c] = true;
  cntDanji++;

  int nr, nc;
  for (int i = 0; i < 4; i++)
  {
    nr = r + dr[i];
    nc = c + dc[i];

    if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] && !isVisited[nr][nc])
    {
      dfs(nr, nc, map, isVisited);
    }
  }
}