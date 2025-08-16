# 📋 나무 조각
- Link<br>
https://www.acmicpc.net/problem/2947
- 풀이 날짜<br>
2025.08.16

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
5개의 나무 조각에 적힌 숫자 num<br>
중복 X<br>
1, 2, 3, 4, 5로 정렬되어 있는 순서 X<br>
(1 ≤ num ≤ 5)

### 출력값
- 두 조각의 순서가 바뀔 때마다 5개의 숫자 출력

### 생각해 본 방법
- 버블 정렬<br>
5개의 숫자를 배열에 저장한 뒤, 버블 정렬을 통해 바뀔 때마다 출력

## 📝 코드 설계하기
1. 문제의 Input을 받습니다. O(n) => n=5, O(1)
2. 공백으로 구분된 5개 나무 조각에 적힌 숫자를 배열에 저장합니다. O(n) => n=5, O(1)
3. 버블 정렬을 통해 조건에 맞게 정렬합니다.<br> O(n^2) => n=5, O(1)
정렬 과정에서 두 숫자의 자리가 바뀌면 5개의 숫자를 출력합니다. O(n) => n=5, O(1)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음
    StringTokenizer st = new StringTokenizer(br.readLine()); // 공백을 기준으로 잘라주는 st 생성

    int n = st.countTokens(); // 나무 조각 수 n

    int[] nums = new int[n]; // 나무 조각 n개에 대한 배열
    for (int i = 0; i < n; i++) { // 나무 조각을 배열에 저장
      nums[i] = Integer.parseInt(st.nextToken());
    }

    bubbleSort(nums, n); // 버블 정렬 수행
  }

  public static void bubbleSort(int[] arr, int n) throws IOException { // 버블 정렬 메서드
    int temp = 0; // 임시로 값을 저장할 변수
    for (int i = 0; i < n-1; i++) { // 배열의 크기만큼 반복
      for (int j = 1; j < n-i; j++) { // 마지막 요소부터 큰 수로 바뀌기 때문에 n-i까지 반복
        if (arr[j-1] > arr[j]) { // 두 수 중 앞의 요소가 더 클 경우 자리 교환
          temp = arr[j];
          arr[j] = arr[j-1];
          arr[j-1] = temp;
          printWoodsNumber(arr, n); // 배열 출력
        }
      }
    }
  }

  public static void printWoodsNumber(int[] arr, int n) throws IOException { // n개의 나무 조각 숫자 전부 출력하는 메서드
    for (int i = 0; i < n; i++) { // 공백으로 구분해 한 줄로 출력
      System.out.print(arr[i] + " ");
    }
    System.out.println(); // 줄바꿈
  }
}
```