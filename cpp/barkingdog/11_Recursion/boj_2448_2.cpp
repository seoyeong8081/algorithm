#include <iostream>
#include <string>
using namespace std;
// 시간 어떻게 줄이지???
string result[3 * (1 << 10)];

void func(int N)
{
    if (N == 3)
    {
        result[0] = "  *  ";
        result[1] = " * * ";
        result[2] = "*****";
        return;
    }
    int halfN = N / 2;
    func(halfN);
    for (int i = halfN; i < N; i++)
    {
        result[i] = result[i - halfN] + " " + result[i - halfN];
    }
    for (int i = 0; i < halfN; i++)
    {
        result[i] = string(halfN, ' ') + result[i] + string(halfN, ' ');
    }
    return;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int N;
    cin >> N;
    func(N);
    for (int i = 0; i < N; i++)
    {
        cout << result[i] << "\n";
    }
}