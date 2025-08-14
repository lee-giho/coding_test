# 📋 생일
- Link<br>
https://www.acmicpc.net/problem/5635
- 풀이 날짜<br>
2025.08.14

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
학생 수 n (1 <= n <= 100)
- 둘째 줄부터 n개의 줄<br>
학생의 이름과 생일<br>
"이름 dd mm yy"<br>
(이름.length() <= 15)<br>
(1990 ≤ yyyy ≤ 2010, 1 ≤ mm ≤ 12, 1≤ dd ≤ 31)
- 이름이 같거나, 생일이 같은 사람 X

### 출력값
- 첫째 줄<br>
가장 나이가 적은 사람 이름
- 둘째 줄<br>
가장 나이가 많은 사람 이름

### 생각해 본 방법
- 2차원 배열에 이름, 생일로 저장 후 생일을 기준으로 내림차순 정렬하기<br>
- 객체 생성 후 1차원 배열에 저장, 생일을 기준으로 내림차순 정렬하기<br>

생일을 yyyymmdd로 포맷을 맞춘 후 정수 비교를 통해 나이 순 정렬<br>
ex) 4 9 1995 => 19950904

## 📝 코드 설계하기
### 2차원 배열 사용
1. 문제의 Input을 받습니다.
2. 첫째 줄의 학생수 n을 저장합니다.
3. 둘째 줄부터 n개의 줄을 2차원 배열에 저장합니다.
4. Arrays.sort를 통해 생일을 기준으로 내림차순 정렬합니다.
5. 조건에 맞게 배열의 맨 앞/뒤 요소를 출력합니다.

### 객체와 1차원 배열 사용
1. 이름과 생일 필드를 가진 Person 객체를 생성합니다.
2. 문제의 Input을 받습니다.
3. 첫째 줄의 학생수 n을 저장합니다.
4. 둘째 줄부터 n개의 줄을 객체로 만들고 1차원 배열에 저장합니다.
5. Arrays.sort를 통해 생일 기준으로 내림차순 정렬합니다.
6. 조건에 맞게 배열의 맨 앞/뒤 요소를 출력합니다.

## 🔧 시도 회차 수정 사항
### 1회차
- 2차원 배열을 만들어 이름과 생일 저장, 생일을 기준으로 내림차순 정렬

### 2회차
- 이름과 생일 필드를 가진 Person 객체를 통해 1차원 배열로 저장, 생일을 기준으로 내림차순 정렬

## ✅ 정답 코드
- 2차원 배열 사용
```java
import java.util.*;
import java.io.*;

public class Main1 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음
    StringTokenizer st = new StringTokenizer(br.readLine()); // 공백을 기준으로 잘라주는 st 생성

    int n = Integer.parseInt(st.nextToken()); // 학생수 N, 정수로 형변환 후 입력

    String[][] birthdays = new String[n][2]; // 학생수 N명에 대한 2차원 배열
    for (int i = 0; i < n; i++) { // 학생의 이름과 생일을 2차원 배열에 저장
      st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      String day = changeToTwoLetters(st.nextToken());
      String month = changeToTwoLetters(st.nextToken());
      String year = st.nextToken();

      birthdays[i][0] = name;
      birthdays[i][1] = year + month + day; // yyyymmdd로 저장
    }

    Arrays.sort(birthdays, (o1, o2) -> { // 정수 비교 후 내림차순 정렬
      // yyyymmdd 형태로 저장해서 정수값이 클 수록 나이가 적은 사람, 내림차순 정렬을 통해 나이가 적은 생일부터 많은 사람 순으로 정렬됨
      return Integer.compare(Integer.parseInt(o2[1]), Integer.parseInt(o1[1]));
    });

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(birthdays[0][0]); // 가장 나이가 적은 사람의 이름
    bw.newLine();
    bw.write(birthdays[n-1][0]); // 가장 나이가 많은 사람의 이름
    bw.newLine();
    bw.close();
  }

  // month와 day는 1 ~ 9까지 한 자리 수가 될 수 있다. yyyymmdd 형태를 맞춰주기 위해 한 자리 수일 경우 앞에 '0'을 붙여준다.
  public static String changeToTwoLetters(String date) { 
    if (date.length() == 1) { // 한 자리 수일 경우
      date = "0" + date; // 0을 붙여 두 자리로 만들어 반환
    }
    return date;
  }
}
```

- Person 객체와 1차원 배열 사용
```java
import java.util.*;
import java.io.*;

public class Main2 {

  static class Person { // 학생 객체
    String name;
    String birthday;

    Person(String name, String birthday) { // 생성자
      this.name = name;
      this.birthday = birthday;
    }
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음
    StringTokenizer st = new StringTokenizer(br.readLine()); // 공백을 기준으로 잘라주는 st 생성

    int n = Integer.parseInt(st.nextToken()); // 학생수 N, 정수로 형변환 후 입력

    Person[] people = new Person[n]; // 학생수 N명에 대한 1차원 배열
    for (int i = 0; i < n; i++) { // Person 객체에 이름과 생일 저장 후 1차원 배열에 저장
      st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      String day = changeToTwoLetters(st.nextToken());
      String month = changeToTwoLetters(st.nextToken());
      String year = st.nextToken();

      people[i] = new Person(name, year + month + day); // Person 객체 생성 후 1차원 배열에 추가
    }

    Arrays.sort(people, (o1, o2) -> { // 정수 비교 후 내림차순 정렬
      // yyyymmdd 형태로 저장해서 정수값이 클 수록 나이가 적은 사람, 내림차순 정렬을 통해 나이가 적은 생일부터 많은 사람 순으로 정렬됨
      return Integer.compare(Integer.parseInt(o2.birthday), Integer.parseInt(o1.birthday));
    });

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(people[0].name); // 가장 나이가 적은 사람의 이름
    bw.newLine();
    bw.write(people[n-1].name); // 가장 나이가 많은 사람의 이름
    bw.newLine();
    bw.close();
  }

  // month와 day는 1 ~ 9까지 한 자리 수가 될 수 있다. yyyymmdd 형태를 맞춰주기 위해 한 자리 수일 경우 앞에 '0'을 붙여준다.
  public static String changeToTwoLetters(String date) {
    if (date.length() == 1) { // 한 자리 수일 경우
      date = "0" + date; // 0을 붙여 두 자리로 만들어 반환
    }
    return date;
  }
}
```