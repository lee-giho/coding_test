  import java.io.*;
  import java.util.*;

  public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      StringTokenizer st = new StringTokenizer(br.readLine());
      int aSize = Integer.parseInt(st.nextToken()); // 집합 A의 원소 개수 입력
      int bSize = Integer.parseInt(st.nextToken()); // 집합 B의 원소 개수 입력

      // 집합 A 입력
      HashSet<Integer> setA = new HashSet<>();
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < aSize; i++) {
        setA.add(Integer.parseInt(st.nextToken()));
      }

      // 집합 B의 요소 입력 받으며 교집합 크기 구하기
      int intersection = 0; // 교집합 크기
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < bSize; i++) {
        int n = Integer.parseInt(st.nextToken());
        if (setA.contains(n)) {
          intersection++;
        }
      }

      int answer = aSize + bSize - 2 * intersection;
      System.out.println(answer);
    }
  }