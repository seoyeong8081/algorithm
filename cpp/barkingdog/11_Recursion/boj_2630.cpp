#include <iostream>
using namespace std;

int N;
int map[128][128];

int *func(int r, int c, int len, int *ans)
{
    int firstInt = map[r][c];
    for (int i = r; i < r + len; i++)
    {
        for (int j = c; j < c + len; j++)
        {
            if (map[i][j] != firstInt)
            {
                goto EXIT;
            }
        }
    }
    if (!firstInt)
    {
        ans[0]++;
    }
    else
        ans[1]++;
    return ans;

EXIT:
    int halfLen = len / 2;
    func(r, c, halfLen, ans);
    func(r, c + halfLen, halfLen, ans);
    func(r + halfLen, c, halfLen, ans);
    func(r + halfLen, c + halfLen, halfLen, ans);
    return ans;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            cin >> map[i][j];
        }
    }

    int *ans = func(0, 0, N, new int[2]{0, 0});
    cout << ans[0] << "\n"
         << ans[1] << "\n";
}