#include <iostream>
#include <string>
using namespace std;

string *func(int N)
{
    if (N == 3)
    {
        string *triangle = new string[3];
        triangle[0] = "  *  ";
        triangle[1] = " * * ";
        triangle[2] = "*****";
        return triangle;
    }
    int halfN = N / 2;
    string *unit = func(halfN);
    string *ans = new string[N];
    for (int i = 0; i < halfN; i++)
    {
        ans[i] = string(halfN, ' ') + unit[i] + string(halfN, ' ');
    }
    for (int i = halfN; i < N; i++)
    {
        ans[i] = unit[i - halfN] + ' ' + unit[i - halfN];
    }
    delete[] unit;
    return ans;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int N;
    cin >> N;
    string *ans = func(N);
    for (int i = 0; i < N; i++)
    {
        cout << ans[i] << "\n";
    }
}