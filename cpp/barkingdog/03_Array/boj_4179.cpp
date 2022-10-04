#include <iostream>
#include <queue>
#include <string>
using namespace std;

int R, C;
char map[1000][1000];
bool isVisitedFire[1000][1000];
bool isVisitedMe[1000][1000];

int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    queue<pair<int, int>> fire;
    queue<pair<int, int>> me;
    cin >> R >> C;
    string input;
    for (int i = 0; i < R; i++)
    {
        cin >> input;
        for (int j = 0; j < C; j++)
        {
            map[i][j] = input[j];
            switch (map[i][j])
            {
            case 'J':
                isVisitedMe[i][j] = true;
                me.push({i, j});
                break;
            case 'F':
                isVisitedFire[i][j] = true;
                fire.push({i, j});
                break;
            }
        }
    }

    int dr[] = {-1, 0, 1, 0};
    int dc[] = {0, -1, 0, 1};
    bool isPossible = true;
    bool isOut = false;
    int meDep = 0;
    while (isPossible)
    { // fire.isEmpty()도 고려해야하는데
        int fireCntEle = fire.size();
        while (fireCntEle)
        {
            fireCntEle--;
            int r = fire.front().first;
            int c = fire.front().second;
            fire.pop();

            int nr, nc;
            for (int i = 0; i < 4; i++)
            {
                nr = r + dr[i];
                nc = c + dc[i];
                if (nr < 0 || nr >= R || nc < 0 || nc >= C)
                    continue;
                if (map[nr][nc] == '#' || isVisitedFire[nr][nc])
                    continue;

                isVisitedFire[nr][nc] = true;
                fire.push({nr, nc});
            }
        }

        int meCntEle = me.size();
        meDep++;
        bool doPutOne = false;
        while (meCntEle)
        {
            doPutOne = false;
            meCntEle--;
            int r = me.front().first;
            int c = me.front().second;
            me.pop();

            int nr, nc;
            for (int i = 0; i < 4; i++)
            {
                nr = r + dr[i];
                nc = c + dc[i];
                if (nr < 0 || nr >= R || nc < 0 || nc >= C)
                {
                    cout << meDep << "\n";
                    return 0;
                }
                if (map[nr][nc] == '#' || isVisitedMe[nr][nc] || isVisitedFire[nr][nc])
                    continue;

                isVisitedMe[nr][nc] = true;
                me.push({nr, nc});
                doPutOne = true;
            }
        }
        if (!doPutOne)
        {
            cout << "IMPOSSIBLE"
                 << "\n";
            return 0;
        }
    }

    return 0;
}
