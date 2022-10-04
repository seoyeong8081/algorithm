#include <iostream>
#include <string>
#include <queue>
using namespace std;

int main(int argc, char const *argv[])
{
  int N, M;
  cin >> N >> M;
  string input;

  int **miro = new int *[N];
  for (int i = 0; i < N; i++)
  {
    cin >> input;
    miro[i] = new int[M];
    for (int j = 0; j < M; j++)
    {
      miro[i][j] = input[j] - '0';
    }
  }

  queue<pair<int, int>> queue;
  bool **isVisited = new bool *[N];
  for (int i = 0; i < N; i++)
  {
    isVisited[i] = new bool[M];
    for (int j = 0; j < M; j++)
    {
      isVisited[i][j] = false;
    }
  }

  int dr[4] = {-1, 1, 0, 0};
  int dc[4] = {0, 0, -1, 1};

  int curR = 0;
  int curC = 0;
  int nextR, nextC;
  queue.push(make_pair(curR, curC));
  isVisited[curR][curC] = true;
  int depth = 1;

  while (!queue.empty())
  {
    int depNum = queue.size();
    depth++;
    while (depNum)
    {
      auto visit = queue.front();
      curR = visit.first;
      curC = visit.second;
      queue.pop();
      depNum--;

      for (int i = 0; i < 4; i++)
      {
        nextR = curR + dr[i];
        nextC = curC + dc[i];
        if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && miro[nextR][nextC] && !isVisited[nextR][nextC])
        {
          if (nextR == N - 1 && nextC == M - 1)
          {
            cout << depth << endl;
            return 0;
          }
          isVisited[nextR][nextC] = true;
          queue.push(make_pair(nextR, nextC));
        }
      }
    }
  }

  return 0;
}
