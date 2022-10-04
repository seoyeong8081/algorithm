#include <iostream>
#include <queue>
using namespace std;

int main(int argc, char const *argv[])
{
  int M, N;
  cin >> M >> N;

  int **tomato = new int *[N];
  for (int i = 0; i < N; i++)
  {
    tomato[i] = new int[M];
    for (int j = 0; j < M; j++)
    {
      cin >> tomato[i][j];
    }
  }

  queue<pair<int, int>> queue;

  bool **isVisited = new bool *[N];
  for (int i = 0; i < N; i++)
  {
    isVisited[i] = new bool[M];
    for (int j = 0; j < M; j++)
    {
      if (tomato[i][j] == 1)
      {
        queue.push(make_pair(i, j));
        isVisited[i][j] = true;
      }
      else
      {
        isVisited[i][j] = false;
      }
    }
  }

  int dr[4] = {-1, 1, 0, 0};
  int dc[4] = {0, 0, -1, 1};

  int curR, curC;
  int nextR, nextC;
  int depth = -1;

  while (!queue.empty())
  {
    int depNum = queue.size();
    depth++;
    while (depNum)
    {
      auto visit = queue.front();
      curR = visit.first;
      curC = visit.second;
      tomato[curR][curC] = 1;
      queue.pop();
      depNum--;

      for (int i = 0; i < 4; i++)
      {
        nextR = curR + dr[i];
        nextC = curC + dc[i];
        if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && !tomato[nextR][nextC] && !isVisited[nextR][nextC])
        {
          isVisited[nextR][nextC] = true;
          queue.push(make_pair(nextR, nextC));
        }
      }
    }
  }

  for (int i = 0; i < N; i++)
  {
    for (int j = 0; j < M; j++)
    {
      if (!tomato[i][j])
      {
        cout << -1 << endl;
        return 0;
      }
    }
  }

  cout << depth << endl;
  return 0;
}
