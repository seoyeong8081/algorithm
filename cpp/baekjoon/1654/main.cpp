// boj1654 랜선자르기
#include <iostream>
#include <vector>
using namespace std;

int K, N;
vector<int> line;

bool check(int length)
{
    int cnt = 0;
    for (int i = 0; i < K; i++)
    {
        cnt += line[i] / length;
    }

    if (cnt >= N)
    {
        return true;
    }
    else
    {
        return false;
    }
}

// bool isAnswer(int length)
// {
//     if (check(length) && !check(length + 1))
//         return true;
//     return false;
// }

void binarySearch(int start, int end)
{
    // cout << "start: " << start << ", end: " << end << endl; // test
    int mid = ((long)start + end) / 2; // long으로 해야하나?
    if (check(mid))
    {
        if (!check(mid + 1))
        {
            cout << mid;
            return;
        }
        else if (start + 1 == end && check(mid + 1) && !check(mid + 2))
        {
            cout << mid + 1;
            return;
        }
        binarySearch(mid, end);
    }
    else
    {
        binarySearch(start, mid);
    }
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> K >> N;
    int input;
    long sum = 0;
    for (int i = 0; i < K; i++)
    {
        cin >> input;
        line.push_back(input);
        sum += input;
    }

    int end = sum / N;
    binarySearch(1, end);

    return 0;
}
