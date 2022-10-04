#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N, S;
// vector<int> arr;
int cnt = 0;

void subsetSum(vector<int> arr, int sum, int idx);

int main(int argc, char const *argv[])
{
    cin >> N >> S;
    vector<int> arr(N);

    for (int i = 0; i < N; i++)
    {
        cin >> arr[i];
    }

    sort(arr.begin(), arr.end());

    subsetSum(arr, 0, 0);

    if (!S)
        cnt--;
    cout << cnt;

    return 0;
}

void subsetSum(vector<int> arr, int sum, int idx)
{
    if (idx == N)
    {
        if (sum == S)
            cnt++;
        return;
    }

    subsetSum(arr, sum, idx + 1);
    subsetSum(arr, sum + arr[idx], idx + 1);
}