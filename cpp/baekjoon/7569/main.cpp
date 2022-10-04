#include <iostream>
#include <queue>
using namespace std;

int main(int argc, char const *argv[])
{
    int M, N, H;
    cin >> M >> N >> H;

    int ***tomato = new int **[H];
    for (int k = 0; k < H; k++)
    {
        tomato[k] = new int *[N];
        for (int i = 0; i < N; i++)
        {
            tomato[k][i] = new int[M];
            for (int j = 0; j < M; j++)
            {
                cin >> tomato[k][i][j];
            }
        }
    }

    queue<pair<pair<int, int>, int>> queue;

    bool ***isVisited = new bool **[H];
    for (int k = 0; k < H; k++)
    {
        isVisited[k] = new bool *[N];
        for (int i = 0; i < N; i++)
        {
            isVisited[k][i] = new bool[M];
            for (int j = 0; j < M; j++)
            {
                if (tomato[k][i][j] == 1)
                {
                    queue.push({{k, i}, j});
                    isVisited[k][i][j] = true;
                }
                else
                {
                    isVisited[k][i][j] = false;
                }
            }
        }
    }

    int dr[6] = {-1, 1, 0, 0, 0, 0}; // 위, 아래, 왼, 오, 앞, 뒤
    int dc[6] = {0, 0, -1, 1, 0, 0};
    int dh[6] = {0, 0, 0, 0, 1, -1};

    int curR, curC, curH;
    int nextR, nextC, nextH;
    int depth = -1;

    while (!queue.empty())
    {
        int depNum = queue.size();
        depth++;
        while (depNum)
        {
            auto visit = queue.front();
            curH = visit.first.first;
            curR = visit.first.second;
            curC = visit.second;
            tomato[curH][curR][curC] = 1;
            queue.pop();
            depNum--;

            for (int i = 0; i < 6; i++)
            {
                nextR = curR + dr[i];
                nextC = curC + dc[i];
                nextH = curH + dh[i];
                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && nextH >= 0 && nextH < H && !tomato[nextH][nextR][nextC] && !isVisited[nextH][nextR][nextC])
                {
                    isVisited[nextH][nextR][nextC] = true;
                    queue.push({{nextH, nextR}, nextC});
                }
            }
        }
    }

    for (int k = 0; k < H; k++)
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                if (!tomato[k][i][j])
                {
                    cout << -1 << endl;
                    return 0;
                }
            }
        }
    }

    cout << depth << endl;
    return 0;
}
