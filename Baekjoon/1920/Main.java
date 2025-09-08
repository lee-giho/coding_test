import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // HashSet에 저장할 정수의 수 N 입력받기

    // 정수 N개를 입력받아 HashSet A에 저장
    StringTokenizer st = new StringTokenizer(br.readLine());
    HashSet<Integer> A = new HashSet<>();
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      A.add(num);
    }

    int M = Integer.parseInt(br.readLine()); // 찾을 정수의 수 M 입력받기

    // M개의 정수가 A에 존재하는지 확인
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      int n = Integer.parseInt(st.nextToken());
      if (A.contains(n)) {
        sb.append(1).append("\n"); // 존재하면 1
      } else {
        sb.append(0).append("\n"); // 존재하지 않으면 0
      }
    }

    System.out.println(sb.toString());
  }
}