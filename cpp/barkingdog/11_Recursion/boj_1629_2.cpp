#include <iostream>
using namespace std;

int func(int a, int b, int c)
{
    if (b == 1)
    {
        return a % c;
    }
    int k = func(a, b / 2, c);
    long long ans = (long long)k * k % c;
    if (b % 2 == 0)
        return ans % c;
    else
        return ans * a % c;
}

int main()
{
    int a, b, c;
    cin >> a >> b >> c;
    cout << func(a, b, c) << "\n";
}
