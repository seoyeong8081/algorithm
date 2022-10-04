#include <stack>
#include <iostream>
#include <string>
using namespace std;

stack<int> myStack;

void command() {
    string cmd;
    cin >> cmd;
    if (cmd == "push") {
        int x;
        cin >> x;
        myStack.push(x);
    } else if (cmd == "pop") {
        if (myStack.empty()) cout << -1 << "\n";
        else {
            cout << myStack.top() << "\n";
            myStack.pop();
        }
    } else if (cmd == "size") {
        cout << myStack.size() << "\n";
    } else if (cmd == "empty") {
        cout << myStack.empty() << "\n";
    } else if (cmd == "top") {
        if (myStack.empty()) cout << -1 << "\n";
        else {
            cout << myStack.top() << "\n";
        }
    }

}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    int N;
    cin >> N;
    while(N--) {
        command();
    }
}