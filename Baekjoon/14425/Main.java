import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 집합에 포함된 문자열의 개수
    int M = Integer.parseInt(st.nextToken()); // 검사할 문자열의 개수

    HashSet<String> set = new HashSet<>(N*2); // 집합 S

    // 집합 S에 문자열 입력
    for (int i = 0; i < N; i++) {
      set.add(br.readLine());
    }

    // 집합 S에 포함되어 있는 문자열 개수 세기
    int count = 0;
    for (int i = 0; i < M; i++) {
      if (set.contains(br.readLine())) count++;
    }

    System.out.println(count);
  }
}