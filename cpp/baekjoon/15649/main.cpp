#include <iostream>
#include <vector>
using namespace std;

int N, M;

void permutation(vector<int> arr, int idx, int flag, vector<int> out);

int main(int argc, char const *argv[])
{
    cin >> N >> M;
    vector<int> arr;
    for (int i = 1; i <= N; i++)
    {
        arr.push_back(i);
    }

    vector<int> out;
    permutation(arr, 0, 0, out);

    return 0;
}

void permutation(vector<int> arr, int idx, int flag, vector<int> out)
{
    if (idx == M)
    {
        for (int i : out)
        {
            cout << i << " ";
        }
        cout << "\n";
        return;
    }

    for (int i = 0; i < N; i++)
    {
        if (!(flag & 1 << i))
        {
            out.push_back(arr[i]);
            permutation(arr, idx + 1, flag | 1 << i, out);
            out.pop_back();
        }
    }
}