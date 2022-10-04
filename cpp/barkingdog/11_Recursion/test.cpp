#include <iostream>
using namespace std;

void func(int a)
{
    if (a == 0)
        return;
    func(a - 1);
}

int main()
{
    func(10000);
    cout << "done";
    return 0;
}
