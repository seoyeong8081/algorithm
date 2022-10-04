// boj 2295 세수의 합
#include <iostream>
#include <algorithm>
using namespace std;

int N;
int numbers[1000];
int sumThree[998];
bool isVisited[1000];
int tmpSum;

// 순열 작은 거부터
void permutation(int cnt, int arr[], int range)
{
    if (cnt == 3)
    {
        // cout << tmpSum << "\n";
        // for (int i = 0; i < 3; i++)
        // {
        //     cout << arr[i] << " ";
        // }
        // cout << "\n";
        if (tmpSum == arr[0] + arr[1] + arr[2])
        {
            cout << tmpSum;
            exit(0);
        }
        return;
    }

    for (int i = 0; i < range; i++)
    {
        if (isVisited[i])
            continue;
        isVisited[i] = true;
        arr[cnt] = numbers[i];
        permutation(cnt + 1, arr, range);
        isVisited[i] = false;
    }
}

// bool existSum(int sumIdx)
// {
//     int minSum = numbers[0] + numbers[1] + numbers[2];
//     int maxSum = numbers[sumIdx - 1] + numbers[sumIdx - 2] + numbers[sumIdx - 3];
//     if (numbers[sumIdx] < minSum || numbers[sumIdx] > maxSum)
//     {
//         return false;
//     }

//     for (int i = N - 1; i >= 0; i--)
//     {
//         if (sum == numbers[i])
//         {
//             maxAns = max(maxAns, sum);
//             // cout << numbers[i];
//             return true;
//         }
//         else if (sum > numbers[i])
//         {
//             return false;
//         }
//     }
//     return false;
// }

int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> numbers[i];
    }
    sort(numbers, numbers + N);
    for (int i = 2; i < N; i++)
    {
        sumThree[i - 2] = numbers[i - 2] + numbers[i - 1] + numbers[i];
    }

    for (int i = N - 1; i >= 0; i--)
    {
        int minSum = numbers[0] + numbers[1] + numbers[2];
        int maxSum = numbers[i - 1] + numbers[i - 2] + numbers[i - 3];
        if (numbers[i] < minSum || numbers[i] > maxSum)
        {
            continue;
        }
        tmpSum = numbers[i];
        // cout << tmpSum;
        permutation(0, new int[3], i);
        isVisited[i - 1] = isVisited[i - 2] = isVisited[i - 3] = false;
    }

    return 0;
}

// bool IsInNumbers(int arr[])
// {
//     int sum = arr[0] + arr[1] + arr[2];
//     for (int i = N - 1; i >= 0; i--)
//     {
//         if (sum == numbers[i])
//         {
//             maxAns = max(maxAns, sum);
//             // cout << numbers[i];
//             return true;
//         }
//         else if (sum > numbers[i])
//         {
//             return false;
//         }
//     }
//     return false;
// }

// bool isFind;
