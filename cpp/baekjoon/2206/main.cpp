#include <iostream>
#include <string>
#include <vector>
#include <queue>
using namespace std;
// dfs는 시간초과
// 최단 경로 구하는 거는 bfs로 풀기

int main(int argc, char const *argv[])
{
    int N, M;
    vector<vector<char>> map;
    bool ***isVisited;
    cin >> N >> M;
    isVisited = new bool **[N];
    string input;
    for (int i = 0; i < N; i++)
    {
        isVisited[i] = new bool *[M];

        cin >> input;
        vector<char> row;
        for (int j = 0; j < M; j++)
        {
            isVisited[i][j] = new bool[2];
            for (int k = 0; k < 2; k++)
            {
                isVisited[i][j][k] = false;
            }

            row.push_back(input[j]);
        }
        map.push_back(row);
    }

    queue<pair<pair<int, int>, bool>> queue; // row, col, 벽을 한번 부셨는지(true) 안부셨는지(false)
    int depth = 1;

    if (N == 1 && M == 1)
    {
        cout << 1 << "\n";
        return 0;
    }

    queue.push({{0, 0}, false});
    isVisited[0][0][0] = true;
    int dr[4] = {-1, 1, 0, 0};
    int dc[4] = {0, 0, -1, 1};

    int curR, curC, nextR, nextC;
    bool curBreakWall;
    bool breakLoop = false;

    while (!queue.empty())
    {
        int qSize = queue.size();
        depth++;
        while (qSize)
        {
            auto cur = queue.front();
            curR = cur.first.first;
            curC = cur.first.second;
            curBreakWall = cur.second;
            int breakWall = curBreakWall ? 1 : 0;
            queue.pop();
            qSize--;

            for (int i = 0; i < 4; i++)
            {
                nextR = curR + dr[i];
                nextC = curC + dc[i];
                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M)
                {
                    if (!isVisited[nextR][nextC][breakWall] && map[nextR][nextC] == '0')
                    {
                        if (nextR == N - 1 && nextC == M - 1)
                        {
                            breakLoop = true;
                            break;
                        }
                        queue.push({{nextR, nextC}, curBreakWall});
                        isVisited[nextR][nextC][breakWall] = true;
                    }
                    else if (!isVisited[nextR][nextC][breakWall] && map[nextR][nextC] == '1' && !curBreakWall)
                    {
                        if (nextR == N - 1 && nextC == M - 1)
                        {
                            breakLoop = true;
                            break;
                        }
                        queue.push({{nextR, nextC}, true});
                        isVisited[nextR][nextC][breakWall] = true; //???
                    }
                }
            }
            if (breakLoop)
                break;
        }
        if (breakLoop)
            break;
    }

    if (breakLoop)
    {
        cout << depth << "\n";
    }
    else
    {
        cout << -1 << "\n";
    }

    return 0;
}
