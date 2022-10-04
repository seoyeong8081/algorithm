#include <iostream>
#include <vector>
using namespace std;

// boj 18870 좌표압축
// 344ms 14440KB

int N;
typedef pair<int, int> pii;
vector<pair<int, int>> x;

vector<pii>::iterator whereToPut(int input, vector<pii>::iterator start, vector<pii>::iterator end, int size)
{
    // auto start = x.begin();
    // auto end = x.end();
    // int half = x.size() / 2;
    auto mid = start + size / 2;
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

    // auto it = x.begin();
    // cout << (*(x.begin())).second << endl;

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
