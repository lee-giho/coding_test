# 📋 그룹 단어 체커
- Link<br>
https://www.acmicpc.net/problem/1316
- 풀이 날짜<br>
2025.09.05

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 단어의 개수 (N ≤ 100)
- 둘째 줄부터 N개의 줄<br>
word: 그룹 단어인지 확인할 단어 (최대 길이: 100, 소문자)

### 출력값
- 그룹 단어의 개수 출력

## 📝 코드 설계하기
N: 단어의 개수<br>
L: 단어 하나의 길이(최대 100)

1. 단어 개수 N을 입력받는다. O(1)
2. 각 단어에 대해 반복한다. O(NL)<br>
알파벳을 나타내는 26 크기의 배열을 초기화<br>
문자를 가져오며 나타났던 문자인지 확인<br>
나타나지 않았던 문자면 그룹 단어 개수 +1
3. 총 그룹 단어 개수를 출력한다. O(1)

총 시간 복잡도 = O(NL)

## ✅ 정답 코드
```java
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int answer = 0;

    for (int i = 0; i < N; i++) {
      String word = br.readLine();
      if (isGroupWord(word)) {
        answer++;
      }
    }

    System.out.println(answer);
  }

  static boolean isGroupWord(String word) {
    boolean[] used = new boolean[26]; // 한 번 나타난 적이 있는 문자 표시
    int last = -1; // 이전 문자 인덱스

    for (int i = 0; i < word.length(); i++) {
      int current = word.charAt(i) - 'a'; // 알파벳을 인덱스 값으로 바꾸기
      if (current != last) { // 다른 글자가 나오는 순간
        if (used[current]) { // 이전에 나타났던 문자라면 다시 시작
          return false;
        }
        used[current] = true; // 처음 등장하는 문자로 시작
        last = current;
      }
    }
    return true;
  }
}
```