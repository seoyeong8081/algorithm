#include <stack>
#include <iostream>
using namespace std;

void test(){
  stack<int> s;
  s.push(5); s.push(4); s.push(3);
  cout << s.top() << '\n'; // 3
  s.pop(); s.pop();
  cout << s.top() << '\n'; // 5
  s.push(10); s.push(12);
  cout << s.top() << '\n'; // 12
  s.pop();
  cout << s.top() << '\n'; // 10
}

int main(void) {
	test();
}