# 📋 나이순 정렬
- Link<br>
https://www.acmicpc.net/problem/10814
- 풀이 날짜<br>
2025.08.12

## 🔎 문제 탐색하기

### 입력값
- 가입한 순서로 입력됨
- 첫째 줄: 회원 수 N<br>
(1 <= N <= 100,000)
- 둘째 줄부터 N개의 줄: 공백으로 구분된 회원의 나이와 이름<br>
(1 <= 나이 <= 200, 정수)<br>
(이름.length() <= 100, 문자열)


### 출력값
- N개의 줄에 걸쳐 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력
- 기본적으로 나이순, 같으면 가입한순으로 출력

### 생각해 본 방법
- String[N][2], 2차원 배열을 통해 첫 번째 요소를 오름차순으로 정렬
- TreeMap<int, List\<String>>으로 나이와 이름을 순서대로 저장<br>
key 값인 나이를 기준으로 오름차순 정렬<br>
같은 나이가 있을 경우를 위해 이름은 List\<String>

## 📝 코드 설계하기
### 2차원 배열
1. 문제의 Input을 받습니다.
2. 첫째 줄의 회원수 n을 저장합니다.
3. 둘째 줄부터 N개의 줄을 2차원 배열에 저장합니다.
4. 2차원 배열의 첫 번째 요소를 오름차순으로 정렬합니다.
5. 정렬된 2차원 배열을 나이와 이름을 공백으로 구분해 출력합니다.

### TreeMap
1. 문제의 Input을 받습니다.
2. 첫째 줄의 회원수 n을 저장합니다.
3. 둘째 줄부터 N개의 줄을 TreeMap에 저장합니다.<br>
TreeMap은 레드-블랙 트리 구조로 인해 key를 기준 오름차순으로 정렬된 상태를 유지함
4. TreeMap을 나이와 이름을 공백으로 구분해 출력합니다.

## 🔧 시도 회차 수정 사항
### 1회차
- 작성한 코드에서 사용한 패키지 import 누락<br>
java.io.\*과 java.util.\* import 하도록 수정

### 2회차
- 나이순 오름차순 정렬을 정수 정렬이 아닌 문자열 정렬로 해서 실패
```java
// 기존 코드 (문자열 정렬)
Arrays.sort(users, (o1, o2) -> {
  return o1[0].compareTo(o2[0]);
});

// 수정한 코드 (정수로 형변환 후 정수 비교)
Arrays.sort(users, (o1, o2) -> {
  return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
});
```

### 3회차
2차원 배열을 사용한 코드에서 TreeMap을 사용한 코드로도 수정해봐서 성공함

## ✅ 정답 코드
- 2차원 배열 사용
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음
    StringTokenizer st = new StringTokenizer(br.readLine()); // 공백을 기준으로 잘라주는 st 생성

    int n = Integer.parseInt(st.nextToken()); // 회원수 N 정수로 형변환 후 입력
    
    String[][] users = new String[n][2]; // 회원수 N명에 대한 2차원 배열
    for (int i = 0; i < n; i++) { // 회원의 나이와 이름을 2차원 배열에 저장
      st = new StringTokenizer(br.readLine());
      users[i][0] = st.nextToken(); // 나이
      users[i][1] = st.nextToken(); // 이름
    }

    Arrays.sort(users, (o1, o2) -> { // 정수 비교 후 오름차순 정렬
      return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
    });

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
    for (int i = 0; i < n; i++) {
      bw.write(users[i][0] + " " + users[i][1]); // 이름과 나이를 공백으로 구분해 출력
      bw.newLine(); // 줄바꿈
    }
    bw.close();
  }
}
```

- TreeMap 사용
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음
    StringTokenizer st = new StringTokenizer(br.readLine()); // 공백을 기준으로 잘라주는 st 생성

    int n = Integer.parseInt(st.nextToken()); // 회원수 N 정수로 형변환 후 입력
    
    TreeMap<Integer, List<String>> users = new TreeMap<>(); // 회원을 저장할 map
    for (int i = 0; i < n; i++) { // 회원의 나이와 이름을 map에 저장
      st = new StringTokenizer(br.readLine());
      int age = Integer.parseInt(st.nextToken());
      String name = st.nextToken();
      users.computeIfAbsent(age, k -> new ArrayList<>()).add(name); // key 값에 해당하는 value가 존재하면 가져와서 사용하고 없으면 새로 만듦
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
    for (Map.Entry<Integer, List<String>> user : users.entrySet()) { // map에 저장된 (key, value) 쌍을 Set 형태로 가져오기
      int age = user.getKey();
      for (String name : user.getValue()) { // 같은 나이로 저장된 이름 리스트 가져오기
        bw.write(age + " " + name);
        bw.newLine();
      }
    }
    bw.close();
  }
}
```