// boj 2295 세수의 합
#include <iostream>
#include <algorithm>
using namespace std;

int N;
int numbers[1000];
bool isVisited[1000];
int maxAns;

void combination(int start, int cnt, int arr[]);
void permutation(int cnt, int arr[]);

int main(int argc, char const *argv[])
{
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> numbers[i];
    }
    sort(numbers, numbers + N);

    combination(N - 1, 0, new int[3]);
    // combination(0, 0, new int[3]);
    // permutation(0, new int[3]);
    cout << maxAns;

    return 0;
}

bool IsInNumbers(int arr[])
{
    int sum = arr[0] + arr[1] + arr[2];
    for (int i = N - 1; i >= 0; i--)
    {
        if (sum == numbers[i])
        {
            maxAns = max(maxAns, sum);
            // cout << numbers[i];
            return true;
        }
        else if (sum > numbers[i])
        {
            return false;
        }
    }
    return false;
}

bool isFind;

// 조합
void combination(int start, int cnt, int arr[])
{
    if (cnt == 3)
    {
        // for (int i = 0; i < 3; i++)
        // {
        //     cout << arr[i] << " ";
        // }
        // cout << "\n";
        int sum = arr[0] + arr[1] + arr[2];
        if (binary_search(numbers, numbers + N, sum))
        { // 어떤 조합이 더 큰 sum인지 모르자나
            maxAns = max(maxAns, sum);
            isFind = true;
        }
        return;
    }

    // for (int i = start; i < N; i++)
    for (int i = start; i >= 0; i--)
    {
        if (isFind && !cnt)
            break;
        arr[cnt] = numbers[i];
        combination(i - 1, cnt + 1, arr);
        // combination(i + 1, cnt + 1, arr);
    }
}

// 순열 큰거부터
void permutation(int cnt, int arr[])
{
    if (cnt == 3)
    {
        // for (int i = 0; i < 3; i++)
        // {
        //     cout << arr[i] << " ";
        // }
        // cout << "\n";
        int sum = arr[0] + arr[1] + arr[2];
        if (binary_search(numbers, numbers + N, sum)) // 어떤 조합이 더 큰 sum인지 모르자나
            maxAns = max(maxAns, sum);
        return;
    }

    for (int i = N - 2; i >= 0; i--)
    {
        if (isFind && !cnt)
            break;
        if (isVisited[i])
            continue;
        isVisited[i] = true;
        arr[cnt] = numbers[i];
        permutation(cnt + 1, arr);
        isVisited[i] = false;
    }
}