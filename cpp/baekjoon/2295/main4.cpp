#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N;
int numbers[1000];
vector<int> sumTwo;

int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> numbers[i];
    }

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            sumTwo.push_back(numbers[i] + numbers[j]);
        }
    }
    sort(sumTwo.begin(), sumTwo.end());

    sort(numbers, numbers + N);

    int n3;
    for (int i = N - 1; i >= 0; i--)
    { // 세수의 합이 numbers[i]인지
        for (int n1 = 0; n1 < N - 1; n1++)
        { // first number
            if (binary_search(sumTwo.begin(), sumTwo.end(), numbers[i] - numbers[n1]))
            {
                cout << numbers[i];
                return 0;
            }
        }
    }

    return 0;
}
