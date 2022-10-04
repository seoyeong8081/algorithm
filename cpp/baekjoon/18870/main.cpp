#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// boj 18870 좌표압축
// 344ms 14440KB

int N;
vector<pair<int, int>> x;

// bool compareFirst(pair<int, int> a, pair<int, int> b)
// {
//     return a.first < b.first;
// }

bool compareSecond(pair<int, int> a, pair<int, int> b)
{
    return a.second < b.second;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N;
    int input;
    for (int i = 0; i < N; i++)
    {
        cin >> input;
        x.push_back({i, input});
    }

    sort(x.begin(), x.end(), compareSecond);
    int output[N];

    int cnt = 0;
    auto before = x[0].second;
    output[x[0].first] = 0;
    for (int i = 1; i < N; i++)
    {
        auto cur = x[i];
        if (cur.second != before)
        {
            cnt++;
        }
        output[cur.first] = cnt;
        before = cur.second;
    }

    for (int i = 0; i < N; i++)
    {
        cout << output[i] << " ";
    }

    return 0;
}
