#include <iostream>
using namespace std;

int main()
{
  int T, W;
  cin >> T >> W;

  int input[T];
  for (int i = 0; i < T; i++)
  {
    cin >> input[i];
  }

  int dp[W + 1][T];

  for (int i = 0; i < T; i++)
  {
    if (input[i] == 1)
    {
      if (i)
      {
        dp[0][i] = dp[0][i - 1] + 1;
      }
      else
      {
        dp[0][0] = 1;
      }
    }
    else
    {
      if (i)
      {
        dp[0][i] = dp[0][i - 1];
      }
      else
      {
        dp[0][0] = 0;
      }
    }
  }

  for (int i = 1; i <= W; i++)
  {
    dp[i][0] = 1;
    for (int j = 1; j < T; j++)
    {
      if (input[j] == input[j - 1])
      {
        dp[i][j] = max(dp[i][j - 1] + 1, dp[i - 1][j - 1]);
      }
      else
      {
        dp[i][j] = max(dp[i][j - 1], dp[i - 1][j - 1] + 1);
      }
    }
  }

  cout << dp[W][T - 1];
  // for (int i = 0; i <= W; i++)
  // {
  //   for (int j = 0; j < T; j++)
  //   {
  //     cout << dp[i][j] << ' ';
  //   }
  //   cout << '\n';
  // }
}