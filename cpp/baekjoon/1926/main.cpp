#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main(int argc, char const *argv[])
{
    int n, m;
    cin >> n >> m;

    vector<vector<int>> map(n);

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            int in;
            cin >> in;
            map[i].push_back(in);
        }
    }

    // bool **isVisited = new bool *[n];
    bool isVisited[n][m];
    for (int i = 0; i < n; i++)
    {
        // isVisited[i] = new bool[m];
        for (int j = 0; j < m; j++)
        {
            isVisited[i][j] = false;
        }
    }

    int dr[4] = {-1, 1, 0, 0}; // 상하좌우
    int dc[4] = {0, 0, -1, 1};

    queue<pair<int, int>> q;

    int picNum = 0;
    int maxArea = 0;
    int area = 0;
    for (int row = 0; row < n; row++)
    {
        for (int col = 0; col < m; col++)
        {
            if (map[row][col] && !isVisited[row][col])
            {
                picNum++;
                area = 0;
                q.push({row, col});
                isVisited[row][col] = true;

                while (!q.empty())
                {
                    area++;
                    int curR = q.front().first;
                    int curC = q.front().second;
                    q.pop();

                    int nextR, nextC;
                    for (int i = 0; i < 4; i++)
                    {
                        nextR = curR + dr[i];
                        nextC = curC + dc[i];
                        if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < m && map[nextR][nextC] && !isVisited[nextR][nextC])
                        {
                            q.push({nextR, nextC});
                            isVisited[nextR][nextC] = true;
                        }
                    }
                }

                if (area > maxArea)
                    maxArea = area;
            }
        }
    }

    cout << picNum << "\n"
         << maxArea << "\n";

    return 0;
}
