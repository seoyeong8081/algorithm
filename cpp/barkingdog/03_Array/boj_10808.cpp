#include <iostream>
#include <string>
using namespace std;

int ans[26];

int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(NULL);

    string input;
    cin >> input;
    for (char i : input)
    {
        ans[i - 'a']++;
    }

    for (int i : ans)
    {
        cout << i << " ";
    }
    cout << "\n";

    return 0;
}
