#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
// 53% 시간초과

int N;
int numbers[1000];

int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> numbers[i];
    }

    sort(numbers, numbers + N);

    int n3;
    for (int i = N - 1; i >= 0; i--)
    { // 세수의 합이 numbers[i]인지
        for (int n1 = 0; n1 < N - 1; n1++)
        { // first number
            for (int n2 = 0; n2 < N - 1; n2++)
            {
                n3 = numbers[i] - numbers[n1] - numbers[n2];
                if (binary_search(numbers, numbers + (N - 1), n3))
                {
                    cout << numbers[i];
                    return 0;
                }
            }
        }
    }

    return 0;
}
