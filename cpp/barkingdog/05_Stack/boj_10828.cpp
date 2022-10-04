#include <stack>
#include <iostream>
#include <string>
using namespace std;

int stackA[100000];
int pos;

void push(int i) {
    stackA[pos++] = i;
}

int pop() {
    if (pos > 0) {
        return stackA[--pos];
    } else {
        return -1;
    }
}

int size() {
    return pos;
}

bool empty() {
    return pos > 0 ? 0 : 1;
}

int top() {
    if (pos > 0) {
        return stackA[pos - 1];
    } else {
        return -1;
    }
}

void command() {
    string cmd;
    cin >> cmd;
    if (cmd == "push") {
        int x;
        cin >> x;
        push(x);
    } else if (cmd == "pop") {
        cout << pop() << "\n";
    } else if (cmd == "size") {
        cout << size() << "\n";
    } else if (cmd == "empty") {
        cout << empty() << "\n";
    } else if (cmd == "top") {
        cout << top() << "\n";
    }

}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    int N;
    cin >> N;
    for (int i = 0; i < N; i++) {
        command();
    }
}