#include <iostream>
#include <algorithm>
using namespace std;

void swap(int *arr, int i, int j)
{
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

bool nextPermutation(int *arr, int size)
{
    // 꼭대기 찾기
    int i = size - 1;
    while (i > 0 && arr[i - 1] >= arr[i])
        i--;
    if (i == 0)
        return false;

    // 바꿀애 찾기
    int j = size - 1;
    while (arr[i - 1] >= arr[j])
        j--;

    // i-1 j swap
    swap(arr, i - 1, j);

    // i부터 오름차순
    int k = size - 1;
    while (i < k)
        swap(arr, i++, k--);
    return true;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int N = 4;
    int arr[N];
    for (int i = 0; i < N; i++)
    {
        arr[i] = i + 1;
    }
    arr[0] = 2;
    arr[1] = 1;
    sort(arr, arr + N);

    int cnt = 0;
    do
    {
        cnt++;
        for (int i = 0; i < N; i++)
        {
            cout << arr[i] << " ";
        }
        cout << "\n";
    } while (nextPermutation(arr, N));

    cout << "total num : " << cnt << "\n";
}