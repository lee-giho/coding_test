# 📋 단어 정렬
- Link<br>
https://www.acmicpc.net/problem/1181
- 풀이 날짜<br>
2025.08.13

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
단어의 개수 N (1 <= N <= 20,000)
- 둘째 줄부터 N개의 줄<br>
알파벳 소문자로 이루어진 한 단어 (단어.length() < 50, 문자열)

### 출력값
- N개의 줄에 걸쳐 한 줄에 한 단어로, 짧은 길이 순으로 출력
- 길이가 같으면 사전 순으로 출력
- 단어 중복 X

### 생각해 본 방법
- 배열에 저장하여 중복제거 후 두 가지 조건에 맞는 정렬 수행

## 📝 코드 설계하기
1. 문제의 Input을 받습니다.
2. 첫째 줄의 문자수 n을 저장합니다.
3. 배열에 Input을 저장하고 중복 제거를 합니다.
4. Array.sort를 통해 단어 길이와 사전 순 조건으로 정렬합니다.
5. 조건에 맞게 정렬된 배열을 출력합니다.

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력 받음

    int n = Integer.parseInt(br.readLine()); // 단어 수 N 정수로 형변환 후 입력

    String[] words = new String[n]; // 단어 수 N개에 대한 배열
    for (int i = 0; i < n; i++) { // 배열에 단어 저장
      words[i] = br.readLine();
    }
    
    words = Arrays.stream(words).distinct().toArray(String[]::new); // 배열 요소 중복 제거

    Arrays.sort(words, (o1, o2) -> { // 배열 정렬
      int o1L = o1.length();
      int o2L = o2.length();
      if (o1L == o2L) {  // 문자의 길이가 같은 경우
        return o1.compareTo(o2); // 사전 순으로 정렬
      } else {
        return o1L - o2L; // 문자 길이 순으로 정렬
      }
    });

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 0; i < words.length; i++) {
      bw.write(words[i]); // 단어 출력
      bw.newLine(); // 줄바꿈
    }
    bw.close();
  }
}
```