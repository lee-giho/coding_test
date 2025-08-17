# 📋 덩치
- Link<br>
https://www.acmicpc.net/problem/7568
- 풀이 날짜<br>
2025.08.17

## 🔎 문제 탐색하기

사람 A의 몸무게 x, 키 y ⇒ A(x, y)<br>
사람 B의 몸무게 x, 키 y ⇒ B(x, y)

Ax > Bx && Ay > By ⇒ A의 덩치가 더 크다.<br>
Ax < Bx && Ay < By ⇒ B의 덩치가 더 크다.<br>
(Ax > Bx && Ay < By) || (Ax < Bx && Ay > By) ⇒ A와 B의 덩치는 같다.

### 입력값
- 첫째 줄<br>
전체 사람의 수 N<br>
(2 ≤ N ≤ 50)
- 둘째 줄부터 N개의 줄<br>
공백으로 구분된 사람의 몸무게 x와 키 y<br>
(10 ≤ x, y ≤ 200)

### 출력값
- 공백으로 구분하여 사람들의 덩치 등수를 입력 순서대로 출력<br>
등수 중복 O<br>
공동 등수는 있으나, 다음 순위는 공동 등수의 바로 다음 수가 아닌 공동 등수의 인원 만큼 밀린 등수<br>
ex) 1등 2등 2등 2등 5등

### 생각해 본 방법
- Person 객체를 만들어 배열에 저장하고, 자신보다 뒤쪽에 있는 사람들과 덩치 비교를 한다.<br>
자신이 더 크면 상대방의 패배 수를 +1 하고, 상대방이 더 크면 자신의 패배 수를 +1 한다.<br>
비교를 마친 후 나열된 순서로 덩치 순위를 출력한다.

## 📝 코드 설계하기
1. 몸무게와 키, 패배 수 필드를 가진 Person 객체를 정의합니다.
2. 문제의 Input을 받습니다. O(N)
3. 전체 사람의 수 N을 저장합니다. O(1)
4. 둘째 줄부터 N개의 줄의 값으로 Person 객체를 생성하며 Map에 저장합니다. O(N)
5. 나열된 순서로 자신의 뒷 사람과 덩치를 비교합니다. O(N^2)
6. 나열된 순서로 덩치 순위를 출력합니다. O(N)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  
  static class Person { // Person 객체
    private int weight;
    private int height;
    private int ranking;

    Person(int weight, int height) { // 생성자
      this.weight = weight;
      this.height = height;
      this.ranking = 1; // 기본값 1
    }

    public int getWeight() {
      return this.weight;
    }

    public int getHeight() {
      return this.height;
    }

    public int getRanking() {
      return this.ranking;
    }

    public void increaseRanking() { // ranking 필드 값 +1하는 메서드
      this.ranking++;
    }
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음
    StringTokenizer st = new StringTokenizer(br.readLine()); // 공백을 기준으로 잘라주는 st 생성
    
    int n = Integer.parseInt(st.nextToken()); // 사람수 N, 정수로 형변환 후 입력

    Person[] persons = new Person[n]; // 사람수 N명에 대한 배열
    for (int i = 0; i < n; i++) { // 입력받은 몸무게와 키로 Person 객체 생성 후 배열에 저장
      st = new StringTokenizer(br.readLine());
      int weight = Integer.parseInt(st.nextToken());
      int height = Integer.parseInt(st.nextToken());
      persons[i] = new Person(weight, height);
    }

    compareFrame(persons, n); // 덩치 비교

    for (int i = 0; i < n; i++) { // 사람들의 순위 출력
      System.out.print(persons[i].getRanking() + " ");
    }
    System.out.println();
  }

	// 덩치 비교 메서드
  public static void compareFrame(Person[] persons, int n) {
    for (int i = 0; i < n-1; i++) { // 첫 번째 사람부터 n-1 번째 사람까지
      for (int j = i+1; j < n; j++) { // 자신보다 뒤에 있는 사람들과 비교
        Person A = persons[i]; // 자신
        Person B = persons[j]; // 자신의 뒤에 있는 사람

        if (A.getWeight() > B.getWeight() && A.getHeight() > B.getHeight()) { // A가 B보다 덩치가 클 경우
          B.increaseRanking(); // B의 순위에 +1
        } else if (A.getWeight() < B.getWeight() && A.getHeight() < B.getHeight()) { // B가 A보다 덩치가 클 경우
          A.increaseRanking(); // A의 순위에 +1
        }
      }
    }
  }
}
```