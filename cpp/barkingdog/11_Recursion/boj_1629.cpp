#include <iostream>
using namespace std;

bool bto2[32];
int aReminderC[32];

int main()
{
    int a, b, c;
    cin >> a >> b >> c;

    aReminderC[0] = a % c;
    for (int i = 1; i < 32; i++)
    {
        aReminderC[i] = ((long long)aReminderC[i - 1] * aReminderC[i - 1]) % c;
    }

    int quotient = b;
    for (int i = 0; i < 32; i++)
    {
        bto2[i] = quotient % 2;
        quotient = quotient / 2;
        if (!quotient)
            break;
    }

    long long value = 1;
    for (int i = 0; i < 32; i++)
    {
        if (bto2[i])
            value = value * aReminderC[i] % c;
    }

    cout << value << "\n";
}
