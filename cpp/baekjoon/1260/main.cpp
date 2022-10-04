// #include "node.h"
#include <iostream>
// #include <vector>
// #include <sstream>
#include <queue>
using namespace std;
// 시간초과
class Node
{
public:
  int index;
  Node *next;

public:
  Node(int idx, Node *next);
  ~Node();

  void setIndex(int idx)
  {
    this->index = idx;
  }

  void setNext(Node *n)
  {
    this->next = n;
  }
};

// vector<string> split(string str, char delimiter);
void dfs(int idx, Node **adjList, bool *flag);
void bfs(int idx, Node **adjList, bool *isVisited);

int main(int argc, const char **argv)
{
  int N, M, V;
  int from, to;
  cin >> N >> M >> V;

  Node *adjList[N + 1];
  for (int i = 0; i < N + 1; i++)
  {
    adjList[i] = NULL;
  }

  Node *tmp;
  Node *tmpBef;
  for (int i = 0; i < M; i++)
  {
    cin >> from >> to;

    tmp = adjList[from];
    tmpBef = adjList[from];
    while (tmp != NULL && tmp->index <= to)
    {
      tmpBef = tmp;
      tmp = tmp->next;
    }

    if (tmpBef == adjList[from] && tmp == adjList[from])
    // if (tmpBef == NULL)
    {
      adjList[from] = new Node(to, tmp);
    }
    else
    {
      tmpBef->setNext(new Node(to, tmp));
    }

    tmp = adjList[to];
    tmpBef = adjList[to];
    while (tmp != NULL && tmp->index <= from)
    {
      tmpBef = tmp;
      tmp = tmp->next;
    }

    if (tmpBef == adjList[to] && tmp == adjList[to])
    // if (tmpBef == NULL)
    {
      adjList[to] = new Node(from, tmp);
    }
    else
    {
      tmpBef->setNext(new Node(from, tmp));
    }
  }

  // // for debugging
  // for (int i = 1; i <= N; i++)
  // {

  //   for (Node *tmp = adjList[i]; tmp != NULL; tmp = tmp->next)
  //   {
  //     cout << tmp->index << " ";
  //   }
  //   cout << endl;
  // }

  bool *flagDfs = new bool[N + 1];
  bool *flagBfs = new bool[N + 1];
  for (int i = 0; i < N + 1; i++)
  {
    flagDfs[i] = false;
    flagBfs[i] = false;
  }

  dfs(V, adjList, flagDfs);
  cout << endl;
  bfs(V, adjList, flagBfs);
  cout << endl;

  return 0;
}

void dfs(int idx, Node **adjList, bool *flag)
{
  flag[idx] = true;
  cout << idx << " ";

  for (auto tmp = adjList[idx]; tmp != NULL; tmp = tmp->next)
  {
    if (flag[tmp->index])
      continue;
    dfs(tmp->index, adjList, flag);
  }
}

void bfs(int idx, Node **adjList, bool *isVisited)
{
  queue<int> queue;
  isVisited[idx] = true;
  queue.push(idx);

  while (!queue.empty())
  {
    int visit = queue.front();
    queue.pop();
    cout << visit << " ";

    for (auto tmp = adjList[visit]; tmp != NULL; tmp = tmp->next)
    {
      if (isVisited[tmp->index])
        continue;
      isVisited[tmp->index] = true;
      queue.push(tmp->index);
    }
  }
}

Node::Node(int idx, Node *next)
{
  this->index = idx;
  this->next = next;
}

Node::~Node()
{
}

// int main() {
// string user_input;
// vector<string> words;

// getline(cin, user_input);
// words = split(user_input, ' ');
// for (int i = 0; i < words.size(); i++) {
// cout << words[i] << endl;
// }
// }

// vector<string> split(string input, char delimiter) {
// vector<string> result;
// stringstream ss(input);
// string temp;

// while (getline(ss, temp, delimiter)) {
// result.push_back(temp);
// }

// return result;
// }